package com.neuedu.sing;

public class Boos {
	//˽�л�����
	//����ʽ���� 
	private static Boos boos;
	
	//������˽�л�
	private  Boos() 
	{
		
	}
	//�ṩ����ʵ���ķ���
	public static Boos getBoosInstance() 
	{
		if( null == boos)
		{
			//����ʽ����
			boos = new Boos();
		}
		return boos ;
	}
	
	
	
}
