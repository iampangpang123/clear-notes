# clear-notes 项目配置以及相关文档
 clear-notes 有两个寓意
 + clear-notes（干净的笔记，空白的笔记）象征着知识的从无到有，从有到多。根据自己学习的知识，它涉及的知识与技术栈会逐渐完善。
 + clear-notes（清晰的笔记）希望项目里面每个涉及的知识点都能通过笔记代码清晰的表诉出来。
 

#1.常用命令
netstat -ant|grep 8180  查看端口号是否占用  
netstat -ant|grep 8180  查看端口号是否占用  
chmod 777 后面接文件 解决权限不够的问题  
dhclient  刷新网络  
docker exec -it 030 /bin/bash  进入容器内部
docker logs --tail -500f 日志名  进入容器内部
docker start   容器id  
docker stop    容器id  
docker restart 容器id  



#3.服务端口号+启动顺序

###1.clear-notes-web     127.0.0.1：8082     A2
 >
###2.clear-notes-biz     127.0.0.1：8081     A1


   
##注意
>1.Controller
>>1.1:controller我们需要加@CrossOrigin
>>1.2:Controller引用service，不要用@Autowire注解，要用Alibaba的@Reference注解  
>2.Service
>>2.1:Service的实现类一定的@Service注解一定要是Alibaba的@service注解而不是spring的















##########
一、RocketMQ 
   1.1、RocketMQ 官方文档
   https://github.com/apache/rocketmq/tree/master/docs/cn
   
   1.2、RocketMQ  博客
   https://www.cnblogs.com/qdhxhz/p/11094624.html

   1.3、rocketmq window版本安装启动
   https://blog.csdn.net/qq_18603599/article/details/81172866
   
	 启动namesrv
	  mqnamesrv.cmd   -n localhost:9876       或者  start mqnamesrv.cmd 
	 启动brokerserver  必须允许创建主题，不然代码会报找不到主题的错误
	 start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
	 
	  关闭mq
	  mqshutdown.cmd
   
   1.4、rocketmq 与rocketmq客户端    docker安装启动              http://118.31.55.236:8080/#/
     https://www.jb51.net/article/202117.htm
   


	 springboot整个rocketmq
	 https://www.cnblogs.com/qdhxhz/p/11109696.html
	 
	  我的阿里云控制台
	 https://swas.console.aliyun.com/#/server/ce38ae329aca4aff8168a344a3d00a5d/cn-hangzhou/dashboard
	 
二、 Docker安装dubbo    zookeeper 
     安装教程
     2.1、https://blog.csdn.net/weixin_43841693/article/details/103036716	 
	 2.2、启动dubbo控制台的命令
	  
    docker run -it -d --name dubbo-admin -v /usr/local//dubbo-admin:/data -p 8082:8082 -e dubbo.registry.address=zookeeper://172.17.0.5:2181 -e dubbo.admin.root.password=root -e dubbo.admin.guest.password=root chenchuxin/dubbo-admin
三. nacos安装本地版本就行
     nacos的两个项目是user-alibaba-service 、user-alibaba-controller


	 
	 
	 
