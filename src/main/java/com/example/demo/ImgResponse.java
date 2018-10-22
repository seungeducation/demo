package com.example.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ImgResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            sid;

    private String            prism_version;

    private int               prism_wnum;

    private List<WordsInfo>   prism_wordsInfo;

}

@Setter
@Getter
@ToString
class WordsInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            word;

    private List<Pos>         position;

    @Setter
    @Getter
    @ToString
    class Pos implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private int               x;
        private int               y;
    }
}
