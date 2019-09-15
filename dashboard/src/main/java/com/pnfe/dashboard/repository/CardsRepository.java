package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<CardEntity, String> {
    List<CardEntity> findByAccountId(String accountId);
}
