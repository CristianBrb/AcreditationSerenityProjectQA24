package org.fasttrackit.features;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LoginTest  extends BaseTest {


    @Steps
    private LoginSteps loginSteps;


    @Test
    public void testValidLoginAdmin(){
        loginSteps.login(Constants.ADMIN_EMAIL,Constants.ADMIN_PASSWORD);
        loginSteps.checkLoggedIn("Hello admin (not admin? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test
    public void testValidLoginUser(){
        loginSteps.login(Constants.UserEmail,Constants.UserPassword);
        loginSteps.checkLoggedIn("Hello brbcrs (not brbcrs? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test
    public void logInWithInvalidUsername(){
        loginSteps.login("email@malienator.com","password");
        loginSteps.loginErrorFromInvalidUser("ERROR: Invalid email address. Lost your password?");
    }

    @Test
    public void logInWithValidUsernameWrongPass(){
        loginSteps.login(Constants.UserEmail,"password");
        loginSteps.loginErrorFromInvalidUser("ERROR: The password you entered for the email address brbcrs@malienator.com is incorrect. Lost your password?");
    }

    @Test
    public void logInWithValidUsernameEmptyPassField(){
        loginSteps.login(Constants.UserEmail,"");
        loginSteps.loginErrorFromInvalidUser("ERROR: The password field is empty.");
    }


    @Test
    public void userLogInAndOut(){
        loginSteps.verifyUserGetInAndOut();
    }


    @Test
    public void registerWithAnExistingEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.setRegisterCredentials(Constants.UserEmail,Constants.UserPassword);
        loginSteps.loginErrorFromInvalidUser("Error: An account is already registered with your email address. Please log in.");
    }

    @Test
    public void register(){
        String email= RandomStringUtils.randomAlphabetic(8);
        String domain = "@mailinator.com";
        loginSteps.navigateToLoginPage();
        loginSteps.setRegisterCredentials(email+domain,Constants.UserPassword);
        loginSteps.checkLoggedIn("Hello "+email+" (not "+email+"? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test
    public void forgotPass(){
        loginSteps.forgotYourPass();
    }




}
