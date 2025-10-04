package com.gildedrose.updater.impl;

import com.gildedrose.Item;
import com.gildedrose.updater.AbstractItemUpdater;

/**
 * Handles the update rules for "Conjured" items.
 * <p>
 * Conjured items degrade in quality twice as fast as normal items:
 * <ul>
 *     <li>-2 quality per day before expiration.</li>
 *     <li>-4 quality per day after expiration.</li>
 *     <li>Quality never falls below 0.</li>
 * </ul>
 */
public class ConjuredItemUpdater extends AbstractItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        item.quality -= 2;
    }

    @Override
    protected void handleExpired(Item item) {
        item.quality -= 2;
    }
}
