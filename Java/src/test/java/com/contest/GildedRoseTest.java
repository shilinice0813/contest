package com.contest;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * 测试需求分析：
 * 1. 普通商品销售期和品质每天变化验证；
 * 2. “Aged Brie”的销售期和品质变化验证；
 * 3. “Sulfuras”的销售期和品质变化验证；
 * 4. “Backstage passes”的销售期和品质变化验证；
 * 5. “Quality”的范围验证；
 */
public class GildedRoseTest {
    //1.1 普通商品在销售期内，商品销售期和品质每天减1
    @Test
    public void Given_CommonGoods_When_InSellIn_Then_EveryDayLess1() throws ParseException {
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Apple",20,10,"20201201");
        Item[] items=new Item[5];
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(19,item.sellIn);
        Assert.assertEquals(9,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
    //1.2 普通商品在销售期外，商品销售期每天减1，品质减2
    @Test
    public void Given_CommonGoods_When_OutSellIn_Then_EveryDaySellInLess1QualityLess2() throws ParseException{
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Apple",0,10,"20201201");
        Item[] items=new Item[5];
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(0,item.sellIn);
        Assert.assertEquals(8,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
}
