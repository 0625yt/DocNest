// src/main/java/.../domain/document/DocumentDomain.java
package com.example.hwpparsingserver.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "DOCUMENT")
public class DocumentDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스 사용 시 적절히 변경
    @Column(name = "ID")
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

    // --- Getters and Setters ---

}
