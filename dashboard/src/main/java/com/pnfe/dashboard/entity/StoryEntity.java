package com.pnfe.dashboard.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "stories")
public class StoryEntity {
    @Column(name = "user_id")
    private String userId;
    @Id
    @Column(name = "story_id")
    private String id;
    @Column(name = "article_title")
    private String articleTitle;
    @Column(name = "article_image")
    private String articleImage;
    @Column(name = "article_description")
    private String articleDescription;
    @Column(name = "article_type")
    private String articleType;
    @Column(name = "is_read")
    private Boolean isRead;
}
