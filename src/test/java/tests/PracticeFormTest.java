package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @AfterEach
    void afterEachTest() {
        Selenide.closeWebDriver();
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Biba");
        $("#lastName").setValue("Bibabovich");
        $("#userEmail").setValue("Biba@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89999999999");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("January");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("30")).click();
        $("#userForm #subjectsInput").setValue("History");
        $("#userForm .subjects-auto-complete__menu").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\BSPB\\IdeaProjects\\demoqa-HW\\src\\test\\java\\tests\\resources\\Screenshot_1.png"));



    }
}