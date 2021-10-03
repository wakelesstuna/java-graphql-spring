package io.wakelesstuna.springgraphqldemo.application;

import com.coxautodev.graphql.tools.GraphQLResolver;
import io.wakelesstuna.springgraphqldemo.domain.Author;
import io.wakelesstuna.springgraphqldemo.domain.Book;
import io.wakelesstuna.springgraphqldemo.persistance.AuthorRepository;
import io.wakelesstuna.springgraphqldemo.persistance.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
public class BookService implements GraphQLResolver<Author> {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public BookService(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public Book getBookById(Integer bookId) {
        return bookRepo.findById(bookId).get();
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book addBook(String title, String releaseDate, String authorFirstname, String authorLastname) {
        Optional<Author> authorOpt = authorRepo.findByFirstnameAndLastname(authorFirstname, authorLastname);

        Author author;
        if (authorOpt.isEmpty()){
            author = authorRepo.save(new Author(null, authorFirstname, authorLastname));
            log.info("insert new author with id:{} into database", author.getId());
        }else {
            author = authorOpt.get();
        }

        Book newBook = bookRepo.save(new Book(null,title,releaseDate,author.getId(),author));
        log.info("insert new book with id:{} into database", newBook.getId());
        return newBook;
    }
}
