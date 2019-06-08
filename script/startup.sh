start

###################################
#(函数)启动程序
###################################
start() {

	echo "############start begin"
	checkpid
	if [ $psid -ne 0 ]; then
		echo "================================"
		echo "WARN: $PROJECT_NAME already started... (pid=$psid).Please check..."
		echo "================================"
	else
		echo "starting..."
		nohup  java -jar -Dserver.port=9999 -Dspring.profiles.active=local -server -Xms2048m -Xmx2048m -Xmn800m -XX:MaxMetaspaceSize=256m -Xss256k -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=80  -XX:+UseCMSInitiatingOccupancyOnly -XX:AutoBoxCacheMax=20000 -XX:-OmitStackTraceInFastThrow  /data/www/demo/demo.jar >  /data/www/demo/demo.log  &
		sleep 3s
		checkpid
		if [ $psid -ne 0 ]; then
			echo "started... (pid=$psid)"
		else
			echo "[Failed]"
		fi
	fi
	echo "############start end"
}

###################################
#(函数)判断程序是否已启动
###################################
psid=0
checkpid(){
	javaps=`ssh $TARGET_IP_USER@$TARGET_IP $SOURCE'jps -l | grep '$PROJECT_NAME`
 
	if [ -n "$javaps" ]; then
		psid=`echo $javaps | awk '{print $1}'`
	else
		psid=0
	fi
	echo "PSID:$psid"
}