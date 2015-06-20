package com.novbank.web;

/**
 * Created by CaoKe on 2015/6/19.
 */
public class Regexp {
    public static final String EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    public static final String MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
    public static final String ZIP_CODE = "[1-9]\\d{5}(?!\\d)";
    public static final String QQ = "[1-9][0-9]{4,}";
    public static final String ID = "(^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$)|(^(\\d{6})(\\d{2})(\\d{2})(\\d{2})(\\d{3})$)|\\s+";
}
