package com.fribbels.model;

public record ArtifactStats(Float attack, Float health) {

    @Override
    public String toString() {
        return "ArtifactStats []";
    }
}
