package com.fastRetail.batchdemo.repository;

import com.fastRetail.batchdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {

}
