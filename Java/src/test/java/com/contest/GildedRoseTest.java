package com.contest;

import org.junit.Test;

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
    public void Given_CommonGoods_When_InSellIn_Then_EveryDayLess1() {

    }
    //1.2 普通商品在销售期外，商品销售期每天减1，品质减2
    @Test
    public void Given_CommonGoods_When_OutSellIn_Then_EveryDaySellInLess1QualityLess2() {

    }
}
