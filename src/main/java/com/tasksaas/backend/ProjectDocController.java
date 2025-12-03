package com.tasksaas.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
public class ProjectDocController {

    @Autowired
    private ProjectDocRepository docRepository;

    @GetMapping
    public List<ProjectDoc> getAllDocs() {
        return docRepository.findAll();
    }

    @PostMapping
    public ProjectDoc createDoc(@RequestBody ProjectDoc doc) {
        if (doc.getUpdatedAt() == null) {
            doc.setUpdatedAt(System.currentTimeMillis());
        }
        return docRepository.save(doc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDoc> updateDoc(@PathVariable String id, @RequestBody ProjectDoc docDetails) {
        return docRepository.findById(id)
                .map(doc -> {
                    doc.setTitle(docDetails.getTitle());
                    doc.setContent(docDetails.getContent());
                    doc.setUpdatedAt(System.currentTimeMillis());
                    return ResponseEntity.ok(docRepository.save(doc));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoc(@PathVariable String id) {
        return docRepository.findById(id)
                .map(doc -> {
                    docRepository.delete(doc);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
