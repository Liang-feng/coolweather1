package com.example.coolweather1.util;

public interface HttpCallbackListener {
	
	//Ĭ�ϵİ�����Ȩ�� ֻ��ͬ��������Է��ʣ��ӿ��ж���ĺ����ͱ���Ĭ�϶���public��
	void onFinish(String response);
	
	void onError(Exception e);

}
