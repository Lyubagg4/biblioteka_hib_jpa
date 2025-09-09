package pr_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr_1.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}
