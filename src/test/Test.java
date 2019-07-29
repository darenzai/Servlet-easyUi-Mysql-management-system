package test;

import java.util.ArrayList;
import java.util.Arrays;

//测试，语法演示类，和ems项目没有关系
public class Test {
	public static void main(String[] args) {
		//容器：  数组是用于存储一堆具有相同数据类型的数据
		//1 2 3 4 5 6 7   一堆整数的数据
		int[] arr1=new int[7];
		arr1[0]=1;
		arr1[1]=2;
		arr1[2]=3;
		arr1[3]=4;
		arr1[4]=5;
		arr1[5]=6;
		arr1[6]=7;
		System.out.println(Arrays.toString(arr1));  //[1, 2, 3, 4, 5, 6, 7]
		//"张三"  "李四"  "王五"  一堆字符串数据
		String[] arr2=new String[3];
		arr2[0]="张三";
		arr2[1]="李四";
		arr2[2]="王五";
		System.out.println(Arrays.toString(arr2)); //[张三, 李四, 王五]
		//集合，也是一种容器，和数组类似，但是数组的使用更加的方便   ArrayList集合
		//创建ArrayList集合容器
		ArrayList list=new ArrayList();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("小红");
		list.add(100);
		list.add(3.14);
		System.out.println(list);
		//带有泛型的创建ArrayList集合容器
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		//list1.add(1);   编译错误，规定泛型后只能存储泛型规定的类型
		//list1.add(3.14);
		System.out.println(list1);//[a, b]
		//     "a"  "b"
		//下标        0    1
        String s1=list1.get(0); 		
		System.out.println(s1);  //a
		String s2=list1.get(1);
		System.out.println(s2);  //b
		/*
		 *  1,张三,3000.0,25
			2,李四,4000.0,30
			3,王五,2500.0,20
            4,小红,5000.0,35
		 * 
		 */
		ArrayList<Emp> list2=new ArrayList<Emp>();
		//list2.add(1);
		//list2.add("张三");
		//list2.add(3000.0);
		//list2.add(25);
		//list2.add(2);
		//list2.add("李四");
		//....
		//创建第一个员工类
		Emp p1=new Emp();
		p1.id=1;
		p1.name="张三";
		p1.salary=3000.0;
		p1.age=25;
		//创建第二个员工类
		Emp p2=new Emp();
		p2.id=2;
		p2.name="李四";
		p2.salary=4000.0;
		p2.age=30;
		//将第一个员工和第二个员工放入集合中存储
		list2.add(p1); //p1中有1 "张三" 3000 25存储到集合中
		list2.add(p2); //p2中有2 "李四" 4000 30也存储到了集合中
		
		
		
	}
}












