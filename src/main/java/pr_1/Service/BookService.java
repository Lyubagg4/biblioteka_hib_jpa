package pr_1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr_1.Model.Book;
import pr_1.Model.Person;
import pr_1.Repository.BookRepo;
import pr_1.Repository.PersonRepo;

import java.util.List;

@Service
public class BookService{
    private BookRepo bookRepository;
    @Autowired
    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> index(){
        return bookRepository.findAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }
    public Book show(int id){
        return bookRepository.findById(id).orElse(null);
    }
    public void update(int id,Book book){
        bookRepository.save(book);
    }
    public void delete(int id){
        bookRepository.deleteById(id);
    }
    public Person personOfBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book != null ? book.getOwner() : null;
    }
    public void addPerson(int idOfTheBook, int idOfThePerson){

    }
    public void free(int id, Person person){//ЛАЖА
        Book book = bookRepository.findById(id).orElse(null);
        book.setOwner(null);
    }
}
