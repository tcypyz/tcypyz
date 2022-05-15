package com.example.smserver.handle.client;

import com.example.smserver.core.base.AbstractClient;
import com.example.smserver.entity.User;
import com.example.smserver.handle.DashboardHandle;
import com.example.smserver.vo.DashboardVO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@Component
public class DashboardClient extends AbstractClient<DashboardHandle> implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        Map<String, DashboardHandle> handleMap = applicationContextHelper.getBeansOfType(DashboardHandle.class);
        for (Map.Entry<String, DashboardHandle> entry : handleMap.entrySet()){
            handle.put(entry.getValue().getType().getId().toString(), entry.getValue());
        }
    }

    public DashboardVO doHandler(String tag, User user){
        return handle.get(tag).process(user);
    }
}
