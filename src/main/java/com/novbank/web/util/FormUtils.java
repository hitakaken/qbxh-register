package com.novbank.web.util;

import org.apache.commons.lang3.StringUtils;
import org.joor.Reflect;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 表单工具
 *
 * Created by CaoKe on 2015/6/19.
 */
public class FormUtils {
    /**
     * 将表单的字符串字段清洁为空字符
     * @param form 表单对象
     */
    public static void trimToEmpty(Object form){
        checkNotNull(form);
        Reflect r = Reflect.on(form);
        for(String name : r.fields().keySet()){
            if(r.field(name).get()!=null && r.field(name).type() == String.class){
                r.set(name, StringUtils.trimToEmpty((String) r.get(name)));
            }
        }
    }

    /**
     * 将表单的字符串字段清洁为Null
     * @param form 表单对象
     */
    public static void trimToNull(Object form){
        checkNotNull(form);
        Reflect r = Reflect.on(form);
        for(String name : r.fields().keySet()){
            if(r.field(name).get()!=null && r.field(name).type() == String.class){
                r.set(name, StringUtils.trimToNull((String) r.get(name)));
            }
        }
    }
}
