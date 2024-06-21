package com.example.Notes_App.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes_App.entity.User;
import com.example.Notes_App.repo.NotesRepository;
import com.example.Notes_App.repo.UserRepository;
import com.example.Notes_App.services.NoteService;
import com.example.Notes_App.entity.*;

@RestController
@RequestMapping("/user/notes") // Base path for the controller
public class NoteController {

    @Autowired
    private NotesRepository noteRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NoteService noteService;

    @CrossOrigin("*")
    @GetMapping("/latest")
    public ResponseEntity<List<Notes>> getLatestNotes(Principal principal) {
        // Get the authenticated user based on the Principal
        User user = getUserByEmail(principal.getName());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        
        // Retrieve the latest notes for the user
        List<Notes> latestNotes = noteService.getLatestNotesForUser(user);
        return ResponseEntity.ok(latestNotes);
    }

    @CrossOrigin("*")
    @PostMapping("/createNote") // Endpoint to create a new note
    public Notes createNote(Principal principal, @RequestBody Notes note) {
        // Get the authenticated user based on the Principal
        User user = getUserByEmail(principal.getName());
        note.setUser(user);
        // Save the new note in the repository
        return noteRepository.save(note);
    }

    @CrossOrigin("*")
    @DeleteMapping("/delete/{id}") // Endpoint to delete a note by ID
    public ResponseEntity<?> deleteNote(Principal principal, @PathVariable Integer id) {
        // Get the authenticated user based on the Principal
        User user = getUserByEmail(principal.getName());
        Optional<Notes> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent() && optionalNote.get().getUser().equals(user)) {
            // Check if the note belongs to the authenticated user, and delete it if so
            noteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            // Return a forbidden status if the user doesn't have access to the note
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }

    // Custom method to get a user by email
    private User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
