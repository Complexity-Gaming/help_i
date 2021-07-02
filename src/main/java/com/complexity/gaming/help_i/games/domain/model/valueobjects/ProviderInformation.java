package com.complexity.gaming.help_i.games.domain.model.valueobjects;

import idgbsdk.model.GameModel;
import idgbsdk.model.ScreenshotModel;
import idgbsdk.util.ImageBuilder;
import idgbsdk.util.ImageSize;
import idgbsdk.util.ImageType;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Embeddable
public class ProviderInformation implements Serializable {
    private String providerName;
    private String coverUrl;
    private int coverHeight;
    private int coverWidth;
    private String storyLine;
    private String summary;
    private String backgroundImageUrl;
    private int backgroundHeight;
    private int backgroundWidth;


    public ProviderInformation(GameModel model) {
        this.providerName = model.getName();
        this.coverUrl = ImageBuilder.build(model.getCover().getImageId(), ImageSize.FHD, ImageType.PNG);
        this.coverHeight = model.getCover().getHeight();
        this.coverWidth = model.getCover().getWidth();
        this.storyLine = model.getStoryline();
        this.summary = model.getSummary();
        setBackgroundImageData(model.getScreenshots());
    }
    private void setBackgroundImageData(List<ScreenshotModel> list){
        Random rand = new Random();
        int upperbound = list.size();
        int position = rand.nextInt(upperbound);
        var screenshot = list.get(position);
        this.backgroundImageUrl = ImageBuilder.build(screenshot.getImageId(), ImageSize.SCREENSHOT_BIG, ImageType.JPEG);
        this.backgroundHeight = screenshot.getHeight();
        this.backgroundWidth = screenshot.getWidth();
    }
    public ProviderInformation() {

    }

    public String getProviderName() {
        return providerName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public int getCoverHeight() {
        return coverHeight;
    }

    public int getCoverWidth() {
        return coverWidth;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public String getSummary() {
        return summary;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public int getBackgroundHeight() {
        return backgroundHeight;
    }

    public int getBackgroundWidth() {
        return backgroundWidth;
    }

    public ProviderInformation setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public ProviderInformation setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
        return this;
    }

    public ProviderInformation setCoverHeight(int coverHeight) {
        this.coverHeight = coverHeight;
        return this;
    }

    public ProviderInformation setCoverWidth(int coverWidth) {
        this.coverWidth = coverWidth;
        return this;
    }

    public ProviderInformation setStoryLine(String storyLine) {
        this.storyLine = storyLine;
        return this;
    }

    public ProviderInformation setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public ProviderInformation setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
        return this;
    }

    public ProviderInformation setBackgroundHeight(int backgroundHeight) {
        this.backgroundHeight = backgroundHeight;
        return this;
    }

    public ProviderInformation setBackgroundWidth(int backgroundWidth) {
        this.backgroundWidth = backgroundWidth;
        return this;
    }
}


