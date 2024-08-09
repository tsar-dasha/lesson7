package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        int dayNumber = Integer.parseInt(day);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        if (dayNumber < 10) {
            $(".react-datepicker__day--0" + day).click();
        }
        else {
            $(".react-datepicker__day--" + day).click();
        }
    }
}
