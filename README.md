## XKSYS 意为选课system<br>
## 首先需要电脑上装好java的环境 <br>
[菜鸟教程java安装](https://www.runoob.com/java/java-environment-setup.html)<br>
## 还需要安装一个eclipse for javaee<br>
[eclipse安装](https://blog.csdn.net/jingzi9912/article/details/80889869)<br>
## tomcat的安装和使用
[tomcat安装教程](http://how2j.cn/k/tomcat/tomcat-tutorial/541.html)
## maven的安装<br>
[how2jmaven安装教程](http://how2j.cn/k/maven/maven-introduction/1328.html)<br>
## eclipse 创建maven javaweb项目<br>
[mavenjavaweb 教学](http://how2j.cn/k/maven/maven-eclipse-web-project/1334.html)<br>
## redis 的安装与使用<br>
[尚硅谷redis教学](https://www.bilibili.com/video/av68608598)<br>
## 配置javaweb项目连接数据库上redis
[javaweb项目连接服务器redis教学](http://how2j.cn/k/redis/redis-sping-data-redis/1719.html)
## 配置工作都已经完成
    接下来具体的代码实现请看项目内文件
##选课系统

@(好奇萌蜂)[常州大学|阿里云大数据学院|NoSQL项目实战]

[TOC]
### 项目简介

> 新学期开始，高校学生需要参加网上选课，然而选课系统经常出现因瞬间访问量太大导致服务器瘫痪的现象。 
针对选课“引爆”服务器的问题，本项目整体采用 [spring](https://www.yiibai.com/spring/) 架构，综合运用[Nginx](https://www.yiibai.com/nginx/nginx-install.html)、[Jboss](https://labs.supinfochina.com/jboss-java-%E5%BA%94%E7%94%A8%E6%9C%8D%E5%8A%A1%E5%99%A8%E6%90%AD%E5%BB%BA%E6%95%99%E7%A8%8B/)、[Mybaits](https://www.yiibai.com/mybatis/)、[Spring MVC](https://www.yiibai.com/spring_mvc)技术。其中学生选课信息存储在 [Redis](https://www.yiibai.com/redis) 和 `SqlServer`数据库。
### 系统演示
> 耐心等待，最后将以 `gif` 形式展示哦
### 环境依赖
- **操作系统**：*Windows* 或 *Linux*
- **Redis**
- **Eclipse**
- **Tomcat**
### 部署步骤
- **Java 开发环境配置 ：**[参考教程](https://www.runoob.com/java/java-environment-setup.html)
- **安装 *Eclipse IDE for java EE* ：**[参考教程](https://blog.csdn.net/jingzi9912/article/details/80889869)
- **安装 *Tomcat* ：**[参考教程](http://how2j.cn/k/tomcat/tomcat-deploy/1143.html)
- **安装 *Redis* 数据库 ：**[参考教程](https://www.runoob.com/redis/redis-install.html)
- ***Java* 使用 *Redis* ：**[参考教程](https://www.runoob.com/redis/redis-java.html)
- **用 *Eclipse* 创建 *Maven JavaWeb项目* ：**[参考教程](https://blog.csdn.net/weixin_43840640/article/details/88669678)
- ***Redis* *Spring*  集成：**[参考教程](http://how2j.cn/k/redis/redis-sping-data-redis/1719.html)
> **提示：**因为主机环境各不相同，在实际操作中会出现意料之外的问题。大家可利用网络资源寻求帮助。
### 版本内容更新
选课系统的版本记录：[超链接]
> 团队持续开发中，敬请期待~~
### 问题交流
- 邮箱：<1329788326@qq.com>
### 声明
> **本项目仅用作 *常州大学* 内部选课使用，未经学校同意禁止发布，否则追究法律责任。**
---------
感谢阅读这份帮助文档。请点击右上角，**Fork** 到个人仓库，开启探索吧。
![](https://pandao.github.io/editor.md/examples/images/4.jpg)
> Follow your heart.
