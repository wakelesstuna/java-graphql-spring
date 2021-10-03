package io.wakelesstuna.springgraphqldemo.application;

import com.coxautodev.graphql.tools.GraphQLResolver;
import io.wakelesstuna.springgraphqldemo.domain.Author;
import io.wakelesstuna.springgraphqldemo.domain.Book;
import io.wakelesstuna.springgraphqldemo.persistance.AuthorRepository;

import java.util.List;

public class AuthorService implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepo;

    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getAuthor(Author author) {
        return authorRepo.findById(author.getId()).get();
    }

}
