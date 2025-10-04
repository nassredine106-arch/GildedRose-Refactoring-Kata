package com.gildedrose.updater.impl;

import com.gildedrose.Item;
import com.gildedrose.updater.AbstractItemUpdater;

/**
 * Handles the update rules for "Backstage passes to a TAFKAL80ETC concert".
 * <p>
 * Behavior:
 * <ul>
 *     <li>+1 quality when {@code sellIn > 10}</li>
 *     <li>+2 quality when {@code 6 <= sellIn <= 10}</li>
 *     <li>+3 quality when {@code 1 <= sellIn <= 5}</li>
 *     <li>Quality drops to 0 after the concert ({@code sellIn <= 0}).</li>
 *     <li>Quality never exceeds 50.</li>
 * </ul>
 */
public class BackstagePassUpdater extends AbstractItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        if (item.sellIn < 6) {
            item.quality += 3;
        } else if (item.sellIn < 11) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
    }

    @Override
    protected void handleExpired(Item item) {
        item.quality = 0;
    }
}
