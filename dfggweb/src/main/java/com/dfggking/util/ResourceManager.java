package com.dfggking.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * 对程序中出现的字符串统一管理，以键的方式获取相应的字符串信息
 * <p>通过java.util.ResourceBundle来加载信息,我们需要在每个包下创建一个默认的LocalStrings.properties,如果有必要可以添加相应国别的配置文件比如：</p>
 * <p>中文的文件名应该叫做LocalStrings_zh.properties。加载时通过包名牌需找配置文件</p>
 * <p>可以调用静态的getManager方法来获取相应包名的ResourceManager实例，此实例唯一可以通过静态的setLocale、getLocale设置相应的国别，最好使用统一的国别</p>
 * @author jinyf   
 * @date 2017年3月1日 下午2:16:18 
 * @since 1.0
 */
public class ResourceManager {

	/**
	 * 跟据Locale来缓存ResourceBundle。
	 */
	private HashMap<Locale, ResourceBundle> store = new HashMap<Locale, ResourceBundle>();

	/**
	 * 包名
	 */
	private String baseName;

	/**
	 * 根据指定的包名构造ResourceManager实例。
	 * 
	 * @param baseName
	 *            路径。
	 */
	public ResourceManager(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * 通过指定的键来获取字符串。
	 * 
	 * @param key
	 *            键。
	 * @return 返回对应的字符串。
	 */
	public String getString(String key) {
		return getString(key, Locale.getDefault());
	}

	/**
	 * 通过指定的键和Locale来获取字符串。
	 * 
	 * @param key
	 *            键。
	 * @param locale
	 *            Locale。
	 * @return 返回对应的字符串。
	 */
	public String getString(String key, Locale locale) {
		ResourceBundle bundle = store.get(locale);
		if (bundle == null) {
			synchronized (this) {
				bundle = store.get(locale);
				if (bundle == null) {
					bundle = ResourceBundle.getBundle(baseName, locale);
					store.put(locale, bundle);
				}
			}
		}
		String str = null;
		try {
			str = bundle.getString(key);
		} catch (MissingResourceException mre) {
			str = "Cannot find message associated with key '" + key + "'";
		}
		return str;
	}

	/**
	 * 通过指定的键和参数来获取字符串。
	 * 
	 * @param key
	 *            键。
	 * @param args
	 *            参数。
	 * @return 返回对应的字符串。
	 */
	public String getString(String key, Object... args) {
		return getString(key, Locale.getDefault(), args);
	}

	/**
	 * 通过指定的键、Locale和参数获取字符串。
	 * 
	 * @param key
	 *            键。
	 * @param locale
	 *            Locale。
	 * @param args
	 *            参数。
	 * @return 返回对应的字符串。
	 */
	public String getString(String key, Locale locale, Object... args) {
		String ret = "";
		String value = getString(key, locale);
		try {
			ret = MessageFormat.format(value, args);
		} catch (IllegalArgumentException e) {
			StringBuffer sb = new StringBuffer(value);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					sb.append(" arg[");
					sb.append(i);
					sb.append("]=");
					sb.append(args[i]);
				}
			}
			ret = sb.toString();
		}
		return ret;
	}

	/**
	 * ResourceManager的包名映射关系。
	 */
	private static final HashMap<String, ResourceManager> managers = new HashMap<String, ResourceManager>();

	/**
	 * 获取包名对应的ResourceManager实例，ResourceManager唯一且只初始化一次。
	 * 
	 * @param baseName
	 *            路径。
	 * @return 返回ResourceManager实例。
	 */
	public synchronized static ResourceManager getManager(String baseName) {
		ResourceManager mgr = (ResourceManager) managers.get(baseName);
		if (mgr == null) {
			mgr = new ResourceManager(baseName);
			managers.put(baseName, mgr);
		}
		return mgr;
	}

}
