package pr_1.Model;

import jakarta.validation.constraints.NotEmpty;

public class Book {
    private int book_id;
    private Integer person_id;
    @NotEmpty(message = "Поле должно быть заполнено")
    private String book_name;
    @NotEmpty(message = "Поле должно быть заполнено")
    private String book_author;
    private int book_year;

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
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

    public Integer getPerson_id() {
        return person_id;
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
}
