package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormFill {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userMobileInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement hobbyChoosing = $("#hobbiesWrapper");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement address = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement tableResults = $(".table-responsive");
    private final SelenideElement checkResults = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    public FormFill openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FormFill removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FormFill setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public FormFill setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public FormFill setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public FormFill setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public FormFill setMobile(String value) {
        userMobileInput.setValue(value);
        return this;
    }

    public FormFill setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormFill setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public FormFill setHobby(String value) {
        hobbyChoosing.$(byText(value)).click();
        return this;
    }

    public FormFill setPictureUpload(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public FormFill setAddress(String value) {
        address.setValue(value);
        return this;
    }

    public FormFill setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public FormFill setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public FormFill clickSubmit() {
        submitButton.click();
        return this;
    }

    public FormFill checkNoTable() {
        tableResults.shouldNotBe(visible);
        return this;
    }

    public FormFill checkResults(String key, String value) {
        checkResults.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
