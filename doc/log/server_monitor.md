1.Nagios监控系统
Nagios是一个监视系统运行状态和网络信息的监视系统。方便管理人员查看系统的运行状态，网络状态，服务状态，日志信息以及其他异常现象。
Nagios可实现的功能特性
监控网络服务(SMTP、POP3、HTTP、FTP、PING等);
监控本机及远程主机资源(CPU负荷、磁盘利用率、进程等);
允许用户编写自己的插件来监控特定的服务，方便扩展自己服务的检查方法，支持多种开发语言(Shell、Perl、Python、PHP等);
具备定义网络分层结构的能力，用”parent”主机定义来表达网络主机间的关系，通过这种关系可被用来发现和明晰主机岩机或者不可达状态;
当服务或主机问题产生与解决时将告警发送给联系人(通过email,短信，用户定义方式);
可以支持并实现住主机的冗余监控;
可用WEB界面用来查看当前的网络状态、通知和故障历史、日志文件等;
Nagios大致的原理：
	首先单独安装一个监控中心(即Server端)，然后在需要被监控的服务上安装一个监控代理软件(即agent)作为后台程序运行，
监控中心服务读取配置文件中的指令与远程的守护程序进行通讯，并且只是远程的守护程序进行必要的检查。
Nagios安装和使用详见:http://www.ibm.com/developerworks/cn/linux/1309_luojun_nagios/

2.Zabbix分布式监控系统
Zabbix是基于WEB界面的提供分布式系统监视及网络监视功能的企业级的开源解决方案。
Zabbix主要功能：CPU负荷 内存使用 磁盘使用 网络状况 端口监视 日志监视
Zabbix大致的原理：
	Zabbix有两部分组成，即Zabbix server与Zabbix agent。Zabbix server可以通过SNMP、Zabbix agent、ping、端口监视等方法提供对远程服务器/网络状态的监视，数据收集功能。Zabbix agent主要对硬件信息或者与操作系统有关的内存，CPU信息的手机。
Zabbix安装和使用详见http://waringid.blog.51cto.com/65148/955939/

3.Tsar淘宝信息收集
主要用来收集服务器的系统信息（如cpu，io，mem，tcp等）以及应用数据（如squid haproxy nginx等），tsar支持实时查看和历史查看，方便了解应用和服务器的信息!

4.服务端的监控和架构
http://kerry.blog.51cto.com/172631/557749/
http://blog.csdn.net/yinwenjie/article/details/46605451

5.GoAccess对nginx请求信息的统计
GoAccess主要是提供一个软件，通过简单的命令，可以实时查看系统的访问请求参数。也可以进行web页面展示。
http://www.open-open.com/lib/view/open1437052877896.html

6.ELK日志收集和统计
ELK使用elatic.co提供的日志收集工具，包含Elasticsearch + Logstash + Kibana（ELK）。其中：Elasticsearch主要用于提供搜索和分析日志;Logstash主要用于提供实时数据收集引擎，其包含三部分发送日志，收集数，数据写入三部分;Kibana主要用于提供为方便展示数据而进行的web可视化平台。
http://www.ibm.com/developerworks/cn/opensource/os-cn-elk/
ELK搭建案例：https://github.com/ameizi/ELK

7．Logstash和Flume对比
Logstash和flume都适用于数据收集，Logstash使用input(数据输入),filter(日志分析),output(数据输出存储)。Flume使用source(数据收集),channel(数据存储持久化),sink(数据转发)。Flume使用的Java开发的，比较简单。Logstash插件比较多，配置灵活。但是logstash本身是没有存储能力的,且对elasticsearch支持比较好。所以又产生了flume+kafka+logstash+es。
Kafka是消息队列，可以将产生的消息进行存储，供计算系统消费。
http://www.cnblogs.com/smartloli/p/4530117.html

8.Cat日志收集和统计
http://blog.csdn.net/ggjlvzjy/article/details/51908130
http://os.51cto.com/art/201507/484400.htm

9.案例:
http://www.jiagoumi.com/technical-article/140.html