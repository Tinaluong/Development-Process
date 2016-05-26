package edu.gatech.seclass.FaultyClassTest;

import org.junit.Test;

import edu.gatech.seclass.FaultyClass.FaultyClass;

public class FaultyClassTest {

	@Test
	public void method1SC(){
		FaultyClass.method1(5,true,true);
	}
	
	@Test
	public void method1BC(){
		FaultyClass.method1(5,true,true);
		FaultyClass.method1(5,false,false);
	}

	@Test
	public void method1PC(){
		FaultyClass.method1(1,true,false);
		FaultyClass.method1(1,false,true);
		FaultyClass.method1(1,false,false);
		FaultyClass.method1(1,true,true);
	}
	
	@Test
	public void method2PC(){
		//No Fault
		FaultyClass.method2(5,true,false);
		FaultyClass.method2(5,false,true);
		FaultyClass.method2(5,false,false);
		FaultyClass.method2(5,true,true);
	}

	@Test
	public void method2SC(){
		//No Fault, 100% Coverage
		FaultyClass.method2(5,true,true);
		FaultyClass.method2(5,true,false);
	}

	@Test
	public void method2BC(){
		FaultyClass.method2(10,false,false); //fault
		FaultyClass.method2(5,true,true);//Statement Coverage
		FaultyClass.method2(5,true,false);
		FaultyClass.method2(3,true,false);//Not full path coverage
		
	}


}
