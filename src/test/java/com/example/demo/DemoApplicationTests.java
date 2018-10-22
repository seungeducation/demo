package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private FileWriter writer = null;

    public void convert(String imgFile) throws IOException {
        //String imgFile = "d:/pic/IMG_20181017_140427.jpg";
        String data = FileUtil.getImageStr(imgFile);
        ImgJsonLayout imgJsonLayout = new ImgJsonLayout();
        imgJsonLayout.setImg(data);

        send(JsonConvertUtils.object2Json(imgJsonLayout, true));

    }

    private void send(String bodys) {
        String host = "https://ocrapi-ugc.taobao.com";
        String path = "/ocrservice/ugc";
        String method = "POST";
        String appcode = "8bcb4ffc3bbb49d2b17873ec2b46c3fc";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();

        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

            createFile(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void readFiles() throws IOException {
        String path = "d:/pic";
        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数：" + tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文     件：" + tempList[i].getPath());
                convert(tempList[i].getPath());

            }
        }

    }

    private void createFile(HttpResponse response) throws IOException {
        //获取response的body
        String entity = EntityUtils.toString(response.getEntity());
        ImgResponse imgResponse = JsonConvertUtils.json2Object(entity, ImgResponse.class);
        StringBuffer stringBuffer = new StringBuffer();
        imgResponse.getPrism_wordsInfo().stream().forEach(w -> {
            stringBuffer.append(w.getWord() + "|");
        });
        if (null == writer) {
            writer = new FileWriter("e:/zhuanhuan.josn", true);
        }
        writer.write(stringBuffer.toString());
        //File file = new File("e:/zhuanhuan.josn");
        // FileUtils.writeStringToFile(file, stringBuffer.toString());
    }
}
