/**
 * 
 */
package com.hutool.cytool;

import cn.hutool.core.util.StrUtil;

/**
 * @author PE
 * @date 2019年7月2日 下午9:50:49
 * @explain
 */
public class TestString {
	public static void main(String[] args) {
		boolean a = StrUtil.isBlank("KKKK ");
		System.out.println(a);
		/**
		 * 与空判断相关的 public static boolean isBlank(CharSequence str) public static boolean
		 * isBlankIfStr(Object obj) public static boolean isNotBlank(CharSequence str)
		 * public static boolean hasBlank(CharSequence... strs) public static boolean
		 * isAllBlank(CharSequence... strs) public static boolean isEmpty(CharSequence
		 * str) public static boolean isEmptyIfStr(Object obj) public static boolean
		 * isNotEmpty(CharSequence str) public static String nullToEmpty(CharSequence
		 * str) public static String nullToDefault(CharSequence str, String defaultStr)
		 * public static String emptyToDefault(CharSequence str, String defaultStr)
		 * public static String blankToDefault(CharSequence str, String defaultStr)
		 * public static String emptyToNull(CharSequence str) public static boolean
		 * hasEmpty(CharSequence... strs) public static boolean
		 * isAllEmpty(CharSequence... strs) public static boolean
		 * isNullOrUndefined(CharSequence str) public static boolean
		 * isEmptyOrUndefined(CharSequence str) public static boolean
		 * isBlankOrUndefined(CharSequence str) public static String
		 * cleanBlank(CharSequence str)
		 */
		/**
		 * 头尾处理
		 */
		/**
		 * public static String trim(CharSequence str) public static void trim(String[]
		 * strs) public static String trimToEmpty(CharSequence str) public static String
		 * trimToNull(CharSequence str) public static String trimStart(CharSequence str)
		 * public static String trimEnd(CharSequence str) public static String
		 * trim(CharSequence str, int mode) public static String strip(CharSequence str,
		 * CharSequence prefixOrSuffix) public static String strip(CharSequence str,
		 * CharSequence prefix, CharSequence suffix) public static String
		 * stripIgnoreCase(CharSequence str, CharSequence prefixOrSuffix) public static
		 * String stripIgnoreCase(CharSequence str, CharSequence prefix, CharSequence
		 * suffix) public static String addPrefixIfNot(CharSequence str, CharSequence
		 * prefix) public static String addSuffixIfNot(CharSequence str, CharSequence
		 * suffix) public static boolean isSurround(CharSequence str, CharSequence
		 * prefix, CharSequence suffix) public static boolean isSurround(CharSequence
		 * str, char prefix, char suffix)
		 */
		/**
		 * 包含与否 public static boolean startWith(CharSequence str, char c) public static
		 * boolean startWith(CharSequence str, CharSequence prefix, boolean
		 * isIgnoreCase) public static boolean startWith(CharSequence str, CharSequence
		 * prefix) public static boolean startWithIgnoreCase(CharSequence str,
		 * CharSequence prefix) public static boolean startWithAny(CharSequence str,
		 * CharSequence... prefixes) public static boolean endWith(CharSequence str,
		 * char c) public static boolean endWith(CharSequence str, CharSequence suffix,
		 * boolean isIgnoreCase) public static boolean endWith(CharSequence str,
		 * CharSequence suffix) public static boolean endWithIgnoreCase(CharSequence
		 * str, CharSequence suffix) public static boolean endWithAny(CharSequence str,
		 * CharSequence... suffixes) public static boolean contains(CharSequence str,
		 * char searchChar) public static boolean containsAny(CharSequence str,
		 * CharSequence... testStrs) public static boolean containsAny(CharSequence str,
		 * char... testChars) public static boolean containsBlank(CharSequence str)
		 * public static String getContainsStr(CharSequence str, CharSequence...
		 * testStrs) public static boolean containsIgnoreCase(CharSequence str,
		 * CharSequence testStr) public static boolean
		 * containsAnyIgnoreCase(CharSequence str, CharSequence... testStrs) public
		 * static String getContainsStrIgnoreCase(CharSequence str, CharSequence...
		 * testStrs)
		 */
		/**
		 * setter gettter 处理
		 */
		/**
		 * public static String getGeneralField(CharSequence getOrSetMethodName) public
		 * static String genSetter(CharSequence fieldName) public static String
		 * genGetter(CharSequence fieldName)
		 */
		/**
		 * 删除
		 */
		/**
		 * public static String removeAll(CharSequence str, CharSequence strToRemove)
		 * public static String removeAll(CharSequence str, char... chars) public static
		 * String removeAllLineBreaks(CharSequence str) public static String
		 * removePreAndLowerFirst(CharSequence str, int preLength) public static String
		 * removePreAndLowerFirst(CharSequence str, CharSequence prefix) public static
		 * String removePrefix(CharSequence str, CharSequence prefix) public static
		 * String removePrefixIgnoreCase(CharSequence str, CharSequence prefix) public
		 * static String removeSuffix(CharSequence str, CharSequence suffix) public
		 * static String removeSufAndLowerFirst(CharSequence str, CharSequence suffix)
		 * public static String removeSuffixIgnoreCase(CharSequence str, CharSequence
		 * suffix)
		 */
		/**
		 * 大小写
		 */
		/**
		 * public static String upperFirstAndAddPre(CharSequence str, String preString)
		 * public static String upperFirst(CharSequence str) public static String
		 * lowerFirst(CharSequence str) public static boolean isUpperCase(CharSequence
		 * str) public static boolean isLowerCase(CharSequence str)
		 */
		/**
		 * 分割
		 */
		/**
		 * public static String[] splitToArray(CharSequence str, char separator) public
		 * static long[] splitToLong(CharSequence str, char separator) public static
		 * long[] splitToLong(CharSequence str, CharSequence separator) public static
		 * int[] splitToInt(CharSequence str, char separator) public static int[]
		 * splitToInt(CharSequence str, CharSequence separator) public static
		 * List<String> split(CharSequence str, char separator) public static String[]
		 * splitToArray(CharSequence str, char separator, int limit) public static
		 * List<String> split(CharSequence str, char separator, int limit) public static
		 * List<String> splitTrim(CharSequence str, char separator) public static
		 * List<String> splitTrim(CharSequence str, CharSequence separator) public
		 * static List<String> splitTrim(CharSequence str, char separator, int limit)
		 * public static List<String> splitTrim(CharSequence str, CharSequence
		 * separator, int limit) public static List<String> split(CharSequence str, char
		 * separator, boolean isTrim, boolean ignoreEmpty) public static List<String>
		 * split(CharSequence str, char separator, int limit, boolean isTrim, boolean
		 * ignoreEmpty) public static List<String> split(CharSequence str, CharSequence
		 * separator, int limit, boolean isTrim, boolean ignoreEmpty) public static
		 * String[] split(CharSequence str, CharSequence separator) public static
		 * String[] split(CharSequence str, int len) public static String[]
		 * cut(CharSequence str, int partLength)
		 */
		/**
		 * 截取
		 */
		/**
		 * public static String sub(CharSequence str, int fromIndex, int toIndex) public
		 * static String subPreGbk(CharSequence str, int len, CharSequence suffix)
		 * public static String maxLength(CharSequence string, int length) public static
		 * String subPre(CharSequence string, int toIndex) public static String
		 * subSuf(CharSequence string, int fromIndex) public static String
		 * subSufByLength(CharSequence string, int length) public static String
		 * subWithLength(String input, int fromIndex, int length) public static String
		 * subBefore(CharSequence string, CharSequence separator, boolean
		 * isLastSeparator) public static String subBefore(CharSequence string, char
		 * separator, boolean isLastSeparator) public static String
		 * subAfter(CharSequence string, CharSequence separator, boolean
		 * isLastSeparator) public static String subAfter(CharSequence string, char
		 * separator, boolean isLastSeparator) public static String
		 * subBetween(CharSequence str, CharSequence before, CharSequence after) public
		 * static String subBetween(CharSequence str, CharSequence beforeAndAfter)
		 */

		/**
		 * 创建字符串
		 */
		/**
		 * public static String repeat(char c, int count) public static String
		 * repeat(CharSequence str, int count) public static String
		 * repeatAndJoin(CharSequence str, int count, CharSequence conjunction)
		 */
		/**
		 * 是否 /** public static boolean equals(CharSequence str1, CharSequence str2)
		 * public static boolean equalsIgnoreCase(CharSequence str1, CharSequence str2)
		 * public static boolean equals(CharSequence str1, CharSequence str2, boolean
		 * ignoreCase) public static boolean isSubEquals(CharSequence str1, int start1,
		 * CharSequence str2, int start2, int length, boolean ignoreCase) public static
		 * boolean isAllCharMatch(CharSequence value, Matcher<Character> matcher) public
		 * static boolean equalsCharAt(CharSequence str, int position, char c)
		 */
		/**
		 * 格式化
		 */
		/**
		 * public static String format(CharSequence template, Object... params) public
		 * static String indexedFormat(CharSequence pattern, Object... arguments) public
		 * static String format(CharSequence template, Map<?, ?> map)
		 */
		/**
		 * 获取字节
		 */
		/**
		 * public static byte[] utf8Bytes(CharSequence str) public static byte[]
		 * bytes(CharSequence str) public static byte[] bytes(CharSequence str, String
		 * charset) public static byte[] bytes(CharSequence str, Charset charset)
		 */
		/**
		 * 转换为字符串
		 */
		/**
		 * public static String utf8Str(Object obj) public static String str(Object obj,
		 * String charsetName) public static String str(Object obj, Charset charset)
		 * public static String str(byte[] bytes, String charset) public static String
		 * str(byte[] data, Charset charset) public static String str(Byte[] bytes,
		 * String charset) public static String str(Byte[] data, Charset charset) public
		 * static String str(ByteBuffer data, String charset) public static String
		 * str(ByteBuffer data, Charset charset) public static String str(CharSequence
		 * cs) public static String toString(Object obj) public static String
		 * join(CharSequence conjunction, Object... objs)
		 */
		/**
		 * 格式转换
		 */
		/**
		 * public static String toUnderlineCase(CharSequence str) public static String
		 * toSymbolCase(CharSequence str, char symbol) public static String
		 * toCamelCase(CharSequence name)
		 */
		/**
		 * 包裹
		 */
		/**
		 * public static String wrap(CharSequence str, CharSequence prefixAndSuffix)
		 * public static String wrap(CharSequence str, CharSequence prefix, CharSequence
		 * suffix) public static String[] wrapAll(CharSequence prefixAndSuffix,
		 * CharSequence... strs) public static String[] wrapAll(CharSequence prefix,
		 * CharSequence suffix, CharSequence... strs) public static String
		 * wrapIfMissing(CharSequence str, CharSequence prefix, CharSequence suffix)
		 * public static String[] wrapAllIfMissing(CharSequence prefixAndSuffix,
		 * CharSequence... strs) public static String[] wrapAllIfMissing(CharSequence
		 * prefix, CharSequence suffix, CharSequence... strs)
		 * 
		 * public static String unWrap(CharSequence str, String prefix, String suffix)
		 * public static String unWrap(CharSequence str, char prefix, char suffix)
		 * public static String unWrap(CharSequence str, char prefixAndSuffix) public
		 * static boolean isWrap(CharSequence str, String prefix, String suffix) public
		 * static boolean isWrap(CharSequence str, String wrapper) public static boolean
		 * isWrap(CharSequence str, char wrapper) public static boolean
		 * isWrap(CharSequence str, char prefixChar, char suffixChar)
		 */
		/**
		 * 填充
		 */
		/**
		 * public static String padPre(CharSequence str, int minLength, char padChar)
		 * public static String padEnd(CharSequence str, int minLength, char padChar)
		 * public static StringBuilder builder() public static String fillBefore(String
		 * str, char filledChar, int len) public static String fillAfter(String str,
		 * char filledChar, int len) public static String fill(String str, char
		 * filledChar, int len, boolean isPre)
		 */
		/**
		 * 获取其他对象
		 */
		/**
		 * public static StrBuilder strBuilder() public static StringBuilder builder(int
		 * capacity) public static StrBuilder strBuilder(int capacity) public static
		 * StringBuilder builder(CharSequence... strs) public static StrBuilder
		 * strBuilder(CharSequence... strs) public static StringReader
		 * getReader(CharSequence str) public static StringWriter getWriter()
		 */
		/**
		 * 出现次数
		 */
		/**
		 * public static int count(CharSequence content, CharSequence strForSearch)
		 * public static int count(CharSequence content, char charForSearch)
		 */
		/**
		 * 摘要和隐藏
		 */
		/**
		 * public static String brief(CharSequence str, int maxLength) public static
		 * String hide(CharSequence str, int startInclude, int endExclude)
		 */
		/**
		 * 比较
		 */
		/**
		 * public static int compare(final CharSequence str1, final CharSequence str2,
		 * final boolean nullIsLess) public static int compareIgnoreCase(CharSequence
		 * str1, CharSequence str2, boolean nullIsLess) public static int
		 * compareVersion(CharSequence version1, CharSequence version2)
		 */
		/**
		 * 获取索引位置
		 */
		/**
		 * public static int indexOf(final CharSequence str, char searchChar) public
		 * static int indexOf(final CharSequence str, char searchChar, int start) public
		 * static int indexOf(final CharSequence str, char searchChar, int start, int
		 * end) public static int indexOfIgnoreCase(final CharSequence str, final
		 * CharSequence searchStr) public static int indexOfIgnoreCase(final
		 * CharSequence str, final CharSequence searchStr, int fromIndex) public static
		 * int indexOf(final CharSequence str, CharSequence searchStr, int fromIndex,
		 * boolean ignoreCase) public static int lastIndexOfIgnoreCase(final
		 * CharSequence str, final CharSequence searchStr) public static int
		 * lastIndexOfIgnoreCase(final CharSequence str, final CharSequence searchStr,
		 * int fromIndex) public static int lastIndexOf(final CharSequence str, final
		 * CharSequence searchStr, int fromIndex, boolean ignoreCase) public static int
		 * ordinalIndexOf(String str, String searchStr, int ordinal)
		 */
		/**
		 * 追加
		 */
		/**
		 * public static String appendIfMissing(final CharSequence str, final
		 * CharSequence suffix, final CharSequence... suffixes) public static String
		 * appendIfMissingIgnoreCase(final CharSequence str, final CharSequence suffix,
		 * final CharSequence... suffixes) public static String appendIfMissing(final
		 * CharSequence str, final CharSequence suffix, final boolean ignoreCase, final
		 * CharSequence... suffixes) public static String prependIfMissing(final
		 * CharSequence str, final CharSequence prefix, final CharSequence... prefixes)
		 * public static String prependIfMissingIgnoreCase(final CharSequence str, final
		 * CharSequence prefix, final CharSequence... prefixes) public static String
		 * prependIfMissing(final CharSequence str, final CharSequence prefix, final
		 * boolean ignoreCase, final CharSequence... prefixes)
		 */
		/**
		 * 替换
		 */
		/**
		 * public static String replaceIgnoreCase(CharSequence str, CharSequence
		 * searchStr, CharSequence replacement) public static String
		 * replace(CharSequence str, CharSequence searchStr, CharSequence replacement)
		 * public static String replace(CharSequence str, CharSequence searchStr,
		 * CharSequence replacement, boolean ignoreCase) public static String
		 * replace(CharSequence str, int fromIndex, CharSequence searchStr, CharSequence
		 * replacement, boolean ignoreCase) public static String replace(CharSequence
		 * str, int startInclude, int endExclude, char replacedChar) public static
		 * String replace(CharSequence str, Pattern pattern,
		 * Func1<java.util.regex.Matcher, String> replaceFun) public static String
		 * replace(CharSequence str, String regex, Func1<java.util.regex.Matcher,
		 * String> replaceFun) public static String replaceChars(CharSequence str,
		 * String chars, CharSequence replacedStr) public static String
		 * replaceChars(CharSequence str, char[] chars, CharSequence replacedStr)
		 */
		/**
		 * 相似度
		 */
		/**
		 * public static double similar(String str1, String str2) public static String
		 * similar(String str1, String str2, int scale)
		 */
		/**
		 * 其他
		 */
		/**
		 * 总长度 public static int totalLength(CharSequence... strs) 移动 public static
		 * String move(CharSequence str, int startInclude, int endExclude, int
		 * moveLength) uuid public static String uuid() 连接 public static String
		 * concat(boolean isNullToEmpty, CharSequence... strs) 反转 public static String
		 * reverse(String str)
		 */
	}

}
