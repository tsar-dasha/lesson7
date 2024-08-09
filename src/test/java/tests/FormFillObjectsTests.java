package tests;

import org.junit.jupiter.api.Test;
import pages.FormFill;

public class FormFillObjectsTests extends TestBase {

    FormFill fillForm = new FormFill();

    @Test
    void fillFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName("Dasha")
                .setLastName("Tsareva")
                .setGender("Female")
                .setMobile("8999123456")
                .clickSubmit()
                .checkResults("Student Name", "Dasha Tsareva")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "8999123456");
    }


    @Test
    void fillAllFormTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName("Dasha")
                .setLastName("Tsareva")
                .setEmail("12345@mail.ru")
                .setGender("Female")
                .setMobile("8999123456")
                .setDateOfBirth("09", "July", "2022")
                .setSubject("Maths")
                .setHobby("Music")
                .setPictureUpload("student.jpg")
                .setAddress("City")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkResults("Student Name", "Dasha Tsareva")
                .checkResults("Student Email", "12345@mail.ru")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "8999123456")
                .checkResults("Date of Birth", "09 July,2022")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Music")
                .checkResults("Picture", "student.jpg")
                .checkResults("Address", "City")
                .checkResults("State and City", "NCR Delhi");
    }

    @Test
    void fillFormNegativeTest() {
        fillForm.openPage()
                .removeBanner()
                .setFirstName("Dasha")
                .setLastName("Tsareva")
                .setEmail("12345mail.ru")
                .setGender("Female")
                .clickSubmit()
                .checkNoTable();
    }
}
