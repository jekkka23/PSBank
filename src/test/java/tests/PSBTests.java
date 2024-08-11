package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PSBTests extends TestBase {


    @Test
    void ipotekaHouseSuccessTest() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='30000000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //Установка значения с помощью JavaScript срок кредита
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='15';");
        $("#inner-mortgage-simple-selected-period").pressEnter();

        //Установка значения с помощью JavaScript первоначальный взнос
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='15000000';");
        $("#inner-mortgage-simple-available-money").pressEnter();

        //чекбокс материнский капитал
        $("[class=checkbox-switch__label][for=inner-mortgage-simple-maternal-fund]").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");

        //материнский капитал сумма
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-maternal-fund-amount').value='620000';");
        $("#inner-mortgage-simple-maternal-fund-amount").pressEnter();

        //проверка верно посчитанной суммы личных средств
        $("#inner-mortgage-simple-maternal-personal-fund").shouldHave(value("14 380 000"));
        Selenide.executeJavaScript("window.scrollBy(0,300);");

        //чекбокс страхование выкл
        $("[class=checkbox-switch__label][for=inner-mortgage-simple-insurance]").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");

        //чекбокс работники
        $("[class=calculator-checkbox__label][for=inner-mortgage-category-1]").click();

        //чекбокс партнеры
        $("[class=calculator-checkbox__label][for=inner-mortgage-category-2]").click();

        //проверка, что появилась надпись "При выборе нескольких вариантов,"
        $(".calculator-inner__info-element.is-active[data-check-max-percent='info-element']").shouldHave(text("При выборе нескольких вариантов, применяется самый выгодный %"));
        Selenide.sleep(1000);
        Selenide.executeJavaScript("window.scrollBy(0,-500);");

        //нажатие кнопки отправить
        Selenide.executeJavaScript("arguments[0].click();", $(".btn.calculator-result-inner__btn-send"));

    }

    @Test
    void ipotekaHouseMinimumCostTest() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='100';");
        $("#inner-mortgage-simple-property-cost").pressEnter();
        Selenide.sleep(1000);

        //проверка, что минимальная цена установилась автоматически
        $("#inner-mortgage-simple-property-cost").shouldHave(value("800 000"));
    }

    @Test
    void ipotekaHouseMinimumTermTest() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        //проверка видимости текста
        $(withText("Вторичное жилье")).should(Condition.exist);

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='800000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //Установка значения с помощью JavaScript срок кредита
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='1';");
        $("#inner-mortgage-simple-selected-period").pressEnter();

        //первоначальный депозит
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='300000';");
        $("#inner-mortgage-simple-available-money").pressEnter();

        //проверка, что минимальный срок установился автоматически
        Selenide.sleep(1000);
        $("#inner-mortgage-simple-selected-period").shouldHave(value("3"));
    }

    @Test
    void ipotekaHouseMinimumDownPayment() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        //проверка видимости текста
        $(withText("Вторичное жилье")).should(Condition.exist);

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='800000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //Установка значения с помощью JavaScript срок кредита
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='3';");
        $("#inner-mortgage-simple-selected-period").pressEnter();

        //Установка значения с помощью JavaScript первоначальный взнос
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='100';");
        $("#inner-mortgage-simple-available-money").pressEnter();

        //проверка, что минимальный срок установился автоматически
        $("#inner-mortgage-simple-available-money").shouldHave(value("240 080"));
    }

    @Test
    void ipotekaHouseMaximumCostTest() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        //проверка видимости текста
        $(withText("Вторичное жилье")).should(Condition.exist);

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='100000000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //проверка, что максимальная цена установилась автоматически
        Selenide.sleep(1000);
        $("#inner-mortgage-simple-property-cost").shouldHave(value("75 000 000"));
    }

    @Test
    void ipotekaHouseMaximumTermTest() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        //проверка видимости текста
        $(withText("Вторичное жилье")).should(Condition.exist);

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='800000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //Установка значения с помощью JavaScript срок кредита
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='50';");
        $("#inner-mortgage-simple-selected-period").pressEnter();

        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='300000';");
        $("#inner-mortgage-simple-available-money").pressEnter();

        //проверка, что максимальный срок установился автоматически
        Selenide.sleep(1000);
        $("#inner-mortgage-simple-selected-period").shouldHave(value("30"));
    }
    @Test
    void ipotekaHouseMaximumDownPayment() {

        open("/?tab=ipoteka");
        Selenide.executeJavaScript("window.scrollBy(0,500);");
        // Проверка, что заголовок страницы содержит слово "Ипотека"
        $("[data-param=ipoteka]").shouldHave(text("Ипотека"));
        //закрытие куки и прокрутка до элемента
        $x("//*[@data-cookie='btn']").click();
        Selenide.executeJavaScript("window.scrollBy(0,200);");
        //проверка видимости текста
        $(withText("Вторичное жилье")).should(Condition.exist);

        //тип недвижимости
        $(".choices__list.choices__list--dropdown").parent().click();
        $(byText("Дом")).click();

        // Установка значения с помощью JavaScript стоимость недвижимости
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-property-cost').value='800000';");
        $("#inner-mortgage-simple-property-cost").pressEnter();

        //Установка значения с помощью JavaScript срок кредита
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-selected-period').value='3';");
        $("#inner-mortgage-simple-selected-period").pressEnter();

        //Установка значения с помощью JavaScript первоначальный взнос
        Selenide.executeJavaScript("document.getElementById('inner-mortgage-simple-available-money').value='500000';");
        $("#inner-mortgage-simple-available-money").pressEnter();

        //проверка, что минимальный срок установился автоматически
        $("#inner-mortgage-simple-available-money").shouldHave(value("300 000"));
    }

}
