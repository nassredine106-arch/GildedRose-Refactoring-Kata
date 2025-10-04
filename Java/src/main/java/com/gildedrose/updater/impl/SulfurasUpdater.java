package com.gildedrose.updater.impl;

import com.gildedrose.Item;
import com.gildedrose.updater.AbstractItemUpdater;

/**
 * Handles the update rules for "Sulfuras, Hand of Ragnaros" items.
 * <p>
 * Sulfuras is a **legendary item**:
 * <ul>
 *     <li>It never decreases in quality.</li>
 *     <li>It never has to be sold (sellIn does not change).</li>
 *     <li>Its quality is constant (usually 80).</li>
 * </ul>
 * Therefore, both quality and sellIn remain unchanged during the update.
 */
public class SulfurasUpdater extends AbstractItemUpdater {

    @Override
    public void update(Item item) {
    }

    @Override
    protected void updateQuality(Item item) {}
}
