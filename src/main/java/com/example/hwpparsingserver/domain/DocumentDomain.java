// src/main/java/.../domain/document/DocumentDomain.java
package com.example.hwpparsingserver.domain;

import com.example.hwpparsingserver.domain.folderinfo.Folder;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DOCUMENT")
public class DocumentDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 폴더 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLDER_ID", nullable = false)
    private Folder folder;

    @Column(name = "NAME", nullable = false)
    private String name;

    // 실제 파일 절대경로 or 상대경로
    @Column(name = "PATH", nullable = false)
    private String path;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "UPLOADED_AT")
    private LocalDateTime uploadedAt = LocalDateTime.now();

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    // getter/setter ...
}
