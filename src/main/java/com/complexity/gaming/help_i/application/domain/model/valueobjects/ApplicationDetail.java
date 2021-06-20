package com.complexity.gaming.help_i.application.domain.model.valueobjects;

import javax.persistence.Embeddable;
import java.net.URI;

@Embeddable
public class ApplicationDetail {

    private String Description;
    private URI VideoApplication;

    public ApplicationDetail(String description, URI videoApplication) {
        Description = description;
        VideoApplication = videoApplication;
    }

    public ApplicationDetail() {
    }

    public String getDescription() {
        return Description;
    }

    public URI getVideoApplication() {
        return VideoApplication;
    }

    private ApplicationDetail setDescription(String description) {
        Description = description;
        return this;
    }

    private ApplicationDetail setVideoApplication(URI videoApplication) {
        VideoApplication = videoApplication;
        return this;
    }

}
