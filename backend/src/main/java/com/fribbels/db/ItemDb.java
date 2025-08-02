package com.fribbels.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fribbels.handler.HeroesRequestHandler;
import com.fribbels.model.AugmentedStats;
import com.fribbels.model.Hero;
import com.fribbels.model.Item;

public class ItemDb {

    private static final double SPEED_FACTOR = 8.0 / 4.0;
    private static final double CRIT_DAMAGE_FACTOR = 8.0 / 7.0;
    private static final double CRIT_RATE_FACTOR = 8.0 / 5.0;
    private static final double ATK_FACTOR = 3.46 / 39;
    private static final double DEF_FACTOR = 4.99 / 31;
    private static final double HP_FACTOR = 3.09 / 174;

    private List<Item> items = new ArrayList<>();
    private final HeroDb heroDb;

    public ItemDb(final HeroDb heroDb) {
        this.heroDb = heroDb;
    }

    public void addItems(final List<Item> newItems) {
        final List<Item> validItems = newItems.stream()
                .filter(this::isValid)
                .map(this::calculateWss)
                .toList();
        this.items.addAll(validItems);
    }

    public void addItem(final Item newItem) {
        if (this.isValid(newItem)) {
            this.items.add(this.calculateWss(newItem));
        }
    }

    public void setItems(final List<Item> newItems) {
        final List<Item> validItems = newItems.stream()
                .filter(this::isValid)
                .map(this::calculateWss)
                .toList();

        this.items = validItems;
    }

    public void replaceItems(final Item newItem) {
        final List<Item> updatedItems = new ArrayList<>(this.items.size());

        this.items.stream()
                .filter(item -> !item.getId().equals(newItem.getId()))
                .forEach(updatedItems::add);

        updatedItems.add(newItem);

        this.items = updatedItems.stream()
                .filter(this::isValid)
                .map(this::calculateWss)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Item> getAllItems() {
        return this.items;
    }

    public Item calculateWss(final Item item) {
        final AugmentedStats stats = item.getAugmentedStats();
        final AugmentedStats reforgedStats = item.getReforgedStats() == null ? stats : item.getReforgedStats();

        item.setWss((int) Math.round(this.calculateBaseWss(stats)));
        item.setReforgedWss((int) Math.round(this.calculateBaseWss(reforgedStats)));
        item.setDpsWss((int) Math.round(this.calculateDpsWss(reforgedStats)));
        item.setSupportWss((int) Math.round(this.calculateSupportWss(reforgedStats)));
        item.setCombatWss((int) Math.round(this.calculateCombatWss(reforgedStats)));

        return item;
    }

    public Item getItemById(final String id) {
        return this.items.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Item> getItemsById(final List<String> ids) {
        return ids.stream()
                .map(this::getItemById)
                .toList();
    }

    public void unequipItem(final String id) {
        final Item existingItem = this.getItemById(id);

        if (existingItem == null) {
            return;
        }

        final String previousOwnerId = existingItem.getEquippedById();
        final Hero hero = this.heroDb.getHeroById(previousOwnerId);

        if (hero != null) {
            hero.getEquipment().remove(existingItem.getGear());
        }

        existingItem.setEquippedById(null);
        existingItem.setEquippedByName(null);

        if (HeroesRequestHandler.isSettingUnlockOnUnequip()) {
            existingItem.setLocked(false);
        }
    }

    public void deleteItem(final String id) {
        final Item existingItem = this.getItemById(id);

        if (existingItem == null)
            return;

        final String heroId = existingItem.getEquippedById();
        final Hero hero = this.heroDb.getHeroById(heroId);

        if (hero != null) {
            hero.getEquipment().remove(existingItem.getGear());
        }

        this.items.removeIf(item -> item.getId().equals(id));
    }

    public void equipItemOnHero(final String itemId, final String heroId) {
        final Item item = this.getItemById(itemId);
        final Hero hero = this.heroDb.getHeroById(heroId);

        if (item == null || hero == null) {
            return;
        }

        final String previousOwner = item.getEquippedById();

        if (previousOwner != null && !previousOwner.equals(heroId)) {
            System.out.println("PREV OWNER" + previousOwner);
            this.heroDb.getHeroById(previousOwner).getEquipment().remove(item.getGear());
        }

        final Item previousItem = hero.switchItem(item);

        if (previousItem != null && !previousItem.getId().equals(item.getId())) {
            System.out.println("PREV ITEM" + previousItem);
            this.unequipItem(previousItem.getId());
        }

        hero.getEquipment().put(item.getGear(), item);
        item.setEquippedById(heroId);
        item.setEquippedByName(hero.getName());
    }

    private boolean isValid(final Item item) {
        return item.getSet() != null;
    }

    private double calculateBaseWss(final AugmentedStats stats) {
        return stats.getAttackPercent() +
                stats.getDefensePercent() +
                stats.getHealthPercent() +
                stats.getEffectResistance() +
                stats.getEffectiveness() +
                stats.getSpeed() * SPEED_FACTOR +
                stats.getCritDamage() * CRIT_DAMAGE_FACTOR +
                stats.getCritRate() * CRIT_RATE_FACTOR +
                stats.getAttack() * ATK_FACTOR +
                stats.getDefense() * DEF_FACTOR +
                stats.getHealth() * HP_FACTOR;
    }

    private double calculateDpsWss(final AugmentedStats stats) {
        return stats.getAttackPercent() +
                stats.getSpeed() * SPEED_FACTOR +
                stats.getCritDamage() * CRIT_DAMAGE_FACTOR +
                stats.getCritRate() * CRIT_RATE_FACTOR +
                stats.getAttack() * ATK_FACTOR;
    }

    private double calculateSupportWss(final AugmentedStats stats) {
        return stats.getDefensePercent() +
                stats.getHealthPercent() +
                stats.getEffectResistance() +
                stats.getSpeed() * SPEED_FACTOR +
                stats.getDefense() * DEF_FACTOR +
                stats.getHealth() * HP_FACTOR;
    }

    private double calculateCombatWss(final AugmentedStats stats) {
        return stats.getAttackPercent() +
                stats.getDefensePercent() +
                stats.getHealthPercent() +
                stats.getSpeed() * SPEED_FACTOR +
                stats.getCritDamage() * CRIT_DAMAGE_FACTOR +
                stats.getCritRate() * CRIT_RATE_FACTOR +
                stats.getAttack() * ATK_FACTOR +
                stats.getDefense() * DEF_FACTOR +
                stats.getHealth() * HP_FACTOR;
    }
}
