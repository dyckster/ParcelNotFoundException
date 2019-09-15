package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.Story;
import com.pnfe.dashboard.entity.StoryEntity;
import com.pnfe.dashboard.repository.StoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoriesService {

    @Autowired
    StoryRepository storyRepository;

    public List<Story> getStories(String userId){
        return storyRepository.findByUserId(userId).stream().map(s -> {
            Story story = new Story();
            BeanUtils.copyProperties(s, story);
            return story;
        }).collect(Collectors.toList());
    }

    public void setStoryRead (String storyId) throws IllegalArgumentException{
        StoryEntity storyEntity = Optional.ofNullable(storyRepository.findById(storyId))
                .map(s -> s.get())
                .orElseThrow(IllegalArgumentException::new);
        storyEntity.setIsRead(true);
        storyRepository.save(storyEntity);

    }

}
