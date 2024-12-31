package com.fribbels.response;

public class OcrResponse extends Response {

    private String title;
    private String enhance;
    private String level;
    private String main;
    private String substats;
    private String substatsText;
    private String substatsNumbers;
    private String set;
    private String hero;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnhance() {
        return enhance;
    }

    public void setEnhance(String enhance) {
        this.enhance = enhance;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSubstats() {
        return substats;
    }

    public void setSubstats(String substats) {
        this.substats = substats;
    }

    public String getSubstatsText() {
        return substatsText;
    }

    public void setSubstatsText(String substatsText) {
        this.substatsText = substatsText;
    }

    public String getSubstatsNumbers() {
        return substatsNumbers;
    }

    public void setSubstatsNumbers(String substatsNumbers) {
        this.substatsNumbers = substatsNumbers;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "OcrResponse [title=" + title + ", enhance=" + enhance + ", level=" + level + ", main=" + main
                + ", substats=" + substats + ", substatsText=" + substatsText + ", substatsNumbers=" + substatsNumbers
                + ", set=" + set + ", hero=" + hero + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private OcrResponse ocrResponse;

        public Builder() {
            ocrResponse = new OcrResponse();
        }

        public Builder title(String title) {
            ocrResponse.setTitle(title);
            return this;
        }

        public Builder main(String main) {
            ocrResponse.setMain(main);
            return this;
        }

        public Builder set(String set) {
            ocrResponse.setSet(set);
            return this;
        }

        public Builder enhance(String enhance) {
            ocrResponse.setEnhance(enhance);
            return this;
        }

        public Builder level(String level) {
            ocrResponse.setLevel(level);
            return this;
        }

        public Builder substatsText(String substatsText) {
            ocrResponse.setSubstatsText(substatsText);
            return this;
        }

        public Builder substatsNumbers(String substatsNumbers) {
            ocrResponse.setSubstatsNumbers(substatsNumbers);
            return this;
        }

        public OcrResponse build() {
            return ocrResponse;
        }
    }

}
