### Java and GraphQL project with Spring Boot

Requirements

```
Maven
Docker 
```

To run the application: 
1. Clone or download the project

2. First run the docker command <br> ``docker run --name GraphQL-db -e POSTGRES_USER=root -e POSTGRES_PASSWORD=letmein -e POSTGRES_DB=graphql-db -p 6000:5432 -d postgres`` <br> to 
   set up the postgres database for the project.
   
3. Then start the Spring Boot project ``mvn spring-boot:run``

4. Then open ``http://localhost:8080/graphiql`` in the browser to get GraphQl UI


Inside the UI you can test the api with:


Fetching all books
```graphql
query{
   getAllBooks{
      id
      title
      releaseDate
      authorId
      author{
        id
        firstname
        lastname
    }
  }
}
```

Creating a book
```graphql
mutation{
  createBook(title:"Head First Java",releaseDate:"2019-03-21",authorFirstname:"Foo",authorLastname:"Demo"){
    title
  }
}

```
