package com.gildedrose.updater;

import com.gildedrose.Item;

/**
 * Base abstract class defining the template for updating item.
 * <p>
 * Implements the <b>Template Method Pattern</b>:
 * <ul>
 *     <li>Updates the quality of the item.</li>
 *     <li>Decreases the sell-in value.</li>
 *     <li>Applies special rules when the item has expired.</li>
 *     <li>Normalizes quality to stay within allowed bounds (0–50).</li>
 * </ul>
 *
 */
public abstract class AbstractItemUpdater {
    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;

    /**
     * Template method that defines the general algorithm for updating an item.
     * <p>
     * Steps:
     * <ol>
     *     <li>Update quality</li>
     *     <li>Decrease sell-in</li>
     *     <li>Handle expiration if sell-in &lt; 0</li>
     *     <li>Clamp quality within [0, 50]</li>
     * </ol>
     *
     * @param item the item to update
     */
    public void update(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            handleExpired(item);
        }
        normalizeQuality(item);
    }

    private void updateSellIn(Item item) {
        item.sellIn--;
    }

    /**
     * Ensures the item's quality stays between {@link #MIN_QUALITY} and {@link #MAX_QUALITY}.
     *
     * @param item the item whose quality must be normalized
     */
    private void normalizeQuality(Item item) {
        if (item.quality > MAX_QUALITY) item.quality = MAX_QUALITY;
        if (item.quality < MIN_QUALITY) item.quality = MIN_QUALITY;
    }

    /**
     * Updates the item's quality according to its type.
     * Must be implemented by each subclass.
     *
     * @param item the item to update
     */
    protected abstract void updateQuality(Item item);

    /**
     * Optional hook executed when {@code sellIn} drops below zero.
     * Can be overridden by subclasses that have special expiration rules.
     *
     * @param item the item that has expired
     */
    protected void handleExpired(Item item) {}
}
