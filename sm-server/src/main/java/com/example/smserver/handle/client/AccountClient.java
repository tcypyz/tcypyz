package com.example.smserver.handle.client;

import com.example.smserver.core.ApplicationContextHelper;
import com.example.smserver.handle.AccountHandle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/20
 */
@Component
public class AccountClient<T> implements InitializingBean{

    private ApplicationContextHelper applicationContextHelper;

    private final Map<String, AccountHandle<T>> handle = new ConcurrentHashMap<>();

    @Autowired
    public void setApplicationContext(ApplicationContextHelper applicationContext){
        this.applicationContextHelper = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, AccountHandle> accountHandleMap = applicationContextHelper.getBeansOfType(AccountHandle.class);
        for (Map.Entry<String, AccountHandle> entry : accountHandleMap.entrySet()) {
            handle.put(entry.getValue().getType().getId().toString(),entry.getValue());
        }
    }

    public void doHandler(String tag,T t, Long id) {
        handle.get(tag).process(t, id);
    }

}
