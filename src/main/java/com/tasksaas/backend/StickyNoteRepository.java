package com.tasksaas.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickyNoteRepository extends JpaRepository<StickyNote, Long> {
}
