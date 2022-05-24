package com.example.smserver.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Objects;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
public class BeanUtils {

    /**
     * bean字段为空
     *
     * @param o bean
     * @return return true if all fields is null
     */
    public static boolean fieldIsNull(Object o) {
        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object object = field.get(o);
                if (object instanceof CharSequence) {
                    if (StringUtils.isNotEmpty((String) object)) {
                        return false;
                    }
                } else if (object instanceof Collection) {
                    if (CollectionUtils.isNotEmpty((Collection<?>) object)){
                        return false;
                    }
                } else {
                    if (Objects.nonNull(object)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * bean字段非空
     *
     * @param o o
     * @return boolean
     */
    public static boolean fieldNonNull(Object o) {
        return !fieldIsNull(o);
    }
}
