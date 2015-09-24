package com.example.coolweather1.util;

public interface HttpCallbackListener {
	
	//默认的包访问权限 只有同包的类可以访问，接口中定义的函数和变量默认都是public的
	void onFinish(String response);
	
	void onError(Exception e);

}
