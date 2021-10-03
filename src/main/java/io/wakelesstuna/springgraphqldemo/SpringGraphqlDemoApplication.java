package io.wakelesstuna.springgraphqldemo;

import io.wakelesstuna.springgraphqldemo.domain.Author;
import io.wakelesstuna.springgraphqldemo.domain.Book;
import io.wakelesstuna.springgraphqldemo.persistance.AuthorRepository;
import io.wakelesstuna.springgraphqldemo.persistance.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringGraphqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphqlDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepo, AuthorRepository authorRepo) {
        return args -> {

            Author author1 = new Author(null, "John", "Tolkien");
            Author author2 = new Author(null, "Robert", "Martin");
            Author author3 = new Author(null, "Jan", "Skansholm");

            Author a1 = authorRepo.save(author1);
            Author a2 = authorRepo.save(author2);
            Author a3 = authorRepo.save(author3);

            log.info("Inserting authors to db");

            Book book1 = new Book(null, "Lord of the Ring, The Fellowship of the Ring", "29-06-1954", a1.getId(), a1);
            Book book2 = new Book(null, "Java for Beginner", "2020-03-29", a2.getId(),a2);
            Book book3 = new Book(null, "Clean code", "2018-07-17", a3.getId(), a3);

            bookRepo.save(book1);
            bookRepo.save(book2);
            bookRepo.save(book3);

            log.info("Inserting books to db");
        };
    }
}
