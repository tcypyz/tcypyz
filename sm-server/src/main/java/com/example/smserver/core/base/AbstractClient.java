package com.example.smserver.core.base;

import com.example.smserver.core.ApplicationContextHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @description:
 * @author: zhh
 * @time: 2022/4/22
 */
@Component
public abstract class AbstractClient<C> implements InitializingBean {

    protected ApplicationContextHelper applicationContextHelper;

    protected final Map<String, C> handle = new HashMap<>();

    @Autowired
    public void setApplicationContext(ApplicationContextHelper applicationContext){
        this.applicationContextHelper = applicationContext;
    }

    /**
     * 属性设置
     */
    @Override
    public abstract void afterPropertiesSet();

}
