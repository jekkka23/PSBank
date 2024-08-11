package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageIpoteka {

    private final SelenideElement closeCookieInput = $x("//*[@data-cookie='btn']"),
                checkHeaderIpotekaInput = $("[data-param=ipoteka]"),
                propertyTypeInput = $(".choices__list.choices__list--dropdown"),
                propertyCostInput = $("#inner-mortgage-simple-property-cost"),
                creditPeriodInput = $("#inner-mortgage-simple-selected-period"),
                initialDepositInput = $("#inner-mortgage-simple-available-money"),
                motherCapitalCheckboxInput = $("[class=checkbox-switch__label][for=inner-mortgage-simple-maternal-fund]"),
                motherCapitalInput = $("#inner-mortgage-simple-maternal-fund-amount"),
                checkPersonalFundsInput = $("#inner-mortgage-simple-maternal-personal-fund"),
                assuranceCheckboxInput = $("[class=checkbox-switch__label][for=inner-mortgage-simple-insurance]"),
                personalStuffCheckboxInput = $("[class=calculator-checkbox__label][for=inner-mortgage-category-1]"),
                partnersCheckboxInput = $("[class=calculator-checkbox__label][for=inner-mortgage-category-2]"),
                checkFavorableInterestRateInput = $(".calculator-inner__info-element.is-active[data-check-max-percent='info-element']"),
                submitInput = $(".btn.calculator-result-inner__btn-send");

    @Step("Открытие страницы ипотеки")
    public PageIpoteka openPage() {
        open("/?tab=ipoteka");
        removeBannersAndFooter();
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        return this;
    }

    @Step("Закрытие куки")
    public PageIpoteka setCloseCookieInput() {
        closeCookieInput.click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        return this;
    }

    @Step("Проверка, что заголовок страницы содержит слово '{value}'")
    public PageIpoteka setCheckHeaderIpotekaInput(String value) {
        checkHeaderIpotekaInput.shouldHave(text(value));
        return this;
    }

    @Step("Выбор типа недвижимости '{value}'")
    public PageIpoteka setPropertyTypeInput(String value) {
        propertyTypeInput.parent().click();
        $(byText(value)).click();
        return this;
    }

    @Step("Установка стоимости недвижимости '{value}'")
    public PageIpoteka setPropertyCostInput(String value) {
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='" + value + "';");
        propertyCostInput.pressEnter();
        return this;
    }

    @Step("Установка срока кредита '{value}'")
    public PageIpoteka setCreditPeriodInput(String value) {
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='" + value + "';");
        creditPeriodInput.pressEnter();
        return this;
    }

    @Step("Установка первоначального депозита '{value}'")
    public PageIpoteka setInitialDepositInput(String value) {
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='" + value + "';");
        initialDepositInput.pressEnter();
        return this;
    }

    @Step("Выбор чекбокса материнского капитала")
    public PageIpoteka setMotherCapitalCheckboxInput() {
        motherCapitalCheckboxInput.click();
        return this;
    }

    @Step("Установка суммы материнского капитала '{value}'")
    public PageIpoteka setMotherCapitalInput(String value) {
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-maternal-fund-amount').value='" + value + "';");
        motherCapitalInput.pressEnter();
        return this;
    }

    @Step("Проверка суммы личных средств '{value}'")
    public PageIpoteka setCheckPersonalFundsInput(String value) {
        checkPersonalFundsInput.shouldHave(value(value));
        Selenide.executeJavaScript("window.scrollBy(0,300);");
        return this;
    }

    @Step("Выбор чекбокса страхования")
    public PageIpoteka setAssuranceCheckboxInput() {
        assuranceCheckboxInput.click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        return this;
    }

    @Step("Выбор чекбокса работников")
    public PageIpoteka setPersonalStuffCheckboxInput() {
        personalStuffCheckboxInput.click();
        return this;
    }

    @Step("Выбор чекбокса партнеров")
    public PageIpoteka setPartnersCheckboxInput() {
        partnersCheckboxInput.click();
        return this;
    }

    @Step("Проверка надписи '{value}' о выгодном проценте")
    public PageIpoteka setCheckFavorableInterestRateInput(String value) {
        checkFavorableInterestRateInput.shouldHave(text(value));
        return this;
    }

    @Step("Нажатие кнопки отправить")
    public PageIpoteka setSubmitInput() {
        Selenide.executeJavaScript("arguments[0].click();", submitInput);
        return this;
    }

    private void removeBannersAndFooter() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }

    @Step("Проверка минимальной/максимальной цены '{value}'")
    public PageIpoteka setCheckPropertyCostInput(String value) {
        propertyCostInput.shouldHave(value(value));
        return this;
    }

    @Step("Проверка минимального/максимального срока ипотеки '{value}'")
    public PageIpoteka setCheckCreditPeriodInput(String value) {
        creditPeriodInput.shouldHave(value(value));
        return this;
    }

    @Step("Проверка минимального/максимального первоначального платежа '{value}'")
    public PageIpoteka setCheckInitialDepositInput(String value) {
        initialDepositInput.shouldHave(value(value));
        return this;
    }
}
