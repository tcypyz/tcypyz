package com.example.smserver.handle.client;

import com.example.smserver.core.base.AbstractClient;
import com.example.smserver.handle.AccountHandle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/20
 */
@Component
public class AccountClient<T> extends AbstractClient<AccountHandle<T>> implements InitializingBean{

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
