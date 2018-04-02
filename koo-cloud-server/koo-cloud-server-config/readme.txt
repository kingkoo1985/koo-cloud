keytool -genkeypair -alias 别名 -keyalg RSA -keypass 密码 -keystore server.jks -storepass 远程密码
keytool -genkeypair -alias ko-cloud -keyalg RSA -dname "CN=CN,OU=Unit,O=Cloud,L=GZ,S=State,C=CN" -keypass ko-cloud-pass -keystore server.jks -storepass ko-cloud-store



keytool -genkeypair -alias mytestkey -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US" -keypass changeme -keystore server.jks -storepass letmein

#获取密码
curl -X POST http://cloud-config:8800/encrypt -d 密码


git下面
ssh-keygen -t rsa



host 相关配置
127.0.0.1 cloud-eureka	#8761
127.0.0.1 cloud-monitor		#8810
127.0.0.1 cloud-zipkin		#8820
127.0.0.1 cloud-config		#8800
127.0.0.1 cloud-gateway		#8860
127.0.0.1 cloud-uac			#801
127.0.0.1 cloud-mqc			#805
127.0.0.1 cloud-client		#201
127.0.0.1 cloud-mysql		#3306
127.0.0.1 cloud-rabbitmq	#3306