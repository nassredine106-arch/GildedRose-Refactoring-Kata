package com.gildedrose.updater.impl;

import com.gildedrose.Item;
import com.gildedrose.updater.AbstractItemUpdater;

/**
 * Handles the update rules for "Aged Brie" items.
 * <p>
 * Aged Brie increases in quality over time:
 * <ul>
 *     <li>+1 quality each day before expiration.</li>
 *     <li>+1 additional quality after expiration (total +2 per day).</li>
 *     <li>Quality never exceeds 50.</li>
 * </ul>
 */
public class AgedBrieUpdater extends AbstractItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        item.quality++;
    }

    @Override
    protected void handleExpired(Item item) {
        item.quality++;
    }
}
