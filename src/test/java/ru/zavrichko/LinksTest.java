package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LinksTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void LinksCreatedTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link created
        $("#created").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 201 and status text Created"));
    }

    @Test
    void LinksNoContentTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link no content
        $("#no-content").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 204 and status text No Content"));
    }

    @Test
    void LinksMovedTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link moved
        $("#moved").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 301 and status text Moved Permanently"));
    }

    @Test
    void LinksBadRequestTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link bad request
        $("#bad-request").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 400 and status text Bad Request"));
    }

    @Test
    void LinksUnauthorizedTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link unauthorized
        $("#unauthorized").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 401 and status text Unauthorized"));
    }

    @Test
    void LinksForbiddenTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link forbidden
        $("#forbidden").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 403 and status text Forbidden"));
    }

    @Test
    void LinksNotFoundTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link not found
        $("#invalid-url").click();

        // Assert
        $("#linkResponse").shouldHave(text("Link has responded with staus 404 and status text Not Found"));
    }

    @Test
    void LinksHomeTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link home
        $("#simpleLink").click();
        // switch to new tab
        switchTo().window(1);
        // Assert
        $(".card-body").shouldHave(text("Elements"));
    }

    @Test
    void LinksDynamicTest() {
        // Open website
        open("https://demoqa.com/links");

        // Find Element and link home dynamic
        $("#dynamicLink").click();
        // switch to new tab
        switchTo().window(1);
        // Assert
        $(".card-body").shouldHave(text("Elements"));
    }
}
