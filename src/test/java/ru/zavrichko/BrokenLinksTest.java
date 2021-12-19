package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BrokenLinksTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void ValidLinksTest() {
        // Open website
        open("https://demoqa.com/broken");

        // Find Element and click valid link
        $(byText("Click Here for Valid Link")).click();
       // Assert
      $x("//img[@src='/images/Toolsqa.jpg']").shouldBe(visible);
    }
    @Test
    void NoValidLinksTest() {
        // Open website
        open("https://demoqa.com/broken");

        // Find Element and click broken link
        $(byText("Click Here for Broken Link")).click();

        // Assert
        $("#content").shouldHave(text("This page returned a 500 status code."));
    }

}
