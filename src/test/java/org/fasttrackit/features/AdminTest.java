package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminSteps;
import org.junit.Test;

public class AdminTest extends BaseTest {

    @Steps
    private AdminSteps adminSteps;


    @Test
    public void createANewProduct(){
        adminSteps.createNewProduct(adminSteps.getProduct());
        adminSteps.verifyProductWasCreeated();
    }


    @Test
    public void changeTitleAndPrice(){
        adminSteps.editProduct("New Product nM");
     adminSteps.modifyTitleAndPriceQuickEdit("product nM",60);
     adminSteps.searchProduct("New Product nM");
    }


    @Test
    public void quickEditProduct(){
        adminSteps.editProduct("product nM");
        adminSteps.editProdVerify();
    }


    @Test
    public void deleteProduct(){
        adminSteps.deleteProduct();
        adminSteps.verifiProdWasDeleted();
    }


}
