package com.example.Inherit.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;




    // Inject AuthorRepository using constructor injection
    public LibraryController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @PostMapping("/books")
    public ResponseEntity<String> saveBooks(@RequestBody List<Book> books) {
        bookRepository.saveAll(books);
        return ResponseEntity.ok("Books data saved");
    }

    @PostMapping("/authors")
    public ResponseEntity<String> saveAuthors(@RequestBody List<Author> authors) {
        authorRepository.saveAll(authors);
        return ResponseEntity.ok("Authors data saved");
    }


    @PostMapping("/submit")
    public ResponseEntity<String> addAuthorToBook(@RequestBody AddAuthorToBookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId()).orElse(null);
        Book book = bookRepository.findById(request.getBookId()).orElse(null);

        if (author != null && book != null) {
            author.getBooks().add(book);
            authorRepository.save(author);
            return ResponseEntity.ok("Author added to book");
        } else {
            return ResponseEntity.badRequest().body("Author or Book not found");
        }
    }
       @GetMapping("/hi")
        public ResponseEntity<List<Book>> getAllBooks() {
            List<Book> allBooks = bookRepository.findAll();
            return ResponseEntity.ok(allBooks);
        }

        @GetMapping("/hello")
        public ResponseEntity<List<Author>> getAllAuthors() {
            List<Author> allAuthors = authorRepository.findAll();
            return ResponseEntity.ok(allAuthors);
        }

    }