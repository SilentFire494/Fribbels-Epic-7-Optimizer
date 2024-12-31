package com.fribbels.request;

import com.fribbels.model.Request;

public class BonusStatsRequest extends Request {

    private int atk;
    private int def;
    private int hp;
    private float atkPercent;
    private float defPercent;
    private float hpPercent;
    private int speed;
    private float cr;
    private float cd;
    private float eff;
    private float res;

    private float aeiAtk;
    private float aeiDef;
    private float aeiHp;
    private float aeiAtkPercent;
    private float aeiDefPercent;
    private float aeiHpPercent;
    private int aeiSpeed;
    private float aeiCr;
    private float aeiCd;
    private float aeiEff;
    private float aeiRes;

    private float finalAtkMultiplier;
    private float finalDefMultiplier;
    private float finalHpMultiplier;

    private float artifactAttack;
    private float artifactHealth;

    private String artifactName;
    private String artifactLevel;
    private String imprintNumber;
    private String eeNumber;
    private String heroId;

    private int stars;

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getAtkPercent() {
        return atkPercent;
    }

    public void setAtkPercent(float atkPercent) {
        this.atkPercent = atkPercent;
    }

    public float getDefPercent() {
        return defPercent;
    }

    public void setDefPercent(float defPercent) {
        this.defPercent = defPercent;
    }

    public float getHpPercent() {
        return hpPercent;
    }

    public void setHpPercent(float hpPercent) {
        this.hpPercent = hpPercent;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getCr() {
        return cr;
    }

    public void setCr(float cr) {
        this.cr = cr;
    }

    public float getCd() {
        return cd;
    }

    public void setCd(float cd) {
        this.cd = cd;
    }

    public float getEff() {
        return eff;
    }

    public void setEff(float eff) {
        this.eff = eff;
    }

    public float getRes() {
        return res;
    }

    public void setRes(float res) {
        this.res = res;
    }

    public float getAeiAtk() {
        return aeiAtk;
    }

    public void setAeiAtk(float aeiAtk) {
        this.aeiAtk = aeiAtk;
    }

    public float getAeiDef() {
        return aeiDef;
    }

    public void setAeiDef(float aeiDef) {
        this.aeiDef = aeiDef;
    }

    public float getAeiHp() {
        return aeiHp;
    }

    public void setAeiHp(float aeiHp) {
        this.aeiHp = aeiHp;
    }

    public float getAeiAtkPercent() {
        return aeiAtkPercent;
    }

    public void setAeiAtkPercent(float aeiAtkPercent) {
        this.aeiAtkPercent = aeiAtkPercent;
    }

    public float getAeiDefPercent() {
        return aeiDefPercent;
    }

    public void setAeiDefPercent(float aeiDefPercent) {
        this.aeiDefPercent = aeiDefPercent;
    }

    public float getAeiHpPercent() {
        return aeiHpPercent;
    }

    public void setAeiHpPercent(float aeiHpPercent) {
        this.aeiHpPercent = aeiHpPercent;
    }

    public int getAeiSpeed() {
        return aeiSpeed;
    }

    public void setAeiSpeed(int aeiSpeed) {
        this.aeiSpeed = aeiSpeed;
    }

    public float getAeiCr() {
        return aeiCr;
    }

    public void setAeiCr(float aeiCr) {
        this.aeiCr = aeiCr;
    }

    public float getAeiCd() {
        return aeiCd;
    }

    public void setAeiCd(float aeiCd) {
        this.aeiCd = aeiCd;
    }

    public float getAeiEff() {
        return aeiEff;
    }

    public void setAeiEff(float aeiEff) {
        this.aeiEff = aeiEff;
    }

    public float getAeiRes() {
        return aeiRes;
    }

    public void setAeiRes(float aeiRes) {
        this.aeiRes = aeiRes;
    }

    public float getFinalAtkMultiplier() {
        return finalAtkMultiplier;
    }

    public void setFinalAtkMultiplier(float finalAtkMultiplier) {
        this.finalAtkMultiplier = finalAtkMultiplier;
    }

    public float getFinalDefMultiplier() {
        return finalDefMultiplier;
    }

    public void setFinalDefMultiplier(float finalDefMultiplier) {
        this.finalDefMultiplier = finalDefMultiplier;
    }

    public float getFinalHpMultiplier() {
        return finalHpMultiplier;
    }

    public void setFinalHpMultiplier(float finalHpMultiplier) {
        this.finalHpMultiplier = finalHpMultiplier;
    }

    public float getArtifactAttack() {
        return artifactAttack;
    }

    public void setArtifactAttack(float artifactAttack) {
        this.artifactAttack = artifactAttack;
    }

    public float getArtifactHealth() {
        return artifactHealth;
    }

    public void setArtifactHealth(float artifactHealth) {
        this.artifactHealth = artifactHealth;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    public String getArtifactLevel() {
        return artifactLevel;
    }

    public void setArtifactLevel(String artifactLevel) {
        this.artifactLevel = artifactLevel;
    }

    public String getImprintNumber() {
        return imprintNumber;
    }

    public void setImprintNumber(String imprintNumber) {
        this.imprintNumber = imprintNumber;
    }

    public String getEeNumber() {
        return eeNumber;
    }

    public void setEeNumber(String eeNumber) {
        this.eeNumber = eeNumber;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "BonusStatsRequest [atk=" + atk + ", def=" + def + ", hp=" + hp + ", atkPercent=" + atkPercent
                + ", defPercent=" + defPercent + ", hpPercent=" + hpPercent + ", speed=" + speed + ", cr=" + cr
                + ", cd=" + cd + ", eff=" + eff + ", res=" + res + ", aeiAtk=" + aeiAtk + ", aeiDef=" + aeiDef
                + ", aeiHp=" + aeiHp + ", aeiAtkPercent=" + aeiAtkPercent + ", aeiDefPercent=" + aeiDefPercent
                + ", aeiHpPercent=" + aeiHpPercent + ", aeiSpeed=" + aeiSpeed + ", aeiCr=" + aeiCr + ", aeiCd=" + aeiCd
                + ", aeiEff=" + aeiEff + ", aeiRes=" + aeiRes + ", finalAtkMultiplier=" + finalAtkMultiplier
                + ", finalDefMultiplier=" + finalDefMultiplier + ", finalHpMultiplier=" + finalHpMultiplier
                + ", artifactAttack=" + artifactAttack + ", artifactHealth=" + artifactHealth + ", artifactName="
                + artifactName + ", artifactLevel=" + artifactLevel + ", imprintNumber=" + imprintNumber + ", eeNumber="
                + eeNumber + ", heroId=" + heroId + ", stars=" + stars + "]";
    }

}
