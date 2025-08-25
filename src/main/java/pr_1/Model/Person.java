package pr_1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private int person_id;
    @NotEmpty(message = "not empty")
    private String person_fio;
    @Min(value = 0,message = "min value is 0")
    private int person_year;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setPerson_fio(String person_fio) {
        this.person_fio = person_fio;
    }

    public void setPerson_year(int person_year) {
        this.person_year = person_year;
    }

    public String getPerson_fio() {
        return person_fio;
    }

    public int getPerson_year() {
        return person_year;
    }
}
