package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.entity.AccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository <AccountsEntity, String> {

}
