package com.complexity.gaming.help_i.training.domain.model;

import com.complexity.gaming.help_i.shared.model.Money;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.net.URI;
import java.util.Date;

@Embeddable
public class TrainingDetail {

    private URI videoUri;
    private Date publishedDate;

    @Embedded
    private Money price;

    public TrainingDetail() {
    }

    public TrainingDetail(URI videoUri, Date publishedDate, Money price) {
        this.videoUri = videoUri;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public URI getVideoUri() {
        return videoUri;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    private TrainingDetail setVideoUri(URI videoUri) {
        this.videoUri = videoUri;
        return this;
    }

    private TrainingDetail setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public Money getPrice() {
        return price;
    }
}
