package com.contest;

import java.text.ParseException;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() throws ParseException {
        for (Item item:items ) {
            if (null==item){
                continue;
            }
            if(MyDate.plusDay(1,item.lastUpdate).equals(MyDate.getCurrentDate())){
                if(item.sellIn>0){
                    item.sellIn--;
                    item.quality = item.quality>=1?item.quality-1:0;
                }else{
                    item.quality = item.quality>=2?item.quality-2:0;
                }
                item.lastUpdate=MyDate.getCurrentDate();
            }
        }
    }
}