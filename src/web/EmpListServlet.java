package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import model.EmpDao;

//服务器端的控制层
public class EmpListServlet extends HttpServlet{
	//调出service方法
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("hello.......");
		//一、调用Model模型层的dao工厂，获得工厂返回的结果
		//创建EmpDao工厂，然后调用工厂中定义的getEmps方法
		EmpDao dao=new EmpDao();
		//dao.getEmps();
		//通过dao调用工厂的方法，接受该方法返回的集合，该集合中存储了员工信息
		ArrayList<Emp> emps=dao.getAllEmps();
		System.out.println(emps);
		//[model.Emp@17f8716, model.Emp@17dd1d1, model.Emp@159fb5c, model.Emp@85923b]
		//[1,张三,3000.0,25, 2,李四,4000.0,30, 3,王五,2500.0,20, 4,小红,5000.0,35]
		
		//二、将结果转交给emplist.jsp页面（View视图层）
		//转发：当前工作还未结束，需要转交给下一个组件继续完成
		//将dao工厂返回的集合emps随着转发器一起转发到页面
		req.setAttribute("ps",emps);
		//通过req获得一个请求转发器，向一个页面转发，同时req和resp一起转发过去
		req.getRequestDispatcher("emplist.jsp").forward(req, resp);
		
		//重定向：会直接向一个页面或者一个servlet的url-pattern地址跳转（当前工作已经完成了，然后再交给下一个组件）
		//resp.sendRedirect("emplist.jsp");   
	}
}
