package com.example.hungpchu.H2Database;

import com.example.hungpchu.H2Database.ManyToMany.Student;
import com.example.hungpchu.H2Database.ManyToMany.Teacher;
import com.example.hungpchu.H2Database.OneToManyExample.Model.Author;
import com.example.hungpchu.H2Database.OneToManyExample.Model.Book;
import com.example.hungpchu.H2Database.OneToOneExample.Model.Address;
import com.example.hungpchu.H2Database.OneToOneExample.Model.Person;
import com.example.hungpchu.H2Database.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class H2DatabaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseApplication.class, args);
	}

	// use final for autowired
	private final AddressRepository addressRepository;
	private final PersonRepository personRepository;
	// oneToMany
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	// ManyToMany
	private final StudentRepository studentRepository;
	private final TeacherRepository teacherRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception
	{
		/**
		 * OneToOne example
		 */
		Person person = Person.builder().name("hung").build();

		personRepository.save(person);

		Address address = Address.builder().city("hanoi").province("hoang mai").person(person).build();

		addressRepository.save(address);


		/**
		 * OneToMany or ManyToOne example
		 */

		Author author = new Author();
		author.setName("hung");

		Book book = new Book();
		book.setTitle("Dep trai thi moi co nhieu ng iu");
		book.setAuthor(author);

		author.setBooks(Collections.singleton(book));

		authorRepository.saveAndFlush(author);

		bookRepository.findAll().forEach(b -> {
			System.out.println(b.getId());
			System.out.println(b.getTitle());
			System.out.println(b.getAuthor());
		});

		/**
		 * ManyToMany
		 */

		Teacher John = Teacher.builder().name("John").build();

		Teacher Tom = Teacher.builder().name("Tom").build();

		Student Hung = Student.builder().name("Hung").build();

		Student Han = Student.builder().name("Han").build();

		Hung.setTeachers(List.of(John,Tom));
		Han.setTeachers(List.of(Tom));

		studentRepository.saveAndFlush(Hung);
		studentRepository.saveAndFlush(Han);

		// 5 get from the database
		Student queryResult = studentRepository.findById(5).get();

		System.out.println(queryResult.getName());
		System.out.println(queryResult.getTeachers());
	}

}
