package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.enums.EnumItem;
import com.gildedrose.updater.impl.SulfurasUpdater;
import com.gildedrose.updater.AbstractItemUpdater;
import com.gildedrose.updater.impl.AgedBrieUpdater;
import com.gildedrose.updater.impl.BackstagePassUpdater;
import com.gildedrose.updater.impl.ConjuredItemUpdater;
import com.gildedrose.updater.impl.DefaultItemUpdater;

/**
 * Factory creating the right {@link AbstractItemUpdater} for each {@link Item}.
 */
public class ItemUpdaterFactory {

    public static AbstractItemUpdater create(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        EnumItem type = EnumItem.fromName(item.name);

//      * TODO: Enhance with Java 17 "switch expressions" for cleaner and more concise code.
        switch (type) {
            case AGED_BRIE:
                return new AgedBrieUpdater();
            case BACKSTAGE:
                return new BackstagePassUpdater();
            case SULFURAS:
                return new SulfurasUpdater();
            case CONJURED:
                return new ConjuredItemUpdater();
            case DEFAULT:
            default:
                return new DefaultItemUpdater();
        }
    }
}
