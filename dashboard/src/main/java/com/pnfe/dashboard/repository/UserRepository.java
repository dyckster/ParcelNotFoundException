package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, String> {

}
