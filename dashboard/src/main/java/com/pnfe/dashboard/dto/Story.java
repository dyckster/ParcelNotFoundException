package com.pnfe.dashboard.dto;

import lombok.Data;

@Data
public class Story {
    private String id;
    private String articleTitle;
    private String articleImage;
    private String articleDescription;
    private String articleType;
    private Boolean isRead;
}
