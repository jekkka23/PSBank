package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PageIpoteka;

    @Tag("regression")

class PSBTests extends TestBase {

    PageIpoteka pageIpoteka = new PageIpoteka();

    @Test
        public void ipotekaHouseSuccessTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("30000000")
                    .setCreditPeriodInput("15")
                    .setInitialDepositInput("15000000")
                    .setMotherCapitalCheckboxInput()
                    .setMotherCapitalInput("620000")
                    .setCheckPersonalFundsInput("14 380 000")
                    .setAssuranceCheckboxInput()
                    .setPersonalStuffCheckboxInput()
                    .setPartnersCheckboxInput()
                    .setCheckFavorableInterestRateInput("При выборе нескольких вариантов, применяется самый выгодный %")
                    .setSubmitInput();
    }
    @Test
        public void ipotekaHouseMinimumCostTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("100")
                    .setCheckPropertyCostInput("800 000");
    }
    @Test
        public void ipotekaHouseMinimumTermTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("800000")
                    .setCreditPeriodInput("1")
                    .setInitialDepositInput("300 000")
                    .setCheckCreditPeriodInput("3");
    }
    @Test
        public void ipotekaHouseMinimumDownPaymentTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("800000")
                    .setCreditPeriodInput("3")
                    .setInitialDepositInput("100")
                    .setCheckInitialDepositInput("240 080");
    }
    @Test
        public void ipotekaHouseMaximumCostTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("100000000")
                    .setCheckPropertyCostInput("75 000 000");
    }
    @Test
        public void ipotekaHouseMaximumTermTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("800000")
                    .setCreditPeriodInput("50")
                    .setInitialDepositInput("300 000")
                    .setCheckCreditPeriodInput("30");
    }
    @Test
        public void ipotekaHouseMaximumDownPaymentTest() {
            pageIpoteka.openPage()
                    .setCloseCookieInput()
                    .setCheckHeaderIpotekaInput("Ипотека")
                    .setPropertyTypeInput("Дом")
                    .setPropertyCostInput("800000")
                    .setCreditPeriodInput("3")
                    .setInitialDepositInput("500000")
                    .setCheckInitialDepositInput("300 000");
    }
}
