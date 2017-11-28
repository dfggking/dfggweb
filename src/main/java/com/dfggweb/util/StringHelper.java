package com.dfggweb.util;

/**
 * String相关的工具类。
 * 
 * @author LiuBo
 */
public abstract class StringHelper {

	/** System.getProperty("line.separator"); */
	public static final String NEWLINE = System.getProperty("line.separator");
	
	private static final String SERVICE_ID = "2";
	
	private static int idSequence = 10000;
	
	/**
	 * 按日期格式生成唯一编码
	 * @return
	 */
	public synchronized static String generalSrid() {
		StringBuffer ret = new StringBuffer(20);	
		ret.append(SERVICE_ID);
		ret.append(FormatHelper.getCurrentFormatDate("yyyyMMddHHmmsssss"));		
		idSequence++;
		if(idSequence>20000)
		  idSequence-=10000;
		ret.append(String.valueOf(idSequence).substring(1));
		return ret.toString();
	}

	/**
	 * 判断指定字符是不是null或空字符。(判断依据null == arg 或 arg.trim().length() == 0)
	 * 
	 * @param arg
	 *            指定的字符
	 * @return 是返回true，不是返回false。
	 */
	public static boolean isNullOrEmpty(String arg) {
		if (null == arg) {
			return true;
		}
		if (arg.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断指定字符串是不是null或空。（判断依据 null == arg 或 arg.length() == 0）
	 * 
	 * @param arg
	 *            指定字符串
	 * @return 返回字符串是不是null或空。
	 */
	public static boolean isNullOrNothing(String arg) {
		if (null == arg) {
			return true;
		}
		if (arg.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 截掉指定字符串前面和后面的Whitespace。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉Whitespace后的字符串。
	 */
	public static String trimWhitespace(String arg) {
		return trimWhitespaceImpl(arg, true, true);
	}

	/**
	 * 截掉指定字符串前面的Whitespace。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉前面Whitespace后的字符串
	 */
	public static String trimWhitespaceStart(String arg) {
		return trimWhitespaceImpl(arg, true, false);
	}

	/**
	 * 截掉指定字符串后面的Whitespace。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉后面Whitespace后的字符串。
	 */
	public static String trimWhitespaceEnd(String arg) {
		return trimWhitespaceImpl(arg, false, true);
	}

	/**
	 * 截掉指定字符串前面和后面的Whitespace。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param start
	 *            是否截掉开始部分
	 * @param end
	 *            是否截掉结尾部分
	 * @return 返回截掉Whitespace后的字符串。
	 */
	private static String trimWhitespaceImpl(String arg, boolean start, boolean end) {
		int len = arg.length();
		int st = 0;
		if (start) {
			while ((st < len) && (Character.isWhitespace(arg.charAt(st)))) {
				st++;
			}
		}
		if (end) {
			while ((st < len) && (Character.isWhitespace(arg.charAt(len - 1)))) {
				len--;
			}
		}
		return ((st > 0) || (len < arg.length())) ? arg.substring(st, len) : arg;
	}

	/**
	 * 截掉指定字符串前面和后面的SpaceChar。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉SpaceChar后的字符串。
	 */
	public static String trimSpace(String arg) {
		return trimSpaceImpl(arg, true, true);
	}

	/**
	 * 截掉指定字符串前面的SpaceChar。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉前面SpaceChar后的字符串。
	 */
	public static String trimSpaceStart(String arg) {
		return trimSpaceImpl(arg, true, false);
	}

	/**
	 * 截掉指定字符串后面的SpaceChar。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @return 返回截掉后面SpaceChar后的字符串。
	 */
	public static String trimSpaceEnd(String arg) {
		return trimSpaceImpl(arg, false, true);
	}

	/**
	 * 截掉指定字符串前面和后面的SpaceChar。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param start
	 *            是否截掉开始部分
	 * @param end
	 *            是否截掉结尾部分
	 * @return 返回截掉SpaceChar后的字符串。
	 */
	private static String trimSpaceImpl(String arg, boolean start, boolean end) {
		int len = arg.length();
		int st = 0;
		if (start) {
			while ((st < len) && (Character.isSpaceChar(arg.charAt(st)))) {
				st++;
			}
		}
		if (end) {
			while ((st < len) && (Character.isSpaceChar(arg.charAt(len - 1)))) {
				len--;
			}
		}
		return ((st > 0) || (len < arg.length())) ? arg.substring(st, len) : arg;
	}

	/**
	 * 截掉指定字符串前面和后面的指定字符。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param cs
	 *            要截掉的字符
	 * @return 截掉指定字符后的字符串。
	 */
	public static String trim(String arg, char... cs) {
		return trimImpl(arg, true, true, cs);
	}

	/**
	 * 截掉指定字符串前面的指定字符。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param cs
	 *            要截掉的字符
	 * @return 返回截掉前面指定字符后的字符串。
	 */
	public static String trimStart(String arg, char... cs) {
		return trimImpl(arg, true, false, cs);
	}

	/**
	 * 截掉指定字符串后面的指定字符。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param cs
	 *            要截掉的字符
	 * @return 返回截掉后面指定字符后的字符串。
	 */
	public static String trimEnd(String arg, char... cs) {
		return trimImpl(arg, false, true, cs);
	}

	/**
	 * 截掉指定字符串前面和后面的指定字符。
	 * 
	 * @param arg
	 *            指定的字符串
	 * @param start
	 *            是否截掉开始部分
	 * @param end
	 *            是否截掉结尾部分
	 * @param cs
	 *            要截掉的字符
	 * @return 返回截掉指定字符后的字符串。
	 */
	private static String trimImpl(String arg, boolean start, boolean end, char... cs) {
		int len = arg.length();
		int st = 0;
		if (start) {
			while ((st < len) && contains(cs, arg.charAt(st))) {
				st++;
			}
		}
		if (end) {
			while ((st < len) && contains(cs, arg.charAt(len - 1))) {
				len--;
			}
		}
		return ((st > 0) || (len < arg.length())) ? arg.substring(st, len) : arg;
	}

	/**
	 * 获取字符串的片段，并在两端加上指定字符串。
	 * 
	 * @param arg
	 *            被片段的字符串。
	 * @param begin
	 *            开始位置。
	 * @param length
	 *            获取长度。
	 * @param bs
	 *            前缀。
	 * @param es
	 *            后缀。
	 * @return 返回片段后的字符串。
	 */
	public static String excerpt(String arg, int begin, int length, String bs, String es) {
		String ret = "";
		if (begin > 0 && begin < arg.length()) {
			ret = bs;
		}
		int len = begin + length;
		ret = ret + arg.substring(begin, (len > arg.length() ? arg.length() : len));
		if (arg.length() > len) {
			ret = ret + es;
		}
		return ret;
	}

	/**
	 * 略去字符串中间部分并用指定字符串代替。
	 * 
	 * @param arg
	 *            被略去的字符串。
	 * @param bl
	 *            开头保留的长度。
	 * @param el
	 *            结尾保留的长度。
	 * @param middle
	 *            中间替换的字符串。
	 * @return 返回略去后的字符串。
	 */
	public static String bothEnds(String arg, int bl, int el, String middle) {
		if (arg.length() <= (bl + el)) {
			return arg;
		}
		return arg.substring(0, bl) + middle + arg.substring(arg.length() - el, arg.length());
	}

	/**
	 * 过滤掉指定字符串的特定字符。
	 * 
	 * @param arg
	 *            被过滤的字符串。
	 * @param cs
	 *            需要过滤的字符。
	 * @return 返回过滤后的字符串。
	 */
	public static String except(String arg, char... cs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arg.length(); i++) {
			char c = arg.charAt(i);
			if (!contains(cs, c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 过滤掉并留下指定的字符。
	 * 
	 * @param arg
	 *            被过滤的字符串。
	 * @param cs
	 *            留下的字符。
	 * @return 返回过滤后的字符串。
	 */
	public static String include(String arg, char... cs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arg.length(); i++) {
			char c = arg.charAt(i);
			if (contains(cs, c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 判断char数组里面包不包含指定的char。
	 * 
	 * @param cs
	 *            char数组。
	 * @param c
	 *            指定的char。
	 * @return 返回包不包含char。
	 */
	private static boolean contains(char[] cs, char c) {
		for (int i = 0; i < cs.length; i++) {
			if (c == cs[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将普通的字符转换成十六进制表示的字符串。
	 * 
	 * @param arg
	 *            被转化的字符串。
	 * @return 返回转化后的十六进制表示的字符串。
	 */
	public static String stringToHexString(String arg) {
		int count = arg.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			char c = arg.charAt(i);
			String s = Integer.toHexString(c);
			while (s.length() < 4) {
				s = "0" + s;
			}
			s = "\\u" + s;
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * 将指定十六进制表示的字符串转成普通字符串。
	 * 
	 * @param arg
	 *            被转化的字符串。
	 * @return 返回转化后的普通字符串。
	 */
	public static String hexStringToString(String arg) {
		int count = arg.length() / 6;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			String s = arg.substring(i * 6, i * 6 + 6);
			s = s.substring(2);
			char c = (char) Integer.parseInt(s, 16);
			sb.append(c);
		}
		if (arg.length() % 6 > 0) {
			sb.append(arg.substring((arg.length() / 6) * 6));
		}
		return sb.toString();
	}

	/**
	 * 将指定字符追加到指定字符串结尾。
	 * 
	 * @param arg
	 *            被追加的字符串。
	 * @param length
	 *            字符串要达到的长度。
	 * @param c
	 *            字符。
	 * @return 被追加后的字符串。
	 */
	public static String appendCharEnd(String arg, int length, char c) {
		int count = length - arg.length();
		if (count <= 0) {
			return arg;
		}
		StringBuffer sb = new StringBuffer(arg);
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * 将指定字符追加到指定字符串的前面。
	 * 
	 * @param arg
	 *            被追加的字符串。
	 * @param length
	 *            字符串要达到的长度。
	 * @param c
	 *            字符。
	 * @return 被追加后的字符串。
	 */
	public static String appendCharBegin(String arg, int length, char c) {
		int count = length - arg.length();
		if (count <= 0) {
			return arg;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append(c);
		}
		sb.append(arg);
		return sb.toString();
	}
}
