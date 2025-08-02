/*
    Calculates artifact hp/atk numbers - which technically have a tenths decimal
    value but that value isn't shown ingame. Using the ingame value will
    cause an off-by-one bug on HP/ATK calculations
*/

module.exports = {
    getStats: (name, level) => {
        const allData = HeroData.getAllArtifactData();
        const artifact = allData[name];
        const baseHealth = artifact?.stats.health || 0;
        const baseAttack = artifact?.stats.attack || 0;
        const baseDefense = artifact?.stats.defense || 0;
        const maxHealth = baseHealth * 13;
        const maxAttack = baseAttack * 13;
        const maxDefense = baseDefense * 13;

        const leveledHealth = (maxHealth - baseHealth) * (level/30) + baseHealth;
        const leveledAttack = (maxAttack - baseAttack) * (level/30) + baseAttack;
        const leveledDefense = (maxDefense - baseDefense) * (level/30) + baseDefense;

        result = {};

        if (leveledHealth > 0) {
            result.health = Utils.round10ths(leveledHealth);
        }

        if (leveledAttack > 0) {
            result.attack = Utils.round10ths(leveledAttack);
        }

        if (leveledDefense > 0) {
            result.defense = Utils.round10ths(leveledDefense);
        }

        return result;
    },
}