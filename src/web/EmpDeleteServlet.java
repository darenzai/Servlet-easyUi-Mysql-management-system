package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpDao;

//服务器端的控制层
//该类主要负责的是删除员工的操作
public class EmpDeleteServlet extends HttpServlet{
	//调出service方法
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("删除.......");
		//接收在浏览器端(emplist.jsp)传递过来的id值  id=1  id=2  id=3 id=4
		String strId=req.getParameter("id");
		System.out.println(strId);
		//一、调用模型层中EmpDao工厂，让工厂去删除数据库中的数据
		EmpDao dao=new EmpDao();
		dao.deleteEmp(Integer.parseInt(strId));  //String-->int
		
		//二、当EmpDao工厂删除成功后，回到list主界面，看到删除成功的结果
		//转发（未完成的工作交给下一个组件）或者重定向（完成了工作，不需要交给下一个组件继续完成）
		//选择用重定向，上面的代码已经删除了，只是单纯的向list主界面跳转
		resp.sendRedirect("list");
	}
	
}
