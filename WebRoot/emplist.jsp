<%@page pageEncoding="utf-8"  contentType="text/html;charset=utf-8" import="java.util.ArrayList,model.Emp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								工号
							</td>
							<td>
								姓名
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>
						<!-- 在此处写一段java代码，先获取服务器端servlet转发过来的集合emps -->
						<%
							//request.getAttribute()默认返回的类型是Object类型，需要将Object类型强制类型转换为ArrayList类型
							//double m=3.14;
							//int n=(int)m;
							ArrayList<Emp> emps=(ArrayList<Emp>)request.getAttribute("ps");
							//out.println(emps);
							//使用循环将集合emps中的内容查看
							//emps.size是集合的大小4，下标i=0 1 2 3
							for(int i=0;i<emps.size();i++){
								Emp p=emps.get(i);
								//out.println(p.salary);
						%>		
						<tr class="row1">
							<td>
								<%=p.id %>
							</td>
							<td>
								<% out.println(p.name);  %>
							</td>
							<td>
								<%=p.salary %>
							</td>
							<td>
								<%=p.age %>
							</td>
							<td>
								<a href="delete?id=<%=p.id%>">删除员工</a>&nbsp;<a href="updateEmp.html">修改员工</a>
							</td>
						</tr>
						<%		
							}
						%>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
