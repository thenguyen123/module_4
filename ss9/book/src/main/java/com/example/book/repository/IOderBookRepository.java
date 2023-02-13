package com.example.book.repository;

import com.example.book.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderBookRepository extends JpaRepository<OderBook,Integer> {
}
