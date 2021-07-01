package com.complexity.gaming.help_i.games.application.transform.resource;

public class GameResource {
    private Long id;
    private int providerId;
    public String name;
    public String providerName;
    public String coverUrl;
    public int coverHeight;
    public int coverWidth;
    public String storyLine;
    public String summary;
    public String backgroundImageUrl;
    public int backgroundHeight;
    public int backgroundWidth;

    public Long getId() {
        return id;
    }

    public GameResource setId(Long id) {
        this.id = id;
        return this;
    }

    public int getProviderId() {
        return providerId;
    }

    public GameResource setProviderId(int providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GameResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public GameResource setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public GameResource setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public int getCoverHeight() {
        return coverHeight;
    }

    public GameResource setCoverHeight(int coverHeight) {
        this.coverHeight = coverHeight;
        return this;
    }

    public int getCoverWidth() {
        return coverWidth;
    }

    public GameResource setCoverWidth(int coverWidth) {
        this.coverWidth = coverWidth;
        return this;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public GameResource setStoryLine(String storyLine) {
        this.storyLine = storyLine;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public GameResource setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public GameResource setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
        return this;
    }

    public int getBackgroundHeight() {
        return backgroundHeight;
    }

    public GameResource setBackgroundHeight(int backgroundHeight) {
        this.backgroundHeight = backgroundHeight;
        return this;
    }

    public int getBackgroundWidth() {
        return backgroundWidth;
    }

    public GameResource setBackgroundWidth(int backgroundWidth) {
        this.backgroundWidth = backgroundWidth;
        return this;
    }
}
