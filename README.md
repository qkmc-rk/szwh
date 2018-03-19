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

### 版本2.1
- 时间:2018-3-3
- 更改选中页面导航栏处字体不变粗.
- 更改导航栏的宽高尽量符合比例(1080p下符合比例)
- 修改每个页面顶部,添加电话联系行目.
- 修改主页滚动图高度.
- 修改主页上案列分类的比例信息.
- 修改主页案列显示图片无圆角的问题
- 修复footer部分的比例问题
- 引入字体 avantGrade
- 修改后台案列修改功能

### 版本2.2
- 时间:2018-3-5
- 更改幕图g_1
- 修改导航栏英文斜体加粗
- 修改合作者logo
- 导航栏case变为cases复数形式.
- logo鼠标移入变色
- 顶部电话改为文字而不是图片

### 版本2.3
- 时间:2018-2-7/2-8
- 页面增加meta标签<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />,以增强兼容性
- 修复首页ys一栏hover时图片消失的BUG.并优化此栏加载速度.
- 首页服务部分字体改为黑体
- 修复兼容模式下主页上案列部分字体不居中的问题
- 修复兼容模式下logo图片没有圆角和阴影的问题
- 修复在webkit内核和IE内核下首页案列部分文字不居中的BUG
- 修复顶部topcall不居中显示的bug

### 版本2.4
- 时间:2018-3-10
- 修复页面上CASE不是复数的bug
- 修复首页案例hover遮盖不完整的BUG.
- 修复案列页面hover不是圆角的问题
- 修复以上问题

### 版本2.5
- 时间:2018-3-17
- 修复主页上g-1 g-2图片不清晰的问题,但是图片大小变大.
- 主页上关于部分的文字换成图片
- about进行大部分改变
- 服务的五角图改为质量较高的图
- 新增加一个页面  案列--客户页面
- 新增三个页面 article design movie activity
- 在数据库case添加cover字段,然后修改主页和案列的封面都从cover字段获取.
- 增添设置封面功能页面(后台)
- 2018-3-18
- 修复网站根路径时上传出错的问题
- 2018-3-19
- 修复article_show的controller方法中因包装类型Integer而带来的漏洞