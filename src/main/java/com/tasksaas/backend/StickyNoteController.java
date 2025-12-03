package com.tasksaas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sticky")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
public class StickyNoteController {

    @Autowired
    private StickyNoteRepository stickyNoteRepository;

    @GetMapping
    public StickyNote getStickyNote() {
        // For simplicity, we'll just use the first one or create one if empty
        List<StickyNote> notes = stickyNoteRepository.findAll();
        if (notes.isEmpty()) {
            StickyNote note = new StickyNote();
            note.setContent("");
            return stickyNoteRepository.save(note);
        }
        return notes.get(0);
    }

    @PostMapping
    public StickyNote updateStickyNote(@RequestBody StickyNote note) {
        // Always update the first one
        List<StickyNote> notes = stickyNoteRepository.findAll();
        if (notes.isEmpty()) {
            return stickyNoteRepository.save(note);
        }
        StickyNote existing = notes.get(0);
        existing.setContent(note.getContent());
        return stickyNoteRepository.save(existing);
    }
}
