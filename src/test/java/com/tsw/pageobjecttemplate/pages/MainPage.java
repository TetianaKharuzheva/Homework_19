package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://www.jetbrains.com/
public class MainPage {

    public SelenideElement inputField = $("[data-testid='text-input']");
    public SelenideElement itemCreated = $("[data-testid='todo-item-label']");
    public SelenideElement itemFirstCreated = $(By.xpath("//label[@data-testid='todo-item-label' and contains(text(), '1.Play')]"));
    public SelenideElement itemSecondCreated = $(By.xpath("//label[@data-testid='todo-item-label' and contains(text(), '2.Watch')]"));
    public SelenideElement itemThirdCreated = $(By.xpath("//label[@data-testid='todo-item-label' and contains(text(), '3.Sleep')]"));
    public SelenideElement itemToggle = $("[data-testid='todo-item-toggle']");
    public SelenideElement buttonClearCompleted = $("[class='clear-completed']");
    ;

}
