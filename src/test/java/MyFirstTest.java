import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MyFirstTest {
  @BeforeAll
    static void configure() {

        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
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
         $(byText("Sports")).click(); // check sports in hobbies
        $("#currentAddress").setValue("Adress 1");

        $("#react-select-3-input").setValue("NCR");
System.out.println("Простые текстовые поля были протестированы");
    }
    @Test
    void TestCalendar(){

    }
}
