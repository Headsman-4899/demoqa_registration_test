package com.demoqa.pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObjectActions {
    private final static String TITLE_TEXT = "Student Registration Form";
    private final static String TITLE_TEXT_SUBMITTED = "Thanks for submitting the form";
    PageObjectPaths pop = new PageObjectPaths();

    @Step("Student registration form")
    public void registrationPage() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(pop.firstName).setValue("Alex");
        $(pop.lastName).setValue("Egorov");
        $(pop.email).setValue("alex@egorov.com");
        $(pop.gender).$(byText("Male")).click(); // best
        $(pop.mobileNumber).setValue("1234567890");
        $(pop.dateOfBirth).click();
        $(pop.month).selectOption("July");
        $(pop.year).selectOption("2008");
        $(pop.day).click();
        $(pop.subjects).setValue("Math").pressEnter();
        $(pop.hobbies).$(byText("Sports")).click();
        $(pop.picture).uploadFromClasspath("img/ds2.jpg");
        $(pop.currentAddress).setValue("Some address 1");
        $(pop.state).click();
        $(pop.stateCity).$(byText("NCR")).click();
        $(pop.city).click();
        $(pop.stateCity).$(byText("Delhi")).click();
        $(pop.submit).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT_SUBMITTED));
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
    }

    @Step("Student registration form with minimum data set")
    public void registrationPageWithMinimumDataTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $(pop.firstName).setValue("Mihail");
        $(pop.lastName).setValue("Petrov");
        $(pop.gender).$(byText("Male")).click();
        $(pop.mobileNumber).setValue("1234567890");
        $(pop.submit).click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT_SUBMITTED));

        $(".table-responsive table").shouldHave(text("Mihail"), text("Petrov"), text("1234567890"));
    }
}
