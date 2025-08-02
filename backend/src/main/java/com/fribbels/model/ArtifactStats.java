package com.fribbels.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ArtifactStats {

    private final float attack;
    private final float health;
    private final float defense;
}
