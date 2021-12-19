package ru.zavrichko;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class UploadTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;


    }
   @Test
    void UploadFileTest() {
        // Open website
        open("https://demoqa.com/upload-download");

        // Find Element and upload file

        File file = new File("src/test/resources/photo.jpg");
        Selenide.$(byId("uploadFile")).uploadFile(file);

        // Assertion
        $("#uploadedFilePath").shouldBe(visible);
    }

}
