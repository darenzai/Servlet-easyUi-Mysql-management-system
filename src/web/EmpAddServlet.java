package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDao;

public class EmpAddServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置浏览器端传递的参数中文编码
		//System.out.println("hello.....");
		//http://localhost:8081/ems/add?name=zs&salary=1000&age=20
		String strName=request.getParameter("name");
		String strSalary=request.getParameter("salary");
		String strAge=request.getParameter("age");
		System.out.println(strName+","+strSalary+","+strAge);
		//一、调用dao工厂，让工厂完成数据的添加
		//创建EmpDao工厂，在调用工厂中的addEmp()方法
		EmpDao dao=new EmpDao();
		dao.addEmp(strName, Double.parseDouble(strSalary), Integer.parseInt(strAge));//addEmp()方法中的3个参数应该是页面传递过来的值
		//                  字符串类型转换为double类型                                字符串类型转换为int类型
		
		
		//二、当工厂添加成功后，直接跳转到list主页面就可以
		//重定向
		response.sendRedirect("list");
		
		
	}

}
