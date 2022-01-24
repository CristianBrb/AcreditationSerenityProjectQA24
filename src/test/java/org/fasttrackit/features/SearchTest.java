package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchProductSendKeys(){
        searchSteps.searchProdSendKey("bag");
    }

    @Test
    public void checkProductFound(){
        searchSteps.verifyYourProductFound(Constants.SearchResultsfor_productMessage,"Produs inexistent");
    }



}
