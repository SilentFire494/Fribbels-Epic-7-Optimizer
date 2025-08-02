package com.fribbels.gpu;

import com.fribbels.model.Hero;
import com.fribbels.model.HeroStats;
import com.fribbels.request.OptimizationRequest;

public class SetFormat000OptimizerKernel extends GpuOptimizerKernel {

    public SetFormat000OptimizerKernel(final OptimizationRequest request, final float[] flattenedWeaponAccs, final float[] flattenedHelmetAccs, final float[] flattenedArmorAccs, final float[] flattenedNecklaceAccs, final float[] flattenedRingAccs, final float[] flattenedBootAccs, final float bonusBaseAtk, final float bonusBaseDef, final float bonusBaseHp, final float atkSetBonus, final float hpSetBonus, final float defSetBonus, final float speedSetBonus, final float revengeSetBonus, final float penSetDmgBonus, final float targetDefense, final float bonusMaxAtk, final float bonusMaxDef, final float bonusMaxHp, final int SETTING_RAGE_SET, final int SETTING_PEN_SET, final HeroStats base, final Hero hero, final long argSize, final long wSize, final long hSize, final long aSize, final long nSize, final long rSize, final long bSize, final long max, final int[] setSolutionBitMasks) {
        super(request, flattenedWeaponAccs, flattenedHelmetAccs, flattenedArmorAccs, flattenedNecklaceAccs, flattenedRingAccs, flattenedBootAccs, bonusBaseAtk, bonusBaseDef, bonusBaseHp, atkSetBonus, hpSetBonus, defSetBonus, speedSetBonus, revengeSetBonus, penSetDmgBonus, targetDefense, bonusMaxAtk, bonusMaxDef, bonusMaxHp, SETTING_RAGE_SET, SETTING_PEN_SET, base, hero, argSize, wSize, hSize, aSize, nSize, rSize, bSize, max, setSolutionBitMasks);
    }

