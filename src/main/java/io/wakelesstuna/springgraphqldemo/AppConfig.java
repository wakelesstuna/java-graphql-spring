package io.wakelesstuna.springgraphqldemo;

import io.wakelesstuna.springgraphqldemo.application.AuthorService;
import io.wakelesstuna.springgraphqldemo.application.BookService;
import io.wakelesstuna.springgraphqldemo.persistance.AuthorRepository;
import io.wakelesstuna.springgraphqldemo.persistance.BookRepository;
import io.wakelesstuna.springgraphqldemo.resource.Mutation;
import io.wakelesstuna.springgraphqldemo.resource.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookService bookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        return new BookService(bookRepository,authorRepository);
    }

    @Bean
    public AuthorService authorService(AuthorRepository authorRepository) {
        return new AuthorService(authorRepository);
    }

    @Bean
    public Query query(AuthorService authorService, BookService bookService) {
        return new Query(bookService,authorService);
    }

    @Bean
    public Mutation mutation(BookService bookService) {
        return new Mutation(bookService);
    }
}
