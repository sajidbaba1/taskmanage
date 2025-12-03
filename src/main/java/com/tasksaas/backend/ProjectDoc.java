package com.tasksaas.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "project_docs")
public class ProjectDoc {

    @Id
    private String id; // Using String ID to match frontend UUID generation or we can switch to Long

    private String title;

    @Column(length = 5000)
    private String content;

    private Long updatedAt;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
