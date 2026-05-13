package com.example.Notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Notes.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByUserId(Long userId);

}
