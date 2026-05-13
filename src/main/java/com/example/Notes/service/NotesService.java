package com.example.Notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notes.entity.Notes;
import com.example.Notes.entity.User;
import com.example.Notes.repository.NotesRepository;
import com.example.Notes.repository.UserRepository;

@Service
public class NotesService {
    @Autowired
    NotesRepository notesRepository;

    @Autowired
    UserRepository userRepository;

    public String createNote(Notes note, Long userId) {
        Optional<User> existingUser=(Optional<User>) userRepository.findById(userId);
        if(existingUser.isPresent()){
            User user=existingUser.get();
            note.setUser(user);
            notesRepository.save(note);
            return "Note created successfully";
        }
        else{
            return "User not found";
        }
    }
    public String getAllNote(Long userId) {
        Optional<User> existingUser=(Optional<User>) userRepository.findById(userId);
        if(existingUser.isPresent()){
            List<Notes> notes = notesRepository.findByUserId(userId);
            return notes.toString();
        }
        else{
            return "User not found";
        }
    }
    public String getNoteById(Long id, Long userId){
        Optional<User> existingUser=(Optional<User>) userRepository.findById(userId);
        if(existingUser.isPresent()){
            Optional<Notes> note = notesRepository.findById(id);
            if(note.isPresent()){
                return note.get().toString();
            }
            else{
                return "Note not found";
            }
        }
        else{
            return "User not found";
        }
    }
    public String updateNote(Long id, Notes note, Long userId){
        Optional<User> existingUser=(Optional<User>) userRepository.findById(userId);
        if(existingUser.isPresent()){
            Optional<Notes> existingNote= notesRepository.findById(id);
            if(existingNote.isPresent()){
                Notes noteToUpdate=existingNote.get();
                noteToUpdate.setTitle(note.getTitle());
                noteToUpdate.setContent(note.getContent());
                notesRepository.save(noteToUpdate);
                return "Note updated successfully";
            }
            else{
                return "Note not found";
            }
        }
        else{
            return "User not found";
        }
    }
    public String deleteNote(Long id, Long userId){
        Optional<User> existingUser=(Optional<User>) userRepository.findById(userId);
        if(existingUser.isPresent()){
            Optional<Notes> existingNote=notesRepository.findById(id);
            if(existingNote.isPresent()){
                notesRepository.deleteById(id);
                return "Note deleted successfully";
            }
            else{
                return "Note not found";
            }
        }
        else{
            return "User not found";
        }
    }

}
