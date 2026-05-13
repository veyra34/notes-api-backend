package com.example.Notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes.entity.Notes;
import com.example.Notes.service.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesService notesService;

    @PostMapping("/create/{userId}")
    public String createNote(@RequestBody Notes note, @PathVariable Long userId) {
        return notesService.createNote(note, userId);
    }

    @GetMapping("/all/{userId}")
    public String getAllNote(@PathVariable Long userId) {
        return notesService.getAllNote(userId);
    }
    @GetMapping("/{id}/{userId}")
    public String getNoteById(@PathVariable Long id, @PathVariable Long userId) {
        return notesService.getNoteById(id, userId);
    }
    @PutMapping("/update/{id}/{userId}")
    public String updateNote(@PathVariable Long id, @RequestBody Notes note, @PathVariable Long userId) {
        return notesService.updateNote(id, note, userId);
    }
    @PutMapping("/delete/{id}/{userId}")
    public String deleteNote(@PathVariable Long id, @PathVariable Long userId) {
        return notesService.deleteNote(id, userId);
    }
}
