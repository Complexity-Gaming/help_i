package com.complexity.gaming.help_i.games.domain.model.valueobjects;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProviderInformation implements Serializable {
    public String name;
    public String coverUrl;
    public String coverHeight;
    public String coverWeight;
    public String storyLine;
    public String summary;
}

