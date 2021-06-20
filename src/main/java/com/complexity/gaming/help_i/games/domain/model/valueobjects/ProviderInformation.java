package com.complexity.gaming.help_i.games.domain.model.valueobjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProviderInformation implements Serializable {
    public String name;
    public String coverUrl;
    public int coverHeight;
    public int coverWeight;
    public String storyLine;
    public String summary;

    public ProviderInformation(String name, String coverUrl, int coverHeight, int coverWeight, String storyLine, String summary) {
        this.name = name;
        this.coverUrl = coverUrl;
        this.coverHeight = coverHeight;
        this.coverWeight = coverWeight;
        this.storyLine = storyLine;
        this.summary = summary;
    }
}

