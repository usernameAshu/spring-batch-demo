package com.fastRetail.batchdemo.batch;

import com.fastRetail.batchdemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String,String> DEPT_NAMES = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(DBWriter.class);

   public Processor() {
       DEPT_NAMES.put("001","Technology");
       DEPT_NAMES.put("002","Operations");
       DEPT_NAMES.put("003","Accounts");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String deptName = DEPT_NAMES.get(deptCode);
        user.setDept(deptName);

        LOGGER.info("Department code converted and processed");
        return user;
    }
}
