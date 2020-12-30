package com.contest;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;


/**
 * 测试需求分析：
 * 1. 普通商品销售期和品质每天变化验证；
 * 2. “Aged Brie”的销售期和品质变化验证；
 * 3. “Sulfuras”的销售期和品质变化验证；
 * 4. “Backstage passes”的销售期和品质变化验证；
 * 5. “Quality”的范围验证；
 */
public class GildedRoseTest {
    Item[] items=new Item[5];
    //1.1 普通商品在销售期内，商品销售期和品质每天减1
    @Test
    public void Given_CommonGoods_When_InSellIn_Then_EveryDayLess1() throws ParseException {
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Apple",20,10,"20201201");
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
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(0,item.sellIn);
        Assert.assertEquals(8,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
    //1.3 普通商品品质不会降为负值
    @Test
    public void Given_CommonGoods_When_QualityWillLess0_Then_QualityMoreOrEquals0() throws ParseException {
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Apple",0,1,"20201201");
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(0,item.sellIn);
        Assert.assertEquals(0,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
    //2.1 AgedBrie商品质量每天增加1
    @Test
    public void Given_AgedBrie_When_Quality_Then_EveryDayMore1() throws ParseException {
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Aged Brie",20,10,"20201201");
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(20,item.sellIn);
        Assert.assertEquals(11,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
    //2.2 AgedBrie商品质量不超过50
    @Test
    public void Given_AgedBrie_When_Quality_Then_NoMore50() throws ParseException{
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Aged Brie",0,50,"20201201");
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(0,item.sellIn);
        Assert.assertEquals(50,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
    //3.1 Sulfuras产品质量不会随时间改变
    @Test
    public void Given_Sulfuras_When_DateChange_Then_SellInAndQualitySame() throws ParseException{
        //初始化商品名称，销售期，品质和上架日期
        Item item=new Item("Sulfuras",5,50,"20201201");
        items[0]=item;
        GildedRose gildedRose=new GildedRose(items);
        //设置当前日期为下一天
        MyDate.setCurrentDate("20201202");
        gildedRose.updateQuality();
        Assert.assertEquals(5,item.sellIn);
        Assert.assertEquals(50,item.quality);
        Assert.assertEquals("20201202",item.lastUpdate);
    }
}
