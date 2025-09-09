package pr_1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;

    @NotEmpty(message = "not empty")
    @Column(name = "person_fio")
    private String person_fio;

    @Min(value = 0,message = "min value is 0")
    @Column(name = "person_year")
    private int person_year;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

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

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
