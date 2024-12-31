package com.fribbels.request;

import com.fribbels.model.ArtifactStats;
import com.fribbels.model.Request;

import java.util.Map;

public class ArtifactStatsRequest extends Request {

    private Map<String, ArtifactStats> artifactStatsByName;

    public Map<String, ArtifactStats> getArtifactStatsByName() {
        return artifactStatsByName;
    }

    public void setArtifactStatsByName(Map<String, ArtifactStats> artifactStatsByName) {
        this.artifactStatsByName = artifactStatsByName;
    }

    @Override
    public String toString() {
        return "ArtifactStatsRequest [artifactStatsByName=" + artifactStatsByName + "]";
    }
}
