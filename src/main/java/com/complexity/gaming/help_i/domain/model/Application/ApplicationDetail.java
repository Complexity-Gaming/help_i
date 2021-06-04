package com.complexity.gaming.help_i.domain.model.Application;

import javax.persistence.Embeddable;
import java.net.URI;

@Embeddable
public class ApplicationDetail {

    private String Description;
    private URI VideoApplication;
    private String ReviewComment;
    private EApplicationStatus Status;

    public ApplicationDetail(String description, URI videoApplication, String reviewComment, EApplicationStatus status) {
        Description = description;
        VideoApplication = videoApplication;
        ReviewComment = reviewComment;
        Status = status;
    }

    public ApplicationDetail() {
    }

    public String getDescription() {
        return Description;
    }

    public URI getVideoApplication() {
        return VideoApplication;
    }

    public String getReviewComment() {
        return ReviewComment;
    }

    public EApplicationStatus getStatus() {
        return Status;
    }

    private ApplicationDetail setDescription(String description) {
        Description = description;
        return this;
    }

    private ApplicationDetail setVideoApplication(URI videoApplication) {
        VideoApplication = videoApplication;
        return this;
    }

    private ApplicationDetail setReviewComment(String reviewComment) {
        ReviewComment = reviewComment;
        return this;
    }

    private ApplicationDetail setStatus(EApplicationStatus status) {
        Status = status;
        return this;
    }
}
