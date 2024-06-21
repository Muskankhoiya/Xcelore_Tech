package com.example.Notes_App.services;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notes_App.repo.NotesRepository;
import com.example.Notes_App.entity.*;

@Service
public class NoteService {
    @Autowired
    private NotesRepository noteRepository;

    // Get all notes for a user
    public List<Notes> getAllNotesByUser(User user) {
        return noteRepository.findByUser(user);
    }

    // Create a new note for a user
    public Notes createNote(User user, Notes note) {
        note.setUser(user);
        return noteRepository.save(note);
    }

    // Delete a note by its ID, if the user has access
    public void deleteNoteById(User user, Integer id) throws AccessDeniedException {
        Optional<Notes> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent() && optionalNote.get().getUser().equals(user)) {
            noteRepository.deleteById(id);
        } else {
            throw new AccessDeniedException("Access denied");
        }
    }
   
    // Get the latest notes for a user
    public List<Notes> getLatestNotesForUser(User user) {
        // Implement logic to fetch the latest notes for the given user
        // You can use the NoteRepository to query the database for the latest notes
        return noteRepository.findTop10ByUserOrderByCreatedDtDesc(user);
    }
}
