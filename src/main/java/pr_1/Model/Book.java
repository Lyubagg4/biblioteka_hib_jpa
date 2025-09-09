package pr_1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @NotEmpty(message = "Поле должно быть заполнено")
    @Column(name = "book_name")
    private String book_name;

    @NotEmpty(message = "Поле должно быть заполнено")
    @Column(name = "book_author")
    private String book_author;

    @Column(name = "book_year")
    private int book_year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person owner;



    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public void setBook_year(int book_year) {
        this.book_year = book_year;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public int getBook_year() {
        return book_year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
