package com.example.hungpchu.H2Database.Repository;

import com.example.hungpchu.H2Database.OneToManyExample.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
