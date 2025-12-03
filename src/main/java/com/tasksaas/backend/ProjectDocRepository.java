package com.tasksaas.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDocRepository extends JpaRepository<ProjectDoc, String> {
}
