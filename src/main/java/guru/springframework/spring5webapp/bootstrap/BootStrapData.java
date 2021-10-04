package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        Author mahmoud = new Author("Mahmoud", "Yehia");
        Book myFirst = new Book("My First Book", "1231223");
        mahmoud.getBooks().add(myFirst);
        myFirst.getAuthors().add(mahmoud);
        authorRepository.save(mahmoud);
        bookRepository.save(myFirst);


        Author hana = new Author("Hana", "Mahmoud");
        Book art = new Book("Art", "123456789");
        hana.getBooks().add(art);
        art.getAuthors().add(hana);
        authorRepository.save(hana);
        bookRepository.save(art);


        Publisher noon = new Publisher("Noon","Maadi st", "Cairo", "Cairo", "11231");
        Publisher alef = new Publisher("Alef","Abbas Elaqad st", "Cairo", "Cairo", "11245");

        noon.getBooks().add(art);
        alef.getBooks().add(myFirst);

        art.setPublisher(noon);
        myFirst.setPublisher(alef);


        publisherRepository.save(noon);
        publisherRepository.save(alef);


        System.out.println("testing bootstrap spring");
        System.out.println("Number of current books in database:" + bookRepository.count());
        System.out.println("Number of current publishers in database:" + publisherRepository.count());
        System.out.println("Number of books for each Publisher:");

    }
}
