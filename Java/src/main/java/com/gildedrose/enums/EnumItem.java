package com.gildedrose.enums;

public enum EnumItem {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT("Default");

    private final String pattern;

    EnumItem(String pattern) {
        this.pattern = pattern;
    }

    public static EnumItem fromName(String name) {
        if (name == null) return DEFAULT;
        for (EnumItem type : values()) {
            if (name.equals(type.pattern)) {
                return type;
            }
        }
        return DEFAULT;
    }
}
