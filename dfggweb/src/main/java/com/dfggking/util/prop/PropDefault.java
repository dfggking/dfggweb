package com.dfggking.util.prop;

/**
 * Prop中涉及到的默认值。
 * 
 * @author LiuBo
 * 
 */
public interface PropDefault {

	/** 分页中每页数据量的大小 */
	public static final String PAGESIZE = "6";

	/** 默认的引用主题文件 */
	public static final String THEME = "all";

	/** 采用HMACMD5加密的字符集 */
	public static final String CHARSET_HMACMD5 = "UTF-8";

	/** RESPONSE中设置的字符集 */
	public static final String CHARSET_RESPONSE = "UTF-8";

	/** 登录中允许失败的次数 */
	public static final String LOGIN_FAILTIMES = "5";

	/** 登录中重置的时间差量，精确到毫秒 */
	public static final String LOGIN_RESETTIME = "600000";

	/** 登录中超出失败次数后将要冻结的时间，精确到毫秒 */
	public static final String LOGIN_FREEZETIME = "1800000";

	/** 登录中利用CODE登录的时间间隔，精确到毫秒 */
	public static final String LOGIN_CODETIME = "1000";

	/** 标记本应用程序能否用来登录 */
	public static final String LOGIN_ENABLE = "true";

	/** 登录用户过期时间 */
	public static final String LOGINUSER_EXPIREDTIME = "30000";

	/** 登录用户的ping时间 */
	public static final String LOGINUSER_PINGTIME = "3000";

	/** 进行消息提示的页面路径 */
	public static final String PATH_MESSAGE = "/message.jsp";

	/** 进行重定向的页面路径 */
	public static final String PATH_REDIRECT = "";

	/** 标记JSON的路径后缀 */
	public final static String MEDIATYPES_JSON = "json_";

	/** 标记XML的路径后缀 */
	public final static String MEDIATYPES_XML = "xml_";

	/** 默认是否开启缓存 */
	public static final String CACHE_ENABLE = "true";

	/** 提示前段长度 */
	public static final String BOTHENDS_BL = "33";

	/** 提示后端长度 */
	public static final String BOTHENDS_EL = "14";

	/** 提示中的省略号 */
	public static final String ELLIPSIS = "...";

	// *****************************************************************************************************************

	/** 用户状态-活跃 */
	public final static String STATUS_USER_ACTIVE = "active";

	/** 角色状态-活跃 */
	public final static String STATUS_ROLE_ACTIVE = "active";

	/** 登录 */
	public final static String ACTION_LOGINLOG_LOGIN = "login";

	/** 登出 */
	public final static String ACTION_LOGINLOG_LOGOUT = "logout";

	/** 被用户登出 */
	public final static String ACTION_LOGINLOG_LOGOUTBYUSER = "logoutByUser";

	/** 被系统登出 */
	public final static String ACTION_LOGINLOG_LOGOUTBYSYS = "logoutBySys";

	/** 登录日志自动标识 */
	public final static String SYS_LOGINLOG = "SYS_LOGINLOG";

	// *****************************************************************************************************************

	/** 唯一标识，包括大写字母、小写字母、数字、下划线、点，必须以字母、数字、下划线开头，以字母、数字、下划线结尾，不能出现连续两个点。 */
	public final static String PATTERN_ID = "^([\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+[\u002e]{1})*[\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+$";

	/** 树形结构中的索引，包括大写字母、小写字母、数字、下划线、点、竖线，如：_abc.a|a。 */
	public final static String PATTERN_TID = "^(([\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+[\u002e]{1})*[\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+[\u007c]{1})*([\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+[\u002e]{1})*[\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f]+[\u007c]{0,1}$";

	/** 字符集中除了控制字符外能显示的字符，控制字符包括ASCII码的0到31和127号字符。 */
	public final static String PATTERN_DISPLAY = "^[^\u0000-\u001F,\u007F]+$";

	/** ASCII码中除了控制字符外能显示的字符，控制字符包括ASCII码的0到31和127号字符。 */
	public final static String PATTERN_DISPLAY_ASCII = "^[\u0020-\u007E]+$";

	/** 数字，包括ASCII中的0-9,可带正负号如：+100。 */
	public final static String PATTERN_NUMBER = "^[\u002d,\u002b]{0,1}[\u0030-\u0039]+$";

	/** 数字，包括ASCII中的0-9,不可以带符号。 */
	public final static String PATTERN_NUMBER_UNSIGNED = "^[\u0030-\u0039]+$";

	/** ASCII码中能作为java属性名的字符，包括大写字母、小写字母、数字、下划线、$。 */
	public final static String PATTERN_JAVAFIELD = "^[\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f,\u0024]+$";

	/** ASCII码中能作为java类全名的字符，包括大写字母、小写字母、数字、下划线、$、点，必须以字母、数字、下划线、$开头，以字母、数字、下划线、$结尾，不能出现连续两个点。 */
	public final static String PATTERN_JAVACLASS_FULL = "^([\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f,\u0024]+[\u002e]{1})*[\u0061-\u007a,\u0041-\u005a,\u0030-\u0039,\u005f,\u0024]+$";

	/** 是不是叶子节点，包括是（true），不是（false）。 */
	public final static String PATTERN_LEAF = "^(true|false){1}$";

	/** 状态，包含活跃（active）和冻结（freeze），如有第三种状态请自行定义。 */
	public final static String PATTERN_STATUS = "^(active|freeze){1}$";

	/** IPV4和IPV6地址，包括大写字母、小写字母、数字、冒号、点，只检查包含的字符合法性。 */
	public final static String PATTERN_IP = "^[\u0061-\u0066,\u0041-\u0046,\u0030-\u0039,\u002e,\u003a]+$";

	/** 文件名，不包括各种控制符和下列字符：/\<>*:?"，只检查包含的字符合法性。 */
	public final static String PATTERN_FILENAME = "^[^\u0000-\u001F,\u007F,\u002f,\\u005c,\u003c,\u003e,\u002a,\u003a,\u003f,\\u0022]+$";

	/** 邮件，如：liubo_325325@163.com。 */
	public final static String PATTERN_EMAIL = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";

	/** 登录动作，包括login、logout、logoutByUser、logoutBySys */
	public final static String PATTERN_LOGINACTION = "^(login|logout|logoutByUser|logoutBySys){1}$";

	/** 坐席技能，包括seat、monitor */
	public final static String PATTERN_SKILLS = "^(seat|monitor){1}$";
	
}
