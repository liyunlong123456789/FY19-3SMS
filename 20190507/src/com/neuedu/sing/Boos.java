package com.neuedu.sing;

public class Boos {
	//私有化变量
	//饿汉式单例 
	private static Boos boos;
	
	//构造器私有化
	private  Boos() 
	{
		
	}
	//提供返回实例的方法
	public static Boos getBoosInstance() 
	{
		if( null == boos)
		{
			//懒汉式单例
			boos = new Boos();
		}
		return boos ;
	}
	
	
	
}
