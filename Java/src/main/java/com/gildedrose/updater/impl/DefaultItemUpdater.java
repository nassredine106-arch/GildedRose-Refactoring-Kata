package com.gildedrose.updater.impl;

import com.gildedrose.Item;
import com.gildedrose.updater.AbstractItemUpdater;

/**
 * Default updater for standard items.
 * <p>
 * Regular items degrade in quality by:
 * <ul>
 *     <li>-1 quality per day before expiration.</li>
 *     <li>-2 quality per day after expiration.</li>
 *     <li>Quality never falls below 0.</li>
 * </ul>
 */
public class DefaultItemUpdater extends AbstractItemUpdater {

    @Override
    protected void updateQuality(Item item) {
        item.quality--;
    }


    @Override
    protected void handleExpired(Item item) {
        item.quality--;
    }
}
