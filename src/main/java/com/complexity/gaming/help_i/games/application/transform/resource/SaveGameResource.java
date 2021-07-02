package com.complexity.gaming.help_i.games.application.transform.resource;

public class SaveGameResource {
    private String name;
    private int ProviderId;

    public String getName() {
        return name;
    }

    public SaveGameResource setName(String name) {
        this.name = name;
        return this;
    }

    public int getProviderId() {
        return ProviderId;
    }

    public SaveGameResource setProviderId(int providerId) {
        ProviderId = providerId;
        return this;
    }
}
