package com.tsw.pageobjecttemplate.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tsw.pageobjecttemplate.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/");
    }

    @Test
    public void createNewToDoActionAndItIsShownOnTheList() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("1.Play");
        mainPage.inputField.pressEnter();
        mainPage.itemCreated.shouldBe(visible);
        Selenide.sleep(2000);
    }

    @Test
    public void createMultipleToDoActionsAndTheyAreShownOnTheList() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("1.Play");
        mainPage.inputField.pressEnter();
        mainPage.itemFirstCreated.shouldBe(visible);
        mainPage.inputField.setValue("2.Watch");
        mainPage.inputField.pressEnter();
        mainPage.itemSecondCreated.shouldBe(visible);
        mainPage.inputField.setValue("3.For a walk");
        mainPage.inputField.pressEnter();
        mainPage.itemThirdCreated.shouldBe(visible);
        Selenide.sleep(2000);
    }

    @Test
    public void UserIsAbleToMarkTheActionAsCompleted() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("1.Play");
        mainPage.inputField.pressEnter();
        mainPage.itemToggle.click();
        mainPage.itemToggle.isSelected();
        Selenide.sleep(2000);
    }

    @Test
    public void UserIsAbleToClickCleanCompleted() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("1.Play");
        mainPage.inputField.pressEnter();
        mainPage.itemToggle.click();
        mainPage.buttonClearCompleted.click();
        mainPage.itemCreated.shouldNot(visible);
        Selenide.sleep(5000);
    }
}
