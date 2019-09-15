package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.entity.OperationEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public interface OperationsRepository extends CrudRepository<OperationEntity, Integer>{
    List<OperationEntity> findByCardId (String card_id);
}
