package com.fribbels.db;

import java.util.HashMap;
import java.util.Map;

import com.fribbels.model.ArtifactStats;

public class ArtifactStatsDb {
    private Map<String, ArtifactStats> artifactStatsByName;

    public ArtifactStatsDb() {
        this.artifactStatsByName = new HashMap<>();
    }

    public ArtifactStats getArtifactStats(final String name, final int level) {
        final ArtifactStats base = this.artifactStatsByName.get(name);
        if (base == null) {
            return this.createDefaultStats();
        }

        return this.calculateLeveledStats(base, level);
    }

    public void setArtifactStatsByName(final Map<String, ArtifactStats> artifactStatsByName) {
        this.artifactStatsByName = artifactStatsByName;
    }

    private ArtifactStats createDefaultStats() {
        return ArtifactStats.builder()
                .attack(0f)
                .health(0f)
                .defense(0f)
                .build();
    }

    private ArtifactStats calculateLeveledStats(final ArtifactStats base, final int level) {
        final float progress = level / 30f;
        
        return ArtifactStats.builder()
                .attack(this.calculateLeveledValue(base.getAttack(), progress))
                .health(this.calculateLeveledValue(base.getHealth(), progress))
                .defense(this.calculateLeveledValue(base.getDefense(), progress))
                .build();
    }

    private float calculateLeveledValue(final float baseValue, final float progress) {
        if (baseValue == 0f) {
            return 0f;
        }
        final float maxValue = baseValue * 13;
        return (maxValue - baseValue) * progress + baseValue;
    }
}