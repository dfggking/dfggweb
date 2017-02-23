package com.dfggking.util.prop;

/**
 * Prop中涉及到的键。
 * 
 * @author LiuBo
 * 
 */
public interface PropKey {

	/** 分页中每页数据量的大小 */
	public static final String PAGESIZE = "PAGESIZE";

	/** 默认的引用主题文件 */
	public static final String THEME = "THEME";

	/** CTI服务器IP地址 */
	public static final String CTI_SERVER_IP = "CTI_SERVER_IP";

	/** 采用HMACMD5加密的字符集 */
	public static final String CHARSET_HMACMD5 = "CHARSET_HMACMD5";

	/** RESPONSE中设置的字符集 */
	public static final String CHARSET_RESPONSE = "CHARSET_RESPONSE";

	/** 登录中允许失败的次数 */
	public static final String LOGIN_FAILTIMES = "LOGIN_FAILTIMES";

	/** 登录中重置的时间差量，精确到毫秒 */
	public static final String LOGIN_RESETTIME = "LOGIN_RESETTIME";

	/** 登录中超出失败次数后将要冻结的时间，精确到毫秒 */
	public static final String LOGIN_FREEZETIME = "LOGIN_FREEZETIME";

	/** 登录中利用CODE登录的时间间隔，精确到毫秒 */
	public static final String LOGIN_CODETIME = "LOGIN_CODETIME";

	/** 标记本应用程序能否用来登录 */
	public static final String LOGIN_ENABLE = "LOGIN_ENABLE";

	/** 登录用户过期时间 */
	public static final String LOGINUSER_EXPIREDTIME = "LOGINUSER_EXPIREDTIME";

	/** 登录用户的ping时间 */
	public static final String LOGINUSER_PINGTIME = "LOGINUSER_PINGTIME";

	/** 进行消息提示的页面路径 */
	public static final String PATH_MESSAGE = "PATH_MESSAGE";

	/** 进行重定向的页面路径 */
	public static final String PATH_REDIRECT = "PATH_REDIRECT";

	/** 标记JSON的路径后缀 */
	public final static String MEDIATYPES_JSON = "MEDIATYPES_JSON";

	/** 标记XML的路径后缀 */
	public final static String MEDIATYPES_XML = "MEDIATYPES_JSON";

	/** 默认是否开启缓存 */
	public static final String CACHE_ENABLE = "CACHE_ENABLE";

	/** DICTIONARYCACHEBYID默认是否开启缓存 */
	public static final String CACHE_DICTIONARYCACHEBYID_ENABLE = "CACHE_DICTIONARYCACHEBYID_ENABLE";

	/** ORGCACHEBYID默认是否开启缓存 */
	public static final String CACHE_ORGCACHEBYID_ENABLE = "CACHE_ORGCACHEBYID_ENABLE";

	/** DICTIONARYCACHEBYPID默认是否开启缓存 */
	public static final String CACHE_DICTIONARYCACHEBYPID_ENABLE = "CACHE_DICTIONARYCACHEBYPID_ENABLE";

	/** MENUCACHEBYPIDANDROLEID默认是否开启缓存 */
	public static final String CACHE_MENUCACHEBYPIDANDROLEID_ENABLE = "CACHE_MENUCACHEBYPIDANDROLEID_ENABLE";

	/** OPERCACHEBYPATH默认是否开启缓存 */
	public static final String CACHE_OPERCACHEBYPATH_ENABLE = "CACHE_OPERCACHEBYPATH_ENABLE";

	/** ROCACHEROLEIDANDOPERID默认是否开启缓存 */
	public static final String CACHE_ROCACHEROLEIDANDOPERID_ENABLE = "CACHE_ROCACHEROLEIDANDOPERID_ENABLE";

	/** ROLECACHEBYID默认是否开启缓存 */
	public static final String CACHE_ROLECACHEBYID_ENABLE = "CACHE_ROLECACHEBYID_ENABLE";

	/** ROLECACHEBYUSERID默认是否开启缓存 */
	public static final String CACHE_ROLECACHEBYUSERID_ENABLE = "CACHE_ROLECACHEBYUSERID_ENABLE";

	/** USERCACHEBYID默认是否开启缓存 */
	public static final String CACHE_USERCACHEBYID_ENABLE = "CACHE_USERCACHEBYID_ENABLE";

