package com.fastRetail.batchdemo.batch;


import com.fastRetail.batchdemo.model.User;
import com.fastRetail.batchdemo.repository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBWriter.class);

    @Autowired
    private UserRespository userRepository;

    @Override
    public void write(List<? extends User> user) throws Exception {

        LOGGER.info("Data saved for User",user);
        userRepository.saveAll(user);
    }
}
