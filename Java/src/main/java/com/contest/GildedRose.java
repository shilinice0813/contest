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
            if(item.name.equals("Aged Brie")&&MyDate.plusDay(1,item.lastUpdate).equals(MyDate.getCurrentDate())){
                item.quality=item.quality<=49?item.quality+1:50;
                item.lastUpdate=MyDate.getCurrentDate();
            }else if(item.name.equals("Sulfuras")){
                item.lastUpdate=MyDate.getCurrentDate();
                continue;
            }else if(item.name.equals("Backstage passes")&&MyDate.plusDay(1,item.lastUpdate).equals(MyDate.getCurrentDate())){
                int during=Integer.parseInt(MyDate.plusDay(10,MyDate.getCurrentDate()))-Integer.parseInt(item.displayDate);
                //离开演超过10天
                if(during<0){
                    item.quality=item.quality<=49?item.quality+1:50;
                }else if(during>=0&&during<5){  //10-5
                    item.quality=item.quality<=49?item.quality+2:50;
                }else if(during>=5&&during<=10){  //5-0
                    item.quality=item.quality<=49?item.quality+3:50;
                }else{
                    item.quality=0;
                }
                item.lastUpdate=MyDate.getCurrentDate();
            }else if(MyDate.plusDay(1,item.lastUpdate).equals(MyDate.getCurrentDate())){
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