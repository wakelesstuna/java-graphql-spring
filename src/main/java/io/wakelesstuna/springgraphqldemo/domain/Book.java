package io.wakelesstuna.springgraphqldemo.domain;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "author_id")
    private Integer authorId;

    @ManyToOne(targetEntity = Author.class)
    private Author author;
}
