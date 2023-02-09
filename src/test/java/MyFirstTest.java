import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v109.css.model.Value;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyFirstTest {
  @BeforeAll
    static void configure() {

        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
      Configuration.holdBrowserOpen = true;
    }
    @Test
            void TestFormer() {
        open("/automation-practice-form"); // open page for test
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // Check opened page

        executeJavaScript("$('footer').remove()"); //del footer
        executeJavaScript("$('#fixedban').remove()"); //del banners

        $("#firstName").setValue("name");
        $("#lastName").setValue("last");
        $("#userEmail").setValue("email@email.com");
        // $(byText("Male")).click(); // выбор пола
        $x("//label[@for='gender-radio-1']").click(); // выбор пола xpath
        $("#userNumber").setValue("77777777777");
        //set dateOfBirth 10 Nov 1986
        $("#dateOfBirthInput").click();
        $("select[class='react-datepicker__year-select']").$("option[value='1986']").click(); // install 1986 y
        $("select[class='react-datepicker__month-select']").$("option[value='10']").click(); // install nov
        $x("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]").click(); // install 10
        $("#subjectsInput").setValue("Maths").pressEnter();



         $(byText("Sports")).click(); // check sports in hobbies
        $("#currentAddress").setValue("Adress 1");


        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $(byText("Submit")).click();

System.out.println("Простые текстовые поля были протестированы");

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("name last"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("email@email.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7777777777"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 November,1986"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Adress 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));

        System.out.println("Проверка таблицы окончена все ок");
$("#closeLargeModal").click();

  }
}
