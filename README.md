# SZWH
手足文化
www.cdszwh.com

## 功能
- 后台管理案列,新闻的增删改查
- 前端做门户展示,案列,新闻显示等内容

## 特色
- 使用富文本编辑器wangedit作为案列和新闻的编辑器
- 大量使用ajax完成请求
- 使用springframework众多特性,拦截器,基于注解的配置,springjdbc,restfulAPI支持(delete,put方法)等等..
- 自定义封装rootDao,使得jdbc编写比起直接运用jdbctemplate更简便实用.
- 使用简单易用的dbcp数据源,配置简单,性能适中.

## 依赖
- spring springmvc
- commons dbcp/fileupload/logging
- fastjson

## 使用
- 将仓库下载到本地导入eclipse食用,将源码导入maven工程,导入idea皆可.欢迎食用之.

## 开发环境
- eclipse oxygen2
- mysql5
- tomcat7

### 版本1.8
- 时间:2018-02-13
- 概念版本已完成整合
- 后台页面实现查询所有案列,新增加案列(带图片上传,后台判空处理)
- 前端实现除article(案列)页面其它页面的正常访问.
- 实现控制index的6个案列的获取位置.接着该做index的案列展示数据库中的内容了!

### 版本1.9
- 时间:2018-02-13
- index页面完成默认显示数据库中前6个案列
- article_show页面大致完成,确定是:两边缘会发生错误,需要在后台中优化.

### 版本2.0
- 时间:2018-02-22
- 所有功能都已经完成.
- 后台:案列增删改查
- 前台:主页动态显示,详细案列页面动态显示,案列页面动态显示,其它页面静态显示.
