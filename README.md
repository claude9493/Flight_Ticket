# Flight_Ticket
	这里是2017年春季`南方科技大学`程序设计基础课程期末Project。

----------
###基本介绍
Project的主题是`机票预订系统`，具体要求在`计算机程序设计基础项目.pdf`文件里。<br>
程序暂时在`控制台`中执行。用户通过输入序号选择要执行的操作（和给10086打电话差不多），然后执行相关方法。程序中的数据暂时存储在txt文档中。
<br>
文件夹`src`里的是Project的主要部分，包括五个package。文件夹`Test`里面的是在做project时尝试实现一些功能时做实验的代码。<br>
`Admin.txt`, `City.txt`, `Flights.txt`, `Passengers.txt`里分别存储了管理员、城市、航班、乘客的信息。

----------
###程序入口

整个机票预订系统的入口在`\src\Application\Main_interface.java`，启动程序后先进行身份选择，选择管理员或乘客或游客，身份进入系统，随后可进行对应身份的操作。

----------
###程序执行流程图
当程序被执行时，基本流程如下：
![FlowDiagram](http://i4.buimg.com/567571/d4e180e29d0af9f2.png)
----------
###TXT文档格式说明
####Admin.txt
Admin.txt里存储了管理员的信息，每位管理员有三个字段的信息：管理员名，密码，状态{ONLINE,OFFLINE}。
####City.txt
City.txt里存储了城市的信息，每个城市有两个字段的信息：城市编号和城市名。
####Flights.txt
Flights.txt里存储了航班的信息，每个航班有航班号、出发城市、终点城市、起飞日期、起飞时间、到达时间、机票价格、座位容量、当前乘客数共9个字段的信息。
####Passengers.txt
Passengs.txt里存储了乘客的信息，每位乘客有4个字段的信息，乘客ID、身份证号、密码、真实姓名。



----------
Welcome to join us!!!