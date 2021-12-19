package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void TextBoxTest() {
        // Open website
        open("https://demoqa.com/text-box");

        // Find Element and Set value
        $("#userName").setValue("Vim");
        $("#userEmail").setValue("vim@test.com");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("NY");
        $("#submit").click();

        // Assert
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text("Vim"));
        $("#output #email").shouldHave(text("vim@test.com"));
        $("#output #currentAddress").shouldHave(text("Moscow"));
        $("#output #permanentAddress").shouldHave(text("NY"));

    }

}

