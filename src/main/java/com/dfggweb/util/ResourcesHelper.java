package com.dfggweb.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * 获取资源的帮助类，从ibatis上扒下来的，稍加改动。
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年3月1日 下午2:03:05 
 * @since 1.0
 */
public abstract class ResourcesHelper {

	private final static Logger log = LogManager.getLogger(ResourcesHelper.class);
	
	/** 默认类加载器 */
	private static ClassLoader defaultClassLoader;

	/**
	 * 获取默认类加载器。
	 * 
	 * @return 返回默认的类加载器。
	 */
	public static ClassLoader getDefaultClassLoader() {
		return defaultClassLoader;
	}

	/**
	 * 设置默认类加载器。
	 * 
	 * @param defaultClassLoader
	 *            默认的类加载器。
	 */
	public static void setDefaultClassLoader(ClassLoader defaultClassLoader) {
		ResourcesHelper.defaultClassLoader = defaultClassLoader;
	}

	/**
	 * 获取指定路径下文件的URL。
	 * 
	 * @param resource
	 *            文件路径。
	 * @return 返回指定文件路径的URL。
	 * @throws IOException
	 */
	public static URL getResourceURL(String resource) throws IOException {
		return getResourceURL(defaultClassLoader, resource);
	}

	/**
	 * 根据指定的类加载器获取指定路径下文件的URL。
	 * 
	 * @param loader
	 *            类加载器。
	 * @param resource
	 *            文件路径。
	 * @return 返回指定文件路径的URL。
	 * @throws IOException
	 */
	public static URL getResourceURL(ClassLoader loader, String resource) throws IOException {
		URL url = null;
		if (loader != null)
			url = loader.getResource(resource);
		if (url == null)
			url = Thread.currentThread().getContextClassLoader().getResource(resource);
		if (url == null)
			url = ClassLoader.getSystemResource(resource);
		if (url == null)
			throw new IOException("Could not find resource " + resource);
		return url;
	}

	/**
	 * 获取指定路径下的文件的InputStream。
	 * 
	 * @param resource
	 *            指定路径。
	 * @return 返回指定文件路径的InputStream。
	 * @throws IOException
	 */
	public static InputStream getResourceAsStream(String resource) throws IOException {
		return getResourceAsStream(defaultClassLoader, resource);
	}

	/**
	 * 根据指定类加载器获取指定路径下的文件的InputStream。
	 * 
	 * @param loader
	 *            类加载器。
	 * @param resource
	 *            指定路径。
	 * @return 返回指定文件路径的InputStream。
	 * @throws IOException
	 */
	public static InputStream getResourceAsStream(ClassLoader loader, String resource)
			throws IOException {
		InputStream in = null;
		if (loader != null)
			in = loader.getResourceAsStream(resource);
		if (in == null)
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		if (in == null)
			in = ClassLoader.getSystemResourceAsStream(resource);
		if (in == null)
			throw new IOException("Could not find resource " + resource);
		return in;
	}

	/**
	 * 获取指定路径的文件的Properties。
	 * 
	 * @param resource
	 *            指定路径。
	 * @return 返回指定文件路径的Properties。
	 * @throws IOException
	 */
	public static Properties getResourceAsProperties(String resource) throws IOException {
		Properties props = new Properties();
		InputStream in = getResourceAsStream(resource);
		props.load(in);
		in.close();
		return props;
	}

	/**
	 * 根据指定类加载器获取指定路径下的文件的Properties。
	 * 
	 * @param loader
	 *            类加载器。
	 * @param resource
	 *            指定路径。
	 * @return 返回指定文件路径的Properties。
	 * @throws IOException
	 */
	public static Properties getResourceAsProperties(ClassLoader loader, String resource)
			throws IOException {
		Properties props = new Properties();
		InputStream in = getResourceAsStream(loader, resource);
		props.load(in);
		in.close();
		return props;
	}

	/**
	 * 获取指定路径下的文件的Reader。
	 * 
	 * @param resource
	 *            指定路径。
	 * @param charset
	 *            字符集。
	 * @return 返回指定文件路径的Reader。
	 * @throws IOException
	 */
	public static Reader getResourceAsReader(String resource, Charset charset) throws IOException {
		Reader reader;
		if (charset == null)
			reader = new InputStreamReader(getResourceAsStream(resource));
		else {
			reader = new InputStreamReader(getResourceAsStream(resource), charset);
		}
		return reader;
	}

	/**
	 * 以指定类加载器获取指定路径下的文件的Reader。
	 * 
	 * @param loader
	 *            类加载器。
	 * @param resource
	 *            文件路径。
	 * @param charset
	 *            字符集。
	 * @return 返回指定文件路径的Reader。
	 * @throws IOException
	 */
	public static Reader getResourceAsReader(ClassLoader loader, String resource, Charset charset)
			throws IOException {
		Reader reader;
		if (charset == null)
			reader = new InputStreamReader(getResourceAsStream(loader, resource));
		else {
			reader = new InputStreamReader(getResourceAsStream(loader, resource), charset);
		}
		return reader;
	}

	/**
	 * 获取指定路径下的文件的File。
	 * 
	 * @param resource
	 *            指定路径。
	 * @return 返回指定路径文件的File实例。
	 * @throws IOException
	 */
	public static File getResourceAsFile(String resource) throws IOException {
		return new File(getResourceURL(resource).getFile());
	}

	/**
	 * 以指定类加载器获取指定路径下的文件的File。
	 * 
	 * @param loader
	 *            类加载器。
	 * @param resource
	 *            指定路径。
	 * @return 返回指定路径文件的File实例。
	 * @throws IOException
	 */
	public static File getResourceAsFile(ClassLoader loader, String resource) throws IOException {
		return new File(getResourceURL(loader, resource).getFile());
	}

	/**
	 * 获取指定URL下的InputStream。
	 * 
	 * @param urlString
	 *            URL。
	 * @return 返回指定URL下的InputStream。
	 * @throws IOException
	 */
	public static InputStream getUrlAsStream(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		return conn.getInputStream();
	}

	/**
	 * 获取指定URL下的Reader。
	 * 
	 * @param urlString
	 *            URL。
	 * @return 返回指定URL下的Reader。
	 * @throws IOException
	 */
	public static Reader getUrlAsReader(String urlString) throws IOException {
		return new InputStreamReader(getUrlAsStream(urlString));
	}

	/**
	 * 获取指定URL下的Properties。
	 * 
	 * @param urlString
	 *            URL。
	 * @return 返回指定URL下的Properties。
	 * @throws IOException
	 */
	public static Properties getUrlAsProperties(String urlString) throws IOException {
		Properties props = new Properties();
		InputStream in = getUrlAsStream(urlString);
		props.load(in);
		in.close();
		return props;
	}

	/**
	 * 获取指定URL下的File。
	 * 
	 * @param urlString
	 *            URL。
	 * @return 返回指定URL下的File。
	 * @throws IOException
	 */
	public static File getUrlAsFile(String urlString) throws IOException {
		URL url = new URL(urlString);
		return new File(url.getFile());
	}

}
