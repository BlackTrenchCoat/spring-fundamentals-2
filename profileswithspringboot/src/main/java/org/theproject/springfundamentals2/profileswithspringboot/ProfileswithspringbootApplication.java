package org.theproject.springfundamentals2.profileswithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class ProfileswithspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileswithspringbootApplication.class, args);
	}

	@Component
	public class CountMoves implements CommandLineRunner {

		@Autowired
		BookRepository bookRepository;

		public void run(String... args) {
			List<Book> books = bookRepository.findAll();
			System.out.println("There are " +  books.size() + " books");
		}

	}

}
