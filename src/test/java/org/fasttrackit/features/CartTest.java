package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.ProductSteps;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Steps
    private CartSteps cartSteps;
    @Steps
    private ProductSteps shopSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test
    public void checkIfCartEmpty(){
        cartSteps.verifyCartEmpty();
    }


    @Test
    public void emptyTheCart(){
        shopSteps.addProductsToCart();
        cartSteps.clickCartBtn();
        cartSteps.removeProductsFromCart();

    }


    @Test
    public void checkProductsAreInCartAfterLogin(){
        shopSteps.addProductsToCart();
        loginSteps.navigateToLoginPage();
        loginSteps.setCredentials(Constants.UserEmail,Constants.UserPassword);
        loginSteps.clickLogin();
        cartSteps.verifyCartNotEmpty();
    }


    @Test
    public void checkProductsPriceIsRight(){
        cartSteps.calculateProductsPrice();


    }

}
