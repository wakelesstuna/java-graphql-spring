package io.wakelesstuna.springgraphqldemo.resource;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import io.wakelesstuna.springgraphqldemo.application.BookService;
import io.wakelesstuna.springgraphqldemo.domain.Book;

public class Mutation implements GraphQLMutationResolver {

    private final BookService bookService;

    public Mutation(BookService bookService) {
        this.bookService = bookService;
    }

    public Book createBook(String title, String releaseDate, String authorFirstname, String authorLastname) {
        return bookService.addBook(title, releaseDate, authorFirstname, authorLastname);
    }

}
