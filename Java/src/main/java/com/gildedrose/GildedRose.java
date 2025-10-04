package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;
import com.gildedrose.updater.AbstractItemUpdater;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AbstractItemUpdater updater = ItemUpdaterFactory.create(item);
            updater.update(item);
        }
    }
}
