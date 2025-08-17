// src/main/java/.../domain/document/DocumentDomain.java
package com.example.hwpparsingserver.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DOCUMENT")
public class DocumentDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 사용 시 적절히 변경
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FOLDER_ID", nullable = false)
    private Long folderId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "DOC_NAME")
    private String docName;

    @Column(name = "FILE_PATH")
    private String filePath;

    @Column(name = "DOC_TYPE")
    private String docType;

    @Column(name = "DOC_SIZE")
    private Long docSize;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "UPLOADED_AT")
    private LocalDateTime uploadedAt;

    public Long getId() {
        return id;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Long getDocSize() {
        return docSize;
    }

    public void setDocSize(Long docSize) {
        this.docSize = docSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
