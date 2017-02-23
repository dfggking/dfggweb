package com.dfggking.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class HttpHelper {
	private final static Log log = LogFactory.getLog(HttpHelper.class);
	
	public static String postHttpClient(String url, Map<String, String> args) {
		String ret = "";
		try {
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);
			method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keys = args.keySet();
			for (String key : keys) {
				params.add(new NameValuePair(key, args.get(key)));
			}
			NameValuePair[] nvp = new NameValuePair[params.size()];
			method.setRequestBody(params.toArray(nvp));
			//设置连接的超时时间
			client.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);  
			//设置读取数据的超时时间 
            client.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);  
			int retCode = client.executeMethod(method);
			if (retCode == 200) {
				ret = method.getResponseBodyAsString();
			}
			method.releaseConnection();
		} catch (Exception e) {
			log.error("", e);
		}
		return ret;
	}
	
	
	public static String get(String url, Map<String, String> headers) throws IOException {
		ArrayList<Header> headers0 = new ArrayList<Header>(headers.size());
		Set<String> headerKeys = headers.keySet();
		for (String key : headerKeys) {
			Header header = new Header(key, headers.get(key));
			headers0.add(header);
		}
		return get(url, headers0);
	}

	public static String get(String url, List<Header> headers) throws IOException {
		GetMethod method = new GetMethod(url);
		for (Header header : headers) {
			method.addRequestHeader(header);
		}
		return get(method);
	}

	public static String get(GetMethod method) throws IOException {
		String ret = "";
		HttpClient client = new HttpClient();
		//设置连接的超时时间
		client.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);  
		//设置读取数据的超时时间 
        client.getHttpConnectionManager().getParams().setSoTimeout(30 * 1000);  
		int retCode = client.executeMethod(method);
		if (retCode == 200) {
			ret = method.getResponseBodyAsString();
		}
		method.releaseConnection();
		return ret;
	}

	public static String post(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
		ArrayList<Header> headers0 = new ArrayList<Header>(headers.size());
		Set<String> headerKeys = headers.keySet();
		for (String key : headerKeys) {
			Header header = new Header(key, headers.get(key));
			headers0.add(header);
		}
		ArrayList<NameValuePair> params0 = new ArrayList<NameValuePair>(params.size());
		Set<String> paramKeys = params.keySet();
		for (String key : paramKeys) {
			NameValuePair param = new NameValuePair(key, params.get(key));
			params0.add(param);
		}
		return post(url, headers0, params0);
	}

	public static String post(String url, List<Header> headers, List<NameValuePair> params) throws IOException {
		PostMethod method = new PostMethod(url);
		for (Header header : headers) {
			method.addRequestHeader(header);
		}
		for (NameValuePair param : params) {
			method.addParameter(param);
		}
		return post(method);
	}

	public static String post(PostMethod method) throws IOException {
		String ret = "";
		HttpClient client = new HttpClient();
		//设置连接的超时时间
		client.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);  
		//设置读取数据的超时时间 
        client.getHttpConnectionManager().getParams().setSoTimeout(30 * 1000);  
		int retCode = client.executeMethod(method);
		if (retCode == 200) {
			ret = method.getResponseBodyAsString();
		}
		method.releaseConnection();
		return ret;
	}

}
