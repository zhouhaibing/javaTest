package com.zhb.test.util;

public class StringUtils {

	public static void main(String[] args) {
		// replace oldPattern with newPattern
		String str = "helloyesworldyesddddyesrrr";
		System.out.println(replace(str,"yes","noo"));

	}

	public static String replace(String inString, String oldPattern, String newPattern) {
		if(!hasLength(inString) || !hasLength(oldPattern) || !hasLength(newPattern)){
			return inString;
		}
		int pos = 0;
		int index = inString.indexOf(oldPattern);
		int oldPatLen = oldPattern.length();
		StringBuffer sb = new StringBuffer();
		while(index >= 0){
			sb.append(inString.substring(pos, index));
			sb.append(newPattern);
			pos = index + oldPatLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sb.append(inString.substring(pos));
		return sb.toString();
	}

	public static boolean hasLength(CharSequence charseq) {
		return charseq != null && charseq.length() > 0;
	}

}
