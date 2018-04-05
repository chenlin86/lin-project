1.es介绍
  es：一个采用Restful api标准的高扩展和高可用的实时数据搜索和分析的工具。
  节点(node)：单个装有es服务并提供故障转移和扩展的服务器。
  集群(cluster)：由一个或者多个节点组成，共同工作，共同分享整个数据具有负载均衡功能的集群系统。
  索引(index)：用来写入文档或者读取文档的一种数据存储介质。类似于数据库。
  文档(document)：es世界中的实体，由字段构成，每个字段有它的字段名以及一个或者多个字段值。文档之间可能有各自不同的字段集合，且文档并没有固定的模式护着强制的结构。
  映射(mapping):
  类型(type):每个文档都有与之对应的类型定义。
  列(Field)：列是es的最小单位，相当于数据的某一列。
  分片(shards)：将es索引分成若干份，每个部分就是一个shard。
  复制(replicas)：索引一份或者多分的复制。
2.json和xml差异：
  xml:可扩展标记语言，是一种程序与程序之间传输数据的标记语言。
  json：轻量级数据交互格式。
  json替代xml进行数据传输的原因：
  第一，xml格式比较庞大比较复杂，传输占用带宽。
  第二，服务端和客户端都要花费大量的代码去解析xml,解析xml需要花费资源和时间。
  第三，不同浏览器解析xml的方式不一致，需要重复书写代码，不便于维护。
3.restful的含义
  restfull:Representational State Transfer 表现层状态转化
  get:用来获取资源 post：用来创建资源(更新) put:用来更新资源  delete:用来删除资源
4.curl命令
  curl:以命令的方式执行http协议的请求工具，可以通过curl操作http的get/post/put/delete方式。
3.es环境的搭建
1)下载es软件:https://www.elastic.co/downloads/elasticsearch 。
2)解压并运行(bin/elasticsearch.bat),并在浏览器访问：http://127.0.0.1:9200 。
3)安装head插件.首先http://mobz.github.io/elasticsearch-head/ 下载插件解压后将整个文件夹后复制到plugins\下并重命名为head。
4)重启es，并在浏览器方位：http://127.0.0.1:9200/_plugin/head/ 。
5)在配置es参数的时候，一定要注意“:”之后必须在空格后在指定值，否则会提示SettingsException。
3.es基本操作