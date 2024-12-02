package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforAllsetup(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @AfterEach
    void afterEachTest() {
        Selenide.closeWebDriver();
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Biba");
        $("#lastName").setValue("Bibabovich");
        $("#userEmail").setValue("Biba@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999999999");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("January");

        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("30")).click();
        $("#userForm #subjectsInput").setValue("History");
        $("#userForm .subjects-auto-complete__menu").click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("Screenshot_1.png");

        $("#currentAddress").setValue("Biba, Bobowck");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name")).shouldHave(text("Biba, Bobowck"));
        $(".table-responsive").shouldHave(text("Student Email")).shouldHave(text("Biba@gmail.com"));
        $(".table-responsive").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("Mobile")).shouldHave(text("8999999999"));
        $(".table-responsive").shouldHave(text("Date of Birth")).shouldHave(text("30 January,1994"));
        $(".table-responsive").shouldHave(text("Subjects")).shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Hobbies")).shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("Picture")).shouldHave(text("Screenshot_1.png"));
        $(".table-responsive").shouldHave(text("Address")).shouldHave(text("Biba, Bobowck"));
        $(".table-responsive").shouldHave(text("State and City")).shouldHave(text("NCR Gurgaon"));

    }
}