package pr_1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pr_1.Model.Book;
import pr_1.Model.Person;
import pr_1.Repository.BookRepo;
import pr_1.Repository.PersonRepo;

import java.util.Collections;
import java.util.List;

@Service
public class PersonService {
    private PersonRepo personRepository;

    public PersonService(PersonRepo personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> index(){
        return personRepository.findAll();
    }
    public void save(Person person){
        personRepository.save(person);
    }
    public Person show(int id){
        return personRepository.findById(id).orElse(null);
    }
    public void update(int id, Person person){//ЛАЖА
        personRepository.save(person);
    }
    public void delete(int id){
        personRepository.deleteById(id);
    }
    public List<Book> booksOfPerson(int id){
        Person person = personRepository.findById(id).orElse(null);
        if(person!=null) return person.getBooks();
        else return Collections.emptyList();
    }
}
