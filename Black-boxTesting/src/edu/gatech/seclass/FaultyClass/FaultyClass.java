package edu.gatech.seclass.FaultyClass;

public class FaultyClass {
	
	public static int method1(int l, boolean a, boolean b)
	{
		 int x = 1;
		 if(a==true)
		 {
			 x = x * 6;
		 }
		 if(b==true)
		 {
			 x = l + 10;
		 }
		 else
		 {
			 x = x/6;
			 x = x-1;
		 }
		 return l / x;
		
	}
	
	public static int method2(int l, boolean a, boolean b)
	{
		 int x = 10;
		 if(a==true)
		 {
			 x = x + 6;
		 }
		 if(b==true)
		 {
			 x = 10;
		 }
		 else
		 {
			 x = x - l;
		 }
		 return l / x;
		
	}
	
	public static int method3(int l, boolean a, boolean b)
	{
		 int x = 10;
		 if(a==true)
		 {
			 l = x + 6;
		 }
		 if(x==3)
		 {
			 x = x/0;
		 }
		 return x;
		
	}
	public static method4()
	{
		//Creating a method that achieves 100% branch coverage and 
		//does not reveal the fault, and every test suite that achieves a 
		//100% statement coverage that reveals a fault is not possible. 
		//This is not possible because if you have a 100% branch coverage that
		//will include the test case in the statement coverage. So you will 
		//achieve 100% statement coverage as well. 
		//Branch coverage tests more thoroughly then statement testing.
		//Branch criteria subsumes statement criteria because all the 
		// test widths that satisfy branch criteria, satisfy statement criteria.
	}
	


}
