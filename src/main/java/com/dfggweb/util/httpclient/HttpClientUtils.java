package com.dfggweb.util.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author dfggking@hotmail.com
 * @create 2017-10-13
 * @since 1.0
 */
public final class HttpClientUtils {
    
    private HttpClientUtils() {
    }
    private final static Logger logger = LogManager.getLogger(HttpClientUtils.class);
    /**
     * 执行GET请求
     * @author dfggking@hotmail.com
     * @create 2017-10-13
     * @param url
     * @return String
     * @since 1.0
     */
    public static String get(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        logger.debug("executing get request: " + httpGet.getURI());
        try {
            // 执行GET请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            // 获取response entity
            HttpEntity httpEntity = response.getEntity();
            // 
            if(Objects.equals(response.getStatusLine().getStatusCode(), 200)) {
                return EntityUtils.toString(httpEntity);
            }
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    /**
     * 执行带参数GET请求
     * @author dfggking@hotmail.com
     * @create 2017-10-13
     * @return String
     * @since 1.0
     */
    public static String get(String url, Map<String, String> params) {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            for(String key : params.keySet()) {
                uriBuilder.addParameter(key, params.get(key));
            }
            logger.debug("");
            return get(uriBuilder.build().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    /**
     * 执行POST请求
     * @author dfggking@hotmail.com
     * @create 2017-10-13
     * @return String
     * @since 1.0
     */
    public String post(String url) {
        return post(url);
    }
    
    public String post(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        logger.debug("executing post request: " + httpPost.getURI());
        // 如果有参数
        if(Objects.isNull(params)) {
            List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
            for(String key : params.keySet()) {
                paramsList.add(new BasicNameValuePair(key, params.get(key)));
            }
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity;
            try {
                formEntity = new UrlEncodedFormEntity(paramsList, "utf-8");
                httpPost.setEntity(formEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "";
    }
}