	/** GROUPCACHEBYID默认是否开启缓存 */
	public static final String CACHE_GROUPCACHEBYID_ENABLE = "CACHE_GROUPCACHEBYID_ENABLE";

	/** MENUCACHEBYID默认是否开启缓存 */
	public static final String CACHE_MENUCACHEBYID_ENABLE = "CACHE_MENUCACHEBYID_ENABLE";

	/** OPERCACHEBYID默认是否开启缓存 */
	public static final String CACHE_OPERCACHEBYID_ENABLE = "CACHE_OPERCACHEBYID_ENABLE";
	
	/** GROUPCACHEALL默认是否开启缓存 */
	public static final String CACHE_GROUPCACHEALL_ENABLE = "CACHE_GROUPCACHEALL_ENABLE";

	/** 验证提示前端长度 */
	public static final String VALIDATOR_BL = "VALIDATOR_BL";

	/** 验证提示后端长度 */
	public static final String VALIDATOR_EL = "VALIDATOR_EL";

	/** 验证提示中的省略号 */
	public static final String VALIDATOR_ELLIPSIS = "VALIDATOR_ELLIPSIS";

	/** 提示前段长度 */
	public static final String BOTHENDS_BL = "BOTHENDS_BL";

	/** 提示后端长度 */
	public static final String BOTHENDS_EL = "BOTHENDS_EL";

	/** 提示中的省略号 */
	public static final String ELLIPSIS = "ELLIPSIS";

	// *****************************************************************************************************************

	/** 用户状态-活跃 */
	public final static String STATUS_USER_ACTIVE = "STATUS_USER_ACTIVE";

	/** 角色状态-活跃 */
	public final static String STATUS_ROLE_ACTIVE = "STATUS_ROLE_ACTIVE";

	/** 登录 */
	public final static String ACTION_LOGINLOG_LOGIN = "ACTION_LOGINLOG_LOGIN";

	/** 登出 */
	public final static String ACTION_LOGINLOG_LOGOUT = "ACTION_LOGINLOG_LOGOUT";

	/** 被用户登出 */
	public final static String ACTION_LOGINLOG_LOGOUTBYUSER = "ACTION_LOGINLOG_LOGOUTBYUSER";

	/** 被系统登出 */
	public final static String ACTION_LOGINLOG_LOGOUTBYSYS = "ACTION_LOGINLOG_LOGOUTBYSYS";

	/** 登录日志自动标识 */
	public final static String SYS_LOGINLOG = "SYS_LOGINLOG";

	// *****************************************************************************************************************

	/** 验证主键ID的正则式 */
	public final static String PATTERN_ID = "PATTERN_ID";

	/** 验证层ID的正则式 */
	public final static String PATTERN_TID = "PATTERN_TID";

	/** 验证可显示字符的正则式 */
	public final static String PATTERN_DISPLAY = "PATTERN_DISPLAY";

	/** 验证可显示的ASCII正则式 */
	public final static String PATTERN_DISPLAY_ASCII = "PATTERN_DISPLAY_ASCII";
	
	/** 验证不分正负数的正则式 */
	public final static String PATTERN_NUMBER = "PATTERN_NUMBER";
	
	/** 验证正数的正则式 */
	public final static String PATTERN_NUMBER_UNSIGNED = "PATTERN_NUMBER_UNSIGNED";
	
	/** 验证JAVA中字段的正则式 */
	public final static String PATTERN_JAVAFIELD = "PATTERN_JAVAFIELD";

	/** 验证JAVA中类全名的正则式 */
	public final static String PATTERN_JAVACLASS_FULL = "PATTERN_JAVACLASS_FULL";
	
	/** 验证是不是叶子节点的正则式 */
	public final static String PATTERN_LEAF = "PATTERN_LEAF";
	
	/** 验证状态的正则式 */
	public final static String PATTERN_STATUS = "PATTERN_STATUS";
	
	/** 验证IP地址的正则式 */
	public final static String PATTERN_IP = "PATTERN_IP";
	
	/** 验证文件名的正则式 */
	public final static String PATTERN_FILENAME = "PATTERN_FILENAME";
	
	/** 验证邮件的正则式 */
	public final static String PATTERN_EMAIL = "PATTERN_EMAIL";
	
	/** 验证登录动作的正则式 */
	public final static String PATTERN_LOGINACTION = "PATTERN_LOGINACTION";
	
	/** 验证坐席技能的正则式 */
	public final static String PATTERN_SKILLS = "PATTERN_SKILLS";
	
}
