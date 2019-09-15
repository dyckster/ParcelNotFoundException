package com.pnfe.dashboard.repository;

import com.pnfe.dashboard.dto.Story;
import com.pnfe.dashboard.entity.AccountsEntity;
import com.pnfe.dashboard.entity.StoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, String> {
    List<StoryEntity> findByUserId(String user_id);

}
