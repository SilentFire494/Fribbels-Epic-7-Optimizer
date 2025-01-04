package com.fribbels.db;

import com.fribbels.handler.HeroesRequestHandler;
import com.fribbels.model.AugmentedStats;
import com.fribbels.model.Hero;
import com.fribbels.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The ItemDb class manages a collection of items, allowing operations such as adding, setting, replacing, equipping, 
 * unequipping, and deleting items. It also calculates various WSS (Weighted Stats Score) values for items based on their stats.
 */
public class ItemDb {

    private List<Item> items;
    private HeroDb heroDb;

    public ItemDb(final HeroDb heroDb) {
        items = new ArrayList<>();
        this.heroDb = heroDb;
    }

    /**
     * Adds a list of items to the database after filtering valid items and calculating their WSS values.
     *
     * @param newItems A list of new items to add.
     */
    public void addItems(final List<Item> newItems) {
        List<Item> validItems = newItems.stream()
                .filter(this::isValid)
                .map(this::calculateWss)
                .toList();

        items.addAll(validItems);
    }

    /**
     * Replaces the current list of items with a new list after filtering valid items and calculating their WSS values.
     *
     * @param newItems A list of new items to replace the current ones.
     */
    public void setItems(final List<Item> newItems) {
        List<Item> validItems = newItems.stream()
                .filter(this::isValid)
                .map(this::calculateWss)
                .toList();

        items = validItems;
    }

    /**
     * Replaces an item in the database with a new item, ensuring the new item is valid and its WSS is calculated.
     *
     * @param newItem The new item to replace the existing one.
     */
    public void replaceItems(final Item newItem) {
        List<Item> replacing = items.stream()
                .filter(item -> !item.getId().equals(newItem.getId()))
                .toList();
        replacing.add(newItem);

        replacing.stream()
                .filter(this::isValid)
                .map(this::calculateWss);

        items = replacing;
    }

    /**
     * Retrieves all items in the database.
     *
     * @return A list of all items.
     */
    public List<Item> getAllItems() {
        return items;
    }

    /**
     * Checks whether the item is valid based on the presence of its set.
     *
     * @param item The item to check.
     * @return True if the item has a valid set, false otherwise.
     */
    private boolean isValid(final Item item) {
        return item.getSet() != null;
    }

    /**
     * Calculates various WSS (Weighted Stats Score) values for an item, including general WSS, reforged WSS, DPS WSS, 
     * support WSS, and combat WSS based on the item's augmented stats and reforged stats (if available).
     *
     * @param item The item to calculate WSS values for.
     * @return The item with its WSS values updated.
     */
    public Item calculateWss(final Item item) {
        AugmentedStats stats = item.getAugmentedStats();
        AugmentedStats reforgedStats = item.getReforgedStats() == null ? stats : item.getReforgedStats();

        final double atkValue = 3.46 / 39;
        final double defValue = 4.99 / 31;
        final double hpValue = 3.09 / 174;

        double wssValue = stats.getAttackPercent() +
                stats.getDefensePercent() +
                stats.getHealthPercent() +
                stats.getEffectResistance() +
                stats.getEffectiveness() +
                stats.getSpeed() * (8.0 / 4.0) +
                stats.getCritDamage() * (8.0 / 7.0) +
                stats.getCritRate() * (8.0 / 5.0) +
                stats.getAttack() * atkValue +
                stats.getDefense() * defValue +
                stats.getHealth() * hpValue;

        double reforgedWssValue = reforgedStats.getAttackPercent() +
                reforgedStats.getDefensePercent() +
                reforgedStats.getHealthPercent() +
                reforgedStats.getEffectResistance() +
                reforgedStats.getEffectiveness() +
                reforgedStats.getSpeed() * (8.0 / 4.0) +
                reforgedStats.getCritDamage() * (8.0 / 7.0) +
                reforgedStats.getCritRate() * (8.0 / 5.0) +
                reforgedStats.getAttack() * atkValue +
                reforgedStats.getDefense() * defValue +
                reforgedStats.getHealth() * hpValue;

        double dpsWssValue = reforgedStats.getAttackPercent() +
                reforgedStats.getSpeed() * (8.0 / 4.0) +
                reforgedStats.getCritDamage() * (8.0 / 7.0) +
                reforgedStats.getCritRate() * (8.0 / 5.0) +
                reforgedStats.getAttack() * atkValue;

        double supportWssValue = reforgedStats.getDefensePercent() +
                reforgedStats.getHealthPercent() +
                reforgedStats.getEffectResistance() +
                reforgedStats.getSpeed() * (8.0 / 4.0) +
                reforgedStats.getDefense() * defValue +
                reforgedStats.getHealth() * hpValue;

        double combatWssValue = reforgedStats.getAttackPercent() +
                reforgedStats.getDefensePercent() +
                reforgedStats.getHealthPercent() +
                reforgedStats.getSpeed() * (8.0 / 4.0) +
                reforgedStats.getCritDamage() * (8.0 / 7.0) +
                reforgedStats.getCritRate() * (8.0 / 5.0) +
                reforgedStats.getAttack() * atkValue +
                reforgedStats.getDefense() * defValue +
                reforgedStats.getHealth() * hpValue;

        item.setWss((int) Math.round(wssValue));
        item.setReforgedWss((int) Math.round(reforgedWssValue));
        item.setDpsWss((int) Math.round(dpsWssValue));
        item.setSupportWss((int) Math.round(supportWssValue));
        item.setCombatWss((int) Math.round(combatWssValue));
        return item;
    }

