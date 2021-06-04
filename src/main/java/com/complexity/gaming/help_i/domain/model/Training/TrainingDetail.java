package com.complexity.gaming.help_i.domain.model.Training;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.Date;

@Embeddable
public class TrainingDetail {

    private URI videoUri;
    private Date publishedDate;
    private String currency;
    private Double price;

    public TrainingDetail(URI videoUri,Date publishedDate,String currency,Double price) {
        this.videoUri = videoUri;
        this.publishedDate = publishedDate;
        this.currency = currency;
        this.price = price;
    }

    public TrainingDetail() {
    }

    public URI getVideoUri() {
        return videoUri;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getPrice() {
        return price;
    }

    private TrainingDetail setVideoUri(URI videoUri) {
        this.videoUri = videoUri;
        return this;
    }

    private TrainingDetail setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    private TrainingDetail setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    private TrainingDetail setPrice(Double price) {
        this.price = price;
        return this;
    }

}
