package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.entity.AccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends CrudRepository<AccountsEntity, String> {
    List<AccountsEntity> findByUserId(String user_id);

}
