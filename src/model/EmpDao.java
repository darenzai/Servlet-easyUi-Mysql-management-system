package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//表示模型层的dao工厂
//该工厂负责的是连接数据库，对数据库进行相关操作
public class EmpDao {
	//自定义一个方法--查询emp表，获得emp表中的所有数据
	//语法：public 方法返回值类型 方法名(参数列表){ 方法体 }
	//第一版本：该方法设定不需要任何参数，不需要返回值void
	public void getEmps(){
		try {
			//0)注册加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//1)获得数据库的连接
			String url="jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8";
			String username="root";
			String pwd="darenzai";
			Connection con=DriverManager.getConnection(url,username,pwd);
			//2)预编译sql
			String sql="select * from emp";
			PreparedStatement prep=con.prepareStatement(sql);
			//3)执行sql
			ResultSet rs=prep.executeQuery();
			//测试：使用循环将结果集中的数据输出
			while(rs.next()){
				System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getDouble("salary")+","+rs.getInt("age"));
			}
			//4)关闭数据库的连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//自定义一个方法： -- 查询emp表，获得emp表中的所有数据
	//第二个版本：设定该方法要有返回值,返回值类型是ArrayList集合，该集合用于存储emp表中查询出的所有数据
	public ArrayList<Emp> getAllEmps(){
		ArrayList<Emp> emps=new ArrayList<Emp>();  //空集合，该集合里面没有内容
		//使用JDBC连接数据库，查询emp表中所有的数据，并放入emps集合中存储
		try {
			//0）注册加载驱动
			//Class.forName("com.mysql.jdbc.Driver");
			//1）获得数据库的连接
			//String url="jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8";
			//String username="root";
			//String pwd="tarena";
			//Connection con=DriverManager.getConnection(url,username,pwd);
			Connection con=DBUtil.getCon();
			//2）预编译sql语句
			String sql="select * from emp";
			PreparedStatement prep=con.prepareStatement(sql);
			//3）执行sql语句
			ResultSet rs=prep.executeQuery();
			while(rs.next()){  //判断结果集中是否有数据，有数据，使用循环遍历
				Emp p=new Emp();  //每一次while循环，创建一个新的员工
				//=右边是从rs结果集中取出的数据      =左边将取出的输出给Emp员工类赋值
				p.id=rs.getInt("id");
				p.name=rs.getString("name");
				p.salary=rs.getDouble("salary");
				p.age=rs.getInt("age");
				emps.add(p);
			}
			//4）关闭数据库的连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	
	
	//自定义一个方法-- 删除emp表中的一条数据      delete from emp where id=?
	public void deleteEmp(int id){
		try {
			//通过DBUtil工具类获得数据库的连接(0注册加载驱动  1获得数据库的连接)
			Connection con=DBUtil.getCon();
			//2）预编译sql语句
			String sql="delete from emp where id=?";
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setInt(1,id);  //1表示第一个问号   逗号后面的id是方法传递过来的id
			//3)执行sql语句
			prep.executeUpdate();   //该方法支持update、delete、insert操作
			//4）关闭数据库的连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//自定义一个方法 -- 往emp表中添加一条数据 
	//参数：姓名，工资和年龄，id主键自动增长
	public void addEmp(String name,double salary,int age){
		try {
			//1）通过调用DBUtil工具类中的getCon方法获得数据库的连接
			Connection con=DBUtil.getCon();
			//2）预编译sql语句
			String sql="insert into emp(name,salary,age) values(?,?,?)";
			PreparedStatement prep=con.prepareStatement(sql);
			prep.setString(1,name);
			prep.setDouble(2,salary);
			prep.setInt(3,age);
			//3)执行sql语句
			prep.executeUpdate(); //insert delete update
			//prep.executeQuery(); //select 
			System.out.println("删除成功");
			//4）关闭数据库的连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}




