    @Override
    public void run() {
        final int id = this.getGlobalId();

        final long i = this.max * this.iteration + id;
        if (i < this.wSize * this.hSize * this.aSize * this.nSize * this.rSize * this.bSize) {
            final long b = i % this.bSize;
            final long r = ( ( i - b ) / this.bSize ) %  this.rSize;
            final long n = ( ( i - r * this.bSize - b ) / (this.bSize * this.rSize) ) % this.nSize;
            final long a = ( ( i - n * this.rSize * this.bSize - r * this.bSize - b ) / (this.bSize * this.rSize * this.nSize) ) % this.aSize;
            final long h = ( ( i - a * this.nSize * this.rSize * this.bSize - n * this.rSize * this.bSize - r * this.bSize - b) / (this.bSize * this.rSize * this.nSize * this.aSize) ) % this.hSize;
            final long w = ( ( i - h * this.aSize * this.nSize * this.rSize * this.bSize - a * this.nSize * this.rSize * this.bSize - n * this.rSize * this.bSize - r * this.bSize - b) / (this.bSize * this.rSize * this.nSize * this.aSize * this.hSize) ) % this.wSize;

            final int wargSize = (int)(w * this.argSize);
            final float wAtk =   this.flattenedWeaponAccs[wargSize];
            final float wHp =    this.flattenedWeaponAccs[wargSize + 1];
            final float wDef =   this.flattenedWeaponAccs[wargSize + 2];
            final float wCr =    this.flattenedWeaponAccs[wargSize + 6];
            final float wCd =    this.flattenedWeaponAccs[wargSize + 7];
            final float wEff =   this.flattenedWeaponAccs[wargSize + 8];
            final float wRes =   this.flattenedWeaponAccs[wargSize + 9];
            final float wSpeed = this.flattenedWeaponAccs[wargSize + 10];
            final float wScore = this.flattenedWeaponAccs[wargSize + 11];
            final float wSet =   this.flattenedWeaponAccs[wargSize + 12];
            final float wPrio =  this.flattenedWeaponAccs[wargSize + 13];
            final float wUpg =   this.flattenedWeaponAccs[wargSize + 14];
            final float wConv =  this.flattenedWeaponAccs[wargSize + 15];
            final float wEq =    this.flattenedWeaponAccs[wargSize + 16];

            final int hargSize = (int)(h * this.argSize);
            final float hAtk =   this.flattenedHelmetAccs[hargSize];
            final float hHp =    this.flattenedHelmetAccs[hargSize + 1];
            final float hDef =   this.flattenedHelmetAccs[hargSize + 2];
            final float hCr =    this.flattenedHelmetAccs[hargSize + 6];
            final float hCd =    this.flattenedHelmetAccs[hargSize + 7];
            final float hEff =   this.flattenedHelmetAccs[hargSize + 8];
            final float hRes =   this.flattenedHelmetAccs[hargSize + 9];
            final float hSpeed = this.flattenedHelmetAccs[hargSize + 10];
            final float hScore = this.flattenedHelmetAccs[hargSize + 11];
            final float hSet =   this.flattenedHelmetAccs[hargSize + 12];
            final float hPrio =  this.flattenedHelmetAccs[hargSize + 13];
            final float hUpg =   this.flattenedHelmetAccs[hargSize + 14];
            final float hConv =  this.flattenedHelmetAccs[hargSize + 15];
            final float hEq =    this.flattenedHelmetAccs[hargSize + 16];

            final int aargSize = (int)(a * this.argSize);
            final float aAtk =   this.flattenedArmorAccs[aargSize];
            final float aHp =    this.flattenedArmorAccs[aargSize + 1];
            final float aDef =   this.flattenedArmorAccs[aargSize + 2];
            final float aCr =    this.flattenedArmorAccs[aargSize + 6];
            final float aCd =    this.flattenedArmorAccs[aargSize + 7];
            final float aEff =   this.flattenedArmorAccs[aargSize + 8];
            final float aRes =   this.flattenedArmorAccs[aargSize + 9];
            final float aSpeed = this.flattenedArmorAccs[aargSize + 10];
            final float aScore = this.flattenedArmorAccs[aargSize + 11];
            final float aSet =   this.flattenedArmorAccs[aargSize + 12];
            final float aPrio =  this.flattenedArmorAccs[aargSize + 13];
            final float aUpg =   this.flattenedArmorAccs[aargSize + 14];
            final float aConv =  this.flattenedArmorAccs[aargSize + 15];
            final float aEq =    this.flattenedArmorAccs[aargSize + 16];

            final int nargSize = (int)(n * this.argSize);
            final float nAtk =   this.flattenedNecklaceAccs[nargSize];
            final float nHp =    this.flattenedNecklaceAccs[nargSize + 1];
            final float nDef =   this.flattenedNecklaceAccs[nargSize + 2];
            final float nCr =    this.flattenedNecklaceAccs[nargSize + 6];
            final float nCd =    this.flattenedNecklaceAccs[nargSize + 7];
            final float nEff =   this.flattenedNecklaceAccs[nargSize + 8];
            final float nRes =   this.flattenedNecklaceAccs[nargSize + 9];
            final float nSpeed = this.flattenedNecklaceAccs[nargSize + 10];
            final float nScore = this.flattenedNecklaceAccs[nargSize + 11];
            final float nSet =   this.flattenedNecklaceAccs[nargSize + 12];
            final float nPrio =  this.flattenedNecklaceAccs[nargSize + 13];
            final float nUpg =   this.flattenedNecklaceAccs[nargSize + 14];
            final float nConv =  this.flattenedNecklaceAccs[nargSize + 15];
            final float nEq =    this.flattenedNecklaceAccs[nargSize + 16];

            final int rargSize = (int)(r * this.argSize);
            final float rAtk =   this.flattenedRingAccs[rargSize];
            final float rHp =    this.flattenedRingAccs[rargSize + 1];
            final float rDef =   this.flattenedRingAccs[rargSize + 2];
            final float rCr =    this.flattenedRingAccs[rargSize + 6];
            final float rCd =    this.flattenedRingAccs[rargSize + 7];
            final float rEff =   this.flattenedRingAccs[rargSize + 8];
            final float rRes =   this.flattenedRingAccs[rargSize + 9];
            final float rSpeed = this.flattenedRingAccs[rargSize + 10];
            final float rScore = this.flattenedRingAccs[rargSize + 11];
            final float rSet =   this.flattenedRingAccs[rargSize + 12];
            final float rPrio =  this.flattenedRingAccs[rargSize + 13];
            final float rUpg =   this.flattenedRingAccs[rargSize + 14];
            final float rConv =  this.flattenedRingAccs[rargSize + 15];
            final float rEq =    this.flattenedRingAccs[rargSize + 16];

            final int bargSize = (int)(b * this.argSize);
            final float bAtk =   this.flattenedBootAccs[bargSize];
            final float bHp =    this.flattenedBootAccs[bargSize + 1];
            final float bDef =   this.flattenedBootAccs[bargSize + 2];
            final float bCr =    this.flattenedBootAccs[bargSize + 6];
            final float bCd =    this.flattenedBootAccs[bargSize + 7];
            final float bEff =   this.flattenedBootAccs[bargSize + 8];
            final float bRes =   this.flattenedBootAccs[bargSize + 9];
            final float bSpeed = this.flattenedBootAccs[bargSize + 10];
            final float bScore = this.flattenedBootAccs[bargSize + 11];
            final float bSet =   this.flattenedBootAccs[bargSize + 12];
            final float bPrio =  this.flattenedBootAccs[bargSize + 13];
            final float bUpg =   this.flattenedBootAccs[bargSize + 14];
            final float bConv =  this.flattenedBootAccs[bargSize + 15];
            final float bEq =    this.flattenedBootAccs[bargSize + 16];

            final int iWset = (int)wSet;
            final int iHset = (int)hSet;
            final int iAset = (int)aSet;
            final int iNset = (int)nSet;
            final int iRset = (int)rSet;
            final int iBset = (int)bSet;

            final int setIndex = iWset * 1889568
                    + iHset * 104976
                    + iAset * 5832
                    + iNset * 324
                    + iRset * 18
                    + iBset;

            final int hpSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 1)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 2));
            final int defSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 3)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 4)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 5));
            final int atkSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 6));
            final int speedSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 7));
            final int crSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 8)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 9)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 10));
            final int effSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 11)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 12)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 13));
            final int cdSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 14));
            final int resSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 17)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 18)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 19));
            final int rageSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 21));
            final int penSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 23));
            final int revengeSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 24));
