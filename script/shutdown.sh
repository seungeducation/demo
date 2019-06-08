# 停止
stop


###################################
#(函数)停止程序
###################################
stop() {
	if [[ $IS_RELEASE_PROMPT == "true" ]]; then
		while(( 1 == 1 ))  
		do
			read -p  "stop service $TARGET_IP?(Y/N)" in
			if [[ "${USER_INPUT[@]}" =~ $in ]] ; then
				if [[ $in == "N" ]] ; then
					return
				else
					break
				fi
			else
				echo "......only input : ${USER_INPUT[@]}"
			fi
		done 
	fi
	echo "############stop begin"
	checkpid
	if [ $psid -ne 0 ]; then
		echo  "Stopping ... (pid=$psid) "
		if [ $psid -ne 0 ]; then
			echo "kill $psid"
			ssh $TARGET_IP_USER@$TARGET_IP $SOURCE'kill '$psid
			sleep 5s
			checkpid
			if [ $psid -ne 0 ]; then
				echo "kill -9 $psid"
				ssh $TARGET_IP_USER@$TARGET_IP $SOURCE'kill -9 '$psid
			fi
		fi
	else
		echo "================================"
		echo "WARN: $PROJECT_NAME is not running"
		echo "================================"
	fi
	echo "############stop end"
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