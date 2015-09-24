package com.example.coolweather1.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtil {
	
	public static void sendHttpRequest(final String address , final HttpCallbackListener listener)
	{
		new Thread(new Runnable(){

			@Override
			public void run() {
				
				HttpURLConnection connection = null;
				try
				{
					URL url = new URL(address);
					connection = (HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);          //服务器在规定时间内没反应
					connection.setReadTimeout(8000);             //连接上url，在规定时间内获取不到response
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line = reader.readLine()) != null)
					{
						response.append(line);
					}
					if(listener != null)
					{
						//回调onFinish（）方法
						listener.onFinish(response.toString());
					}
				}
				catch(Exception e)
				{
					if(listener != null)
					{
						listener.onError(e);
					}
				}
				finally
				{
					if(connection != null)
					{
						connection.disconnect();
					}
				}
			}
			
		}).start();
	}

}
