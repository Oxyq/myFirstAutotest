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
        $(byText("Male")).click(); // выбор пола

        $("#userNumber").setValue("9999999999");


System.out.println("Простые текстовые поля были протестированы");
    }
    @Test
    void TestCalendar(){

    }
}
