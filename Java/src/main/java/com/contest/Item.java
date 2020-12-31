package com.contest;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public String lastUpdate;

    public String displayDate;

    public Item(String name, int sellIn, int quality,String lastUpdate) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.lastUpdate = lastUpdate;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality+ ", " +this.lastUpdate ;
    }
}
