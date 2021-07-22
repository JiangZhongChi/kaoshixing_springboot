# kaoshixing_springboot

```
需求一：POST http://localhost:8080/user/adduser
参数：
account			//账号				
userName		//姓名
sex				//性别
companyId		//公司id
status			//状态
departmentName	//部门名称

需求二：GET http://localhost:8080/user/queryuser
参数：
departmentId	//部门id
pageNo			//当前查询的第几页
pageSize		//每页多少条数据

需求三：POST http://localhost:8080/update
参数：
userId			//用户id
departmentId	//部门id

需求四：GET http://localhost:8080/queryUserName
参数：
nameLike		//姓名关键字
pageNo			//当前查询的第几页
pageSize		//每页多少条数据

需求五：GET http://localhost:8080/company/queryCompanyById
参数：
companyId		//公司id


