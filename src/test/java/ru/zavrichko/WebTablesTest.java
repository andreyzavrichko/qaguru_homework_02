package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTablesTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void WebTablesTest() {
        // Open website
        open("https://demoqa.com/webtables");

        // Find Element and Set value
        $("#addNewRecordButton").click();
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Vimov");
        $("#userEmail").setValue("a.vimov@gmail.com");
        $("#age").setValue("37");
        $("#salary").setValue("5000");
        $("#department").setValue("Account");
        $("#submit").click();


       $(".rt-tbody").shouldHave(text("Alex"));
       $(".rt-tbody").shouldHave(text("Vimov"));
       $(".rt-tbody").shouldHave(text("a.vimov@gmail.com"));
       $(".rt-tbody").shouldHave(text("37"));
       $(".rt-tbody").shouldHave(text("5000"));
       $(".rt-tbody").shouldHave(text("Account"));

    }

    @Test
    void WebTablesFindTest() {
        // Open website
        open("https://demoqa.com/webtables");

        // Find Element and Set value
        $("#searchBox").setValue("Vega");


        // Assert
        $(".rt-tbody").shouldHave(text("Vega"));


    }
}
