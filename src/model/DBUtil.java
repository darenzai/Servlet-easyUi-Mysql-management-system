package model;

import java.sql.Connection;
import java.sql.DriverManager;

//属于模型层   --  数据库连接的工具类
public class DBUtil {
	//在该工具类中封装一个获取数据库连接的一个方法
	public static Connection getCon() throws Exception{
		//0）注册加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//1）获得数据库的连接
		String url="jdbc:mysql://localhost:3306/tedu?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String pwd="darenzai";
		Connection con=DriverManager.getConnection(url,username,pwd);
		return con;
	}
	
}
