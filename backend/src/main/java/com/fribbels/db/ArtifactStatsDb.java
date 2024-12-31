package com.fribbels.db;

import com.fribbels.model.ArtifactStats;

import java.util.HashMap;
import java.util.Map;

public class ArtifactStatsDb {

    private Map<String, ArtifactStats> artifactStatsByName;

    public ArtifactStatsDb() {
        artifactStatsByName = new HashMap<>();
    }

    public ArtifactStats getArtifactStats(final String name, final int level) {
        if (artifactStatsByName.containsKey(name)) {
            final ArtifactStats base = artifactStatsByName.get(name);
            final float maxAttack = base.attack() * 13;
            final float maxHealth = base.health() * 13;

            final float leveledAttack = (maxAttack - base.attack()) * (level / 30f) + base.attack();
            final float leveledHealth = (maxHealth - base.health()) * (level / 30f) + base.health();

            return new ArtifactStats(leveledAttack, leveledHealth);
        }

        return new ArtifactStats(0f, 0f);
    }

    public void setArtifactStatsByName(final Map<String, ArtifactStats> artifactStatsByName) {
        this.artifactStatsByName = artifactStatsByName;
    }
}