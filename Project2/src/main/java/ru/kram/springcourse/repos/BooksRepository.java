package ru.kram.springcourse.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kram.springcourse.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String title);
}
