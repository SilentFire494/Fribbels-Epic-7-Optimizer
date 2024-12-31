package com.fribbels.model;

public class PassesContainer {
    boolean[] passes;
    boolean locked;
    String id;

    public boolean[] getPasses() {
        return passes;
    }

    public void setPasses(boolean[] passes) {
        this.passes = passes;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PassesContainer passesContainer;

        public Builder() {
            passesContainer = new PassesContainer();
        }

        public Builder passes(boolean[] passes) {
            passesContainer.setPasses(passes);
            return this;
        }

        public Builder locked(boolean locked) {
            passesContainer.setLocked(locked);
            return this;
        }

        public Builder id(String id) {
            passesContainer.setId(id);
            return this;
        }

        public PassesContainer build() {
            return passesContainer;
        }
    }

}
