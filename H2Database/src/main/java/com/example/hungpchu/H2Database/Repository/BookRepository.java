package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.OneToManyExample.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
