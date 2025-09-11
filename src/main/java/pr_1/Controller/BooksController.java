package pr_1.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pr_1.Model.Book;
import pr_1.Model.Person;
import pr_1.Service.BookService;
import pr_1.Service.PersonService;

@Controller
@RequestMapping("/books")
public class BooksController {
    PersonService personService;
    BookService bookService;

    @Autowired
    public BooksController(PersonService personService, BookService bookService) {
        this.personService = personService;
        this.bookService = bookService;
    }
    @GetMapping()
    public String index(Model model,
                        @RequestParam (name = "page", required = false) Integer page,
                        @RequestParam (name = "book_per_page",required = false) Integer book_per_page,
                        @RequestParam(name = "sort_by_year", required = false) Boolean bool){
        if(page==null || book_per_page==null){
            if(bool!=null && bool){
                model.addAttribute("books", bookService.indexWithSort());
            }else{
                model.addAttribute("books", bookService.index());
            }
        }else{
            if(bool!=null && bool){
                model.addAttribute("books", bookService.indexWithPageWithSort(page, book_per_page));
            }else{
                model.addAttribute("books", bookService.indexWithPage(page, book_per_page));
            }
        }
        return "books/index";
    }
    @GetMapping("/search")
    public String search(){
        return "books/search";
    }
    @GetMapping("/new")
    public String create(@ModelAttribute("book") Book book){
        return "books/new";
    }
    @GetMapping("/{id}")
    public String show(Model model,
                       @PathVariable("id") int id){
        model.addAttribute("book", bookService.show(id));
        model.addAttribute("person", bookService.personOfBook(id));
        model.addAttribute("people",personService.index());
        return "books/show";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("book", bookService.show(id));
        return "books/edit";
    }
    @PostMapping("/search")
    public String found(Model model, @RequestParam("bookName") String bookName){
        model.addAttribute("books",bookService.find(bookName));
        return "books/found";
    }
    @PostMapping()
    public String save(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "books/new";
        }
        bookService.save(book);
        return "redirect:/books";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult,
                       @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "books/edit";
        }
        bookService.update(id, book);
        return "redirect:/books";
    }
    @PatchMapping("/{id}/addPerson")
    public String addPerson(@RequestParam("person_id") int person_id,
                       @PathVariable("id") int idOfTheBook){
        bookService.addPerson(idOfTheBook, person_id);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id" )int id){
        bookService.delete(id);
        return "redirect:/books";
    }
}
