package com.ivan.blog.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * Program :  com.ysm.api.util
 * Description : mybatis 동적 쿼리시 null 체크
 * Author  :  gwangbae.park@ysmcorp.com
 * Date    :  2016. 3. 23.
 */
public class Comparator {
    public static boolean isEmpty(Object obj){
        if ( obj instanceof String) return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List) return obj == null || ((List<?>)obj).isEmpty();
        else if (obj instanceof Map) return  obj == null || ((Map<?, ?>)obj).isEmpty();
        else if (obj instanceof Object[]) return obj == null || Array.getLength(obj)==0;
        else return obj == null;
    }

    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }
}