    /**
     * Retrieves an item by its unique ID.
     *
     * @param id The unique ID of the item.
     * @return The Item corresponding to the ID, or null if not found.
     */
    public Item getItemById(final String id) {
        return items.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves a list of items by their unique IDs.
     *
     * @param ids A list of item IDs to search for.
     * @return A list of items corresponding to the IDs, or an empty list if none are found.
     */
    public List<Item> getItemsById(final List<String> ids) {
        return ids.stream()
                .map(this::getItemById)
                .toList();
    }

    /**
     * Unequips an item by its ID, removing it from the hero's equipment and setting its equipped attributes to null.
     * If a setting is enabled, the item is unlocked upon unequipping.
     *
     * @param id The ID of the item to unequip.
     */
    public void unequipItem(final String id) {
        Item existingItem = getItemById(id);

        if (existingItem == null) {
            return;
        }

        String previousOwnerId = existingItem.getEquippedById();
        Hero hero = heroDb.getHeroById(previousOwnerId);

        if (hero != null) {
            hero.getEquipment().remove(existingItem.getGear());
        }

        existingItem.setEquippedById(null);
        existingItem.setEquippedByName(null);

        if (HeroesRequestHandler.SETTING_UNLOCK_ON_UNEQUIP) {
            existingItem.setLocked(false);
        }
    }

    /**
     * Deletes an item by its ID, removing it from the database and also unequipping it from any hero it was equipped to.
     *
     * @param id The ID of the item to delete.
     */
    public void deleteItem(final String id) {
        Item existingItem = getItemById(id);

        if (existingItem == null) {
            return;
        }

        String heroId = existingItem.getEquippedById();
        Hero hero = heroDb.getHeroById(heroId);

        if (hero != null) {
            hero.getEquipment().remove(existingItem.getGear());
        }

        items.removeIf(item -> item.getId().equals(id));
    }

    /**
     * Equips an item to a hero. If the hero already has an item equipped in the same gear slot, it is unequipped first.
     *
     * @param itemId The ID of the item to equip.
     * @param heroId The ID of the hero to equip the item to.
     */
    public void equipItemOnHero(final String itemId, final String heroId) {
        Item item = getItemById(itemId);
        Hero hero = heroDb.getHeroById(heroId);

        if (item == null || hero == null) {
            return;
        }

        String previousOwner = item.getEquippedById();
        if (previousOwner != null && !previousOwner.equals(heroId)) {
            System.out.println("PREV OWNER" + previousOwner);
            heroDb.getHeroById(previousOwner).getEquipment().remove(item.getGear());
        }

        Item previousItem = hero.switchItem(item);
        if (previousItem != null && !previousItem.getId().equals(item.getId())) {
            System.out.println("PREV ITEM" + previousItem);
            unequipItem(previousItem.getId());
        }

        hero.getEquipment().put(item.getGear(), item);
        item.setEquippedById(heroId);
        item.setEquippedByName(hero.getName());
    }
}
