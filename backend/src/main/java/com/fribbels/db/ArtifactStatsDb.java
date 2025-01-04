package com.fribbels.db;

import com.fribbels.model.ArtifactStats;

import java.util.HashMap;
import java.util.Map;

/**
 * The ArtifactStatsDb class manages a collection of artifact stats
 * for different artifact names. It provides methods to retrieve
 * leveled artifact stats based on the name and level.
 */
public class ArtifactStatsDb {

    private Map<String, ArtifactStats> artifactStatsByName;

    public ArtifactStatsDb() {
        artifactStatsByName = new HashMap<>();
    }

    /**
     * Retrieves the leveled artifact stats for a given artifact name and level.
     * 
     * @param name  The name of the artifact.
     * @param level The level of the artifact (1-30).
     * @return The leveled artifact stats, or zero stats if the artifact does not exist.
     */
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

    /**
     * Sets the artifact stats map with the given data.
     * 
     * @param artifactStatsByName A map containing artifact names as keys and their corresponding stats.
     */
    public void setArtifactStatsByName(final Map<String, ArtifactStats> artifactStatsByName) {
        this.artifactStatsByName = artifactStatsByName;
    }
}
