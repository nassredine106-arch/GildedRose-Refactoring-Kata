package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{ new Item("foo", 0, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items[0].name);
    }

    /**
     * Aged Brie item quality is never more than 50
     */
    @Test
    void agedBrieQualityShouldNotBeMoreThan50() {
        Item item = new Item("Aged Brie", 8, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(50, item.quality);
        assertEquals("Aged Brie", item.name);
        assertEquals(7, item.sellIn);
    }

    /**
     * Item sellIn is negative and item is Aged Brie and quality less than 50
     */
    @Test
    void itemSellInIsNegativeAndIsAgedBrieQualityIncreases() {
        Item item = new Item("Aged Brie", -3, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(22, item.quality); // increases by 2 because sellIn < 0
    }

    /**
     * Sulfuras is a legendary item; sellIn does not change
     */
    @Test
    void sulfurasSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals("Sulfuras, Hand of Ragnaros", item.name);
    }

    /**
     * Sulfuras quality never decreases
     */
    @Test
    void sulfurasQualityNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(80, item.quality);
    }

    /**
     * Backstage quality increases by 2 when there are 10 days or less
     */
    @Test
    void backstageQualityIncreasesBy2Within10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(32, item.quality);
        assertEquals(7, item.sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
    }

    /**
     * Backstage quality increases by 3 when there are 5 days or less
     */
    @Test
    void backstageQualityIncreasesBy3Within5Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(5, item.quality); // 2 + 3
        assertEquals(4, item.sellIn);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name);
    }

    /**
     * Backstage item quality is 0 after concert
     */
    @Test
    void backstageQualityDropsTo0AfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(0, item.quality);
    }

}
