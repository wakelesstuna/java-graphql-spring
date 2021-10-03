package io.wakelesstuna.springgraphqldemo.resource;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.wakelesstuna.springgraphqldemo.application.AuthorService;
import io.wakelesstuna.springgraphqldemo.application.BookService;
import io.wakelesstuna.springgraphqldemo.domain.Author;
import io.wakelesstuna.springgraphqldemo.domain.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Query implements GraphQLQueryResolver{

    private final BookService bookService;
    private final AuthorService authorService;

    public Query(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    public Book getBookById(Integer id) {
        return bookService.getBookById(id);
    }

}
