package com.demoqa.tests;

import com.demoqa.pages.PageObjectActions;
import org.junit.jupiter.api.Test;

public class RegistrationPageTest extends TestBase {
    PageObjectActions poa = new PageObjectActions();

    @Test
    public void registration() {
        poa.registrationPage();
    }

    @Test
    public void registrationPageWithMinimumData() {
        poa.registrationPageWithMinimumDataTest();
    }
}
