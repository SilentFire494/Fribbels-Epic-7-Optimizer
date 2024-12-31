package com.fribbels.model;

import java.util.Arrays;

public class HeroSkills {

    public SkillData[] s1;
    public SkillData[] s2;
    public SkillData[] s3;

    public HeroSkills() {
    }

    public HeroSkills(SkillData[] s1, SkillData[] s2, SkillData[] s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public SkillData[] getS1() {
        return s1;
    }

    public void setS1(SkillData[] s1) {
        this.s1 = s1;
    }

    public SkillData[] getS2() {
        return s2;
    }

    public void setS2(SkillData[] s2) {
        this.s2 = s2;
    }

    public SkillData[] getS3() {
        return s3;
    }

    public void setS3(SkillData[] s3) {
        this.s3 = s3;
    }

    @Override
    public String toString() {
        return "HeroSkills [s1=" + Arrays.toString(s1) + ", s2=" + Arrays.toString(s2) + ", s3=" + Arrays.toString(s3)
                + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        HeroSkills heroSkills;

        public Builder() {
            heroSkills = new HeroSkills();
        }

        public Builder s1(SkillData[] s1) {
            heroSkills.s1 = s1;
            return this;
        }

        public Builder s2(SkillData[] s2) {
            heroSkills.s2 = s2;
            return this;
        }

        public Builder s3(SkillData[] s3) {
            heroSkills.s3 = s3;
            return this;
        }

        public HeroSkills build() {
            return heroSkills;
        }
    }

}
