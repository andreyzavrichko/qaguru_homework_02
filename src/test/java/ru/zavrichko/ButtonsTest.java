package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ButtonsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void ButtonsTestDoubleClick() {
        // Open website
        open("https://demoqa.com/buttons");

        // Find Element and double click
        $("#doubleClickBtn").doubleClick();

        // Assert
        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
    }

    @Test
    void ButtonsTestRightClick() {
        // Open website
        open("https://demoqa.com/buttons");

        // Find Element and right click
        $("#rightClickBtn").contextClick();

        // Assert
        $("#rightClickMessage").shouldHave(text("You have done a right click"));
    }

    @Test
    void ButtonsTestClick() {
        // Open website
        open("https://demoqa.com/buttons");

        // Find Element and click
        $(byText("Click Me")).click();

        // Assert
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }
}
