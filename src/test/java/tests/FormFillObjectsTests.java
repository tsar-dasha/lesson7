package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.FormFill;

public class FormFillObjectsTests extends TestBase {

    FormFill fillForm = new FormFill();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phoneNumber = faker.numerify("##########");
    String userEmail = faker.internet().emailAddress();
    String currentAddress = faker.address().city();


    @Test
    void fillFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender("Female")
                .setMobile(phoneNumber)
                .clickSubmit()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Gender", "Female")
                .checkResults("Mobile", phoneNumber);
    }


    @Test
    void fillAllFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Female")
                .setMobile(phoneNumber)
                .setDateOfBirth("09", "July", "2022")
                .setSubject("Maths")
                .setHobby("Music")
                .setPictureUpload("student.jpg")
                .setAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", "Female")
                .checkResults("Mobile", phoneNumber)
                .checkResults("Date of Birth", "09 July,2022")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Music")
                .checkResults("Picture", "student.jpg")
                .checkResults("Address", currentAddress)
                .checkResults("State and City", "NCR Delhi");
    }

    @Test
    void fillFormNegativeTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Female")
                .clickSubmit()
                .checkNoTable();
    }
}