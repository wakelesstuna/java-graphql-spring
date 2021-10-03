const bookList = document.getElementById("books");

const renderBooks = (listOfBooks) => {
    listOfBooks.forEach(book => {
        const booksListItem = document.createElement('li');
        const title = document.createElement('h3');
        const author = document.createElement('h4');
        const releaseDate = document.createElement('p');
        title.textContent = "Title: " + book.title;
        author.textContent = "Author: " + book.author.firstname + ' ' + book.author.lastname;
        releaseDate.textContent = "Release Date: " + book.release_date;
        booksListItem.appendChild(title);
        booksListItem.appendChild(author);
        booksListItem.appendChild(releaseDate);
        bookList.appendChild(booksListItem);
    });

}

const fetchBooks = () => {
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            'Accept': 'application/json',
        },
        body: JSON.stringify({
            query: "{" +
                "getAllBooks{" +
                    "title " +
                    "release_date: releaseDate " +
                    "author{" +
                        "firstname " +
                        "lastname" +
                        "}" +
                    "}" +
                "}"
        })
    };

    fetch(`http://localhost:8080/graphql`, options)
        .then(res => res.json())
        .then(resp => {
            console.log(resp)
            renderBooks(resp.data.getAllBooks)
        });
}

fetchBooks();