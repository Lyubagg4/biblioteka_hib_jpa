package pr_1.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pr_1.Model.Person;
import pr_1.Service.BookService;
import pr_1.Service.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {
    PersonService personService;
    BookService bookService;

    @Autowired
    public PeopleController(PersonService personService, BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("person",personService.index());
        return "people/index";
    }
    @GetMapping("/new")
    public String create(@ModelAttribute("person") Person person){
        return "people/new";
    }
    @GetMapping("/{id}")
    public String show(Model model,
                       @PathVariable("id") int id){
        model.addAttribute("person",personService.show(id));
        model.addAttribute("books", personService.booksOfPerson(id));
        return "people/show";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("person",personService.show(id));
        return "people/edit";
    }
    @PostMapping()
    public String save(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "people/new";
        }
        personService.save(person);
        return "redirect:/people";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid Person person,
                       BindingResult bindingResult,
                       @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            // Возвращаемся обратно на форму, чтобы показать ошибки
            return "people/edit"; // имя вашего Thymeleaf шаблона с формой
        }
        personService.update(id, person);
        return "redirect:/people";
    }
    @PatchMapping("/{book_id}/free")
    public String free(@ModelAttribute("person") Person person,
                       @PathVariable("book_id") int id){
        bookService.free(id, person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id" )int id){
        personService.delete(id);
        return "redirect:/people";
    }


}
