package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void RegistrationTest() {
        // Open website
        open("https://demoqa.com/radio-button");

        // Find Element and Set value
        $(".custom-control-label").click();

        //Assert
        $(".mt-3").shouldBe(visible);
        $(".mt-3").shouldHave(text("Yes"));
    }
}
