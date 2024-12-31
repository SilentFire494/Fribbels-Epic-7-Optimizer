package com.fribbels.model;

public class HeroSkillOptions {

    public SingleSkillOptions s1;
    public SingleSkillOptions s2;
    public SingleSkillOptions s3;

    public HeroSkillOptions() {
    }

    public HeroSkillOptions(SingleSkillOptions s1, SingleSkillOptions s2, SingleSkillOptions s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public SingleSkillOptions getS1() {
        return s1;
    }

    public void setS1(SingleSkillOptions s1) {
        this.s1 = s1;
    }

    public SingleSkillOptions getS2() {
        return s2;
    }

    public void setS2(SingleSkillOptions s2) {
        this.s2 = s2;
    }

    public SingleSkillOptions getS3() {
        return s3;
    }

    public void setS3(SingleSkillOptions s3) {
        this.s3 = s3;
    }

    @Override
    public String toString() {
        return "HeroSkillOptions [s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        HeroSkillOptions heroSkillOptions;

        public Builder() {
            heroSkillOptions = new HeroSkillOptions();
        }

        public Builder s1(SingleSkillOptions s1) {
            heroSkillOptions.s1 = s1;
            return this;
        }

        public Builder s2(SingleSkillOptions s2) {
            heroSkillOptions.s2 = s2;
            return this;
        }

        public Builder s3(SingleSkillOptions s3) {
            heroSkillOptions.s3 = s3;
            return this;
        }
    }

}
