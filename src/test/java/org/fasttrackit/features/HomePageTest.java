package org.fasttrackit.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.HomePageSteps;
import org.fasttrackit.steps.LoginSteps;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    @Steps
    private HomePageSteps homePageSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test
    public void verifyLogoIsPresent(){
        homePageSteps.checkLogoIsDisplayed();
    }

    @Test
    public void verifyLoginAndRegisterBtnArePresent(){
        homePageSteps.checkRegisterAndLoginBtnAreDisplayed();
    }



}
