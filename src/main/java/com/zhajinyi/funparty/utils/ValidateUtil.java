package com.zhajinyi.funparty.utils;

import java.lang.Character.UnicodeBlock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    public ValidateUtil() {
    }

    private static boolean isChinese(char c) {
        UnicodeBlock ub = UnicodeBlock.of(c);
        return ub == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub == UnicodeBlock.GENERAL_PUNCTUATION;
    }

    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        } else {
            char[] ch = str.toCharArray();

            for(int i = 0; i < ch.length; ++i) {
                char c = ch[i];
                if (isChinese(c)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
            return pattern.matcher(str.trim()).find();
        }
    }

    public static boolean isChineseByName(String str) {
        if (str == null) {
            return false;
        } else {
            String reg = "\\p{InCJK Unified Ideographs}&&\\P{Cn}";
            Pattern pattern = Pattern.compile(reg);
            return pattern.matcher(str.trim()).find();
        }
    }

    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        } else {
            String check = "^([a-z0-9A-Z]+[_|-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        }
    }

    public static boolean isMobilephone(String mobile) {
        if (mobile == null) {
            return false;
        } else {
            String check = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(mobile);
            return matcher.matches();
        }
    }
    
    public static boolean isPicCode(String picCode) {
    	if (picCode == null) {
    		return false;
    	} else {
            String check = "^[A-Za-z0-9]{4}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(picCode);
            return matcher.matches();    		
    	}
    }
    
    public static boolean isCode(String mobileCode) {
    	if (mobileCode == null) {
    		return false;
    	} else {
            String check = "^\\d{6}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(mobileCode);
            return matcher.matches();    		
    	}
    }
    
    public static boolean isSimplePassword(String isPwd) {
    	if (isPwd == null) {
    		return false;
    	} else {
            String check = "^[a-zA-Z]\\w{5,17}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(isPwd);
            return matcher.matches();    		
    	}
    }

}