//            final int protectionSet = min(1, setSolutionBitMasks[setIndex] & (1 << 25));
//            final int injurySet = min(1, setSolutionBitMasks[setIndex] & (1 << 26));
            final int torrentSet = this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 27)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 28)) + this.min(1, this.setSolutionBitMasks[setIndex] & (1 << 29));

            final float atk =  ((this.bonusBaseAtk  + wAtk+hAtk+aAtk+nAtk+rAtk+bAtk + (atkSet * this.atkSetBonus)) * this.bonusMaxAtk);
            final float hp =   ((this.bonusBaseHp   + wHp+hHp+aHp+nHp+rHp+bHp + (hpSet * this.hpSetBonus + torrentSet * this.hpSetBonus/-2)) * this.bonusMaxHp);
            final float def =  ((this.bonusBaseDef  + wDef+hDef+aDef+nDef+rDef+bDef + (defSet * this.defSetBonus)) * this.bonusMaxDef);
            final int cr =     (int) (this.baseCr + wCr+hCr+aCr+nCr+rCr+bCr + (crSet * 12) + this.bonusCr + this.aeiCr);
            final int cd =     (int) (this.baseCd + wCd+hCd+aCd+nCd+rCd+bCd + (cdSet * 60) + this.bonusCd + this.aeiCd);
            final int eff =    (int) (this.baseEff   + wEff+hEff+aEff+nEff+rEff+bEff + (effSet * 20) + this.bonusEff + this.aeiEff);
            final int res =    (int) (this.baseRes   + wRes+hRes+aRes+nRes+rRes+bRes + (resSet * 20) + this.bonusRes + this.aeiRes);
            final int spd =    (int) (this.baseSpeed + wSpeed+hSpeed+aSpeed+nSpeed+rSpeed+bSpeed + (speedSet * this.speedSetBonus) + (revengeSet * this.revengeSetBonus) + this.bonusSpeed + this.aeiSpeed);

            final float critRate = this.min(100, cr) / 100f;
            final float critDamage = this.min(350, cd) / 100f;

            final int cp = (int) (((atk * 1.6f + atk * 1.6f * critRate * critDamage) * (1.0 + (spd - 45f) * 0.02f) + hp + def * 9.3f) * (1f + (res/100f + eff/100f) / 4f));

            final float penSetOn = this.min(penSet, 1);
            final float rageMultiplier = this.max(0, rageSet * this.SETTING_RAGE_SET * 0.3f);
            final float penMultiplier = this.max(1, penSetOn * this.SETTING_PEN_SET * this.penSetDmgBonus);
            final float torrentMultiplier = this.max(0, torrentSet * 0.1f);
            final float spdDiv1000 = (float)spd/1000;
            final float pctDmgMultiplier = 1 + rageMultiplier + torrentMultiplier;

            final int ehp = (int) (hp * (def/300 + 1));
            final int hpps = (int) (hp*spdDiv1000);
            final int ehpps = (int) ((float)ehp*spdDiv1000);
            final int dmg = (int) (((critRate * atk * critDamage) + (1-critRate) * atk) * penMultiplier * pctDmgMultiplier);
            final int dmgps = (int) ((float)dmg*spdDiv1000);
            final int mcdmg = (int) (atk * critDamage * penMultiplier * pctDmgMultiplier);
            final int mcdmgps = (int) ((float)mcdmg*spdDiv1000);
            final int dmgh = (int) ((critDamage * hp * penMultiplier * pctDmgMultiplier)/10);
            final int dmgd = (int) ((critDamage * def * penMultiplier * pctDmgMultiplier));

            final int s1 = this.getSkillValue(0, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
            final int s2 = this.getSkillValue(1, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);
            final int s3 = this.getSkillValue(2, atk, def, hp, spd, critDamage, pctDmgMultiplier, penSetOn);

            final int score = (int) (wScore+hScore+aScore+nScore+rScore+bScore);
            final int priority = (int) (wPrio+hPrio+aPrio+nPrio+rPrio+bPrio);
            final int upgrades = (int) (wUpg+hUpg+aUpg+nUpg+rUpg+bUpg);
            final int conversions = (int) (wConv+hConv+aConv+nConv+rConv+bConv);
            final int eq = (int) (wEq+hEq+aEq+nEq+rEq+bEq);

            final float bsHp = (hp - this.baseHp - this.artifactHealth - (hpSet * this.hpSetBonus) + (torrentSet * this.hpSetBonus/2)) / this.baseHp * 100;
            final float bsAtk = (atk - this.baseAtk - this.artifactAttack - (atkSet * this.atkSetBonus)) / this.baseAtk * 100;
            final float bsDef = (def - this.baseDef - this.artifactDefense - (defSet * this.defSetBonus)) / this.baseDef * 100;
            final float bsCr = (cr - this.baseCr - (crSet * 12));
            final float bsCd = (cd - this.baseCd - (cdSet * 60));
            final float bsEff = (eff - this.baseEff - (effSet * 20));
            final float bsRes = (res - this.baseRes - (resSet * 20));
            final float bsSpd = (spd - this.baseSpeed - (speedSet * this.speedSetBonus) - (revengeSet * this.revengeSetBonus));

            //            final float atk =  ((bonusBaseAtk  + wAtk+hAtk+aAtk+nAtk+rAtk+bAtk + (atkSet * atkSetBonus)) * bonusMaxAtk);
            //            final float hp =   ((bonusBaseHp   + wHp+hHp+aHp+nHp+rHp+bHp + (hpSet * hpSetBonus + torrentSet * hpSetBonus/-2)) * bonusMaxHp);
            //            final float def =  ((bonusBaseDef  + wDef+hDef+aDef+nDef+rDef+bDef + (defSet * defSetBonus)) * bonusMaxDef);
            //            final int cr =     (int) (baseCr + wCr+hCr+aCr+nCr+rCr+bCr + (crSet * 12) + bonusCr + aeiCr);
            //            final int cd =     (int) (baseCd + wCd+hCd+aCd+nCd+rCd+bCd + (cdSet * 60) + bonusCd + aeiCd);
            //            final int eff =    (int) (baseEff   + wEff+hEff+aEff+nEff+rEff+bEff + (effSet * 20) + bonusEff + aeiEff);
            //            final int res =    (int) (baseRes   + wRes+hRes+aRes+nRes+rRes+bRes + (resSet * 20) + bonusRes + aeiRes);
            //            final int spd =    (int) (baseSpeed + wSpeed+hSpeed+aSpeed+nSpeed+rSpeed+bSpeed + (speedSet * speedSetBonus) + (revengeSet * revengeSetBonus) + bonusSpeed + aeiSpeed);

            final int bs = (int) (bsHp + bsAtk + bsDef + bsCr*1.6f + bsCd*1.14f + bsEff + bsRes + bsSpd*2);

            final boolean f1 = atk < this.inputAtkMinLimit || atk > this.inputAtkMaxLimit
                    ||  hp  < this.inputHpMinLimit  || hp > this.inputHpMaxLimit
                    ||  def < this.inputDefMinLimit || def > this.inputDefMaxLimit
                    ||  spd < this.inputSpdMinLimit || spd > this.inputSpdMaxLimit
                    ||  cr < this.inputCrMinLimit   || cr > this.inputCrMaxLimit
                    ||  cd < this.inputCdMinLimit   || cd > this.inputCdMaxLimit
                    ||  eff < this.inputEffMinLimit || eff > this.inputEffMaxLimit
                    ||  res < this.inputResMinLimit || res > this.inputResMaxLimit
                    ||  cp < this.inputMinCpLimit || cp > this.inputMaxCpLimit;
            final boolean f2 = hpps < this.inputMinHppsLimit || hpps > this.inputMaxHppsLimit
                    ||  ehp < this.inputMinEhpLimit || ehp > this.inputMaxEhpLimit
                    ||  ehpps < this.inputMinEhppsLimit || ehpps > this.inputMaxEhppsLimit
                    ||  dmg < this.inputMinDmgLimit || dmg > this.inputMaxDmgLimit
                    ||  dmgps < this.inputMinDmgpsLimit || dmgps > this.inputMaxDmgpsLimit
                    ||  mcdmg < this.inputMinMcdmgLimit || mcdmg > this.inputMaxMcdmgLimit
                    ||  mcdmgps < this.inputMinMcdmgpsLimit || mcdmgps > this.inputMaxMcdmgpsLimit
                    ||  dmgh < this.inputMinDmgHLimit || dmgh > this.inputMaxDmgHLimit
                    ||  dmgd < this.inputMinDmgDLimit || dmgd > this.inputMaxDmgDLimit
                    ||  score < this.inputMinScoreLimit || score > this.inputMaxScoreLimit;
            final boolean f3 = priority < this.inputMinPriorityLimit || priority > this.inputMaxPriorityLimit
                    ||  upgrades < this.inputMinUpgradesLimit || upgrades > this.inputMaxUpgradesLimit
                    ||  conversions < this.inputMinConversionsLimit || conversions > this.inputMaxConversionsLimit
                    ||  eq < this.inputMinEquippedLimit || eq > this.inputMaxEquippedLimit
                    ||  s1 < this.inputMinS1Limit || s1 > this.inputMaxS1Limit
                    ||  s2 < this.inputMinS2Limit || s2 > this.inputMaxS2Limit
                    ||  s3 < this.inputMinS3Limit || s3 > this.inputMaxS3Limit
                    ||  bs < this.inputMinBSLimit || bs > this.inputMaxBSLimit;

            this.passes[id] = !(f1 || f2 || f3);
        }
    }

    private int getSkillValue(final int s,
                              final float atk,
                              final float def,
                              final float hp,
                              final float spd,
                              final float critDamage,
                              final float pctDmgMultiplier,
                              final float penSetOn) {
        //        final float effectiveDefense = targetDefense * targets[s] * penMultiplier
        //        final float realDefense = targetDefense * (penSetOn * 0.12f + 0);
        final float realPenetration = (1 - this.penetration[s]) * (1 - penSetOn * 0.15f * this.targets[s]);
        final float statScalings =
                this.selfHpScaling[s] *hp +
                        this.selfAtkScaling[s]*atk +
                        this.selfDefScaling[s]*def +
                        this.selfSpdScaling[s]*spd;
        final float hitTypeMultis = this.crit[s] * (critDamage+this.cdmgIncrease[s]) + this.hitMulti[s];
        final float increasedValueMulti = 1 + this.increasedValue[s];
        final float dmgUpMod = 1 + this.selfSpdScaling[s] * spd;
        final float extraDamage = (
                this.extraSelfHpScaling[s] *hp +
                        this.extraSelfAtkScaling[s]*atk +
                        this.extraSelfDefScaling[s]*def) * 1.871f * 1f/(this.targetDefense*0.3f/300f + 1f);
        final float offensiveValue = (atk * this.rate[s] + statScalings) * 1.871f * this.pow[s] * increasedValueMulti * hitTypeMultis * dmgUpMod * pctDmgMultiplier;
        final float supportValue = this.selfHpScaling[s] * hp * this.support[s] + this.selfAtkScaling[s] * atk * this.support[s] + this.selfDefScaling[s] * def * this.support[s];
        final float defensiveValue = 1f/(this.targetDefense*this.max(0, realPenetration)/300f + 1f);
        final int value = (int)(offensiveValue * defensiveValue + supportValue + extraDamage);

        //        System.out.println("S" + (s+1) + " " + value + " " + (hitTypeMultis) + " " + (1.871f * m.getPow()[s]));
        //        System.out.println(m);

        return value;
    }
}
