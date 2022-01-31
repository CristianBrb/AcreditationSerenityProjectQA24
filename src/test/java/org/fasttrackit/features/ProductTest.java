package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.ProductSteps;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Steps
    private ProductSteps shopSteps;


    @Test
    public void selectFilterByPrice() {
        shopSteps.dropDownSortByPrice("price");
    }

    @Test
    public void selectFilterByPopularity() {
        shopSteps.dropDownSortByPopularity("popularity");
    }

    @Test
    public void addProductsToCart() {
        shopSteps.addProductsToCart();
    }

    @Test
    public void add2ProductsToCart() {
        shopSteps.add2ProductsToCart();
    }



    @Test
    public void verifyPriceDescending() {
        shopSteps.dropDownSortByPriceDescending();
    }
}



