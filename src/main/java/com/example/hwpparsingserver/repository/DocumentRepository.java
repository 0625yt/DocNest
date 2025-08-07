package com.example.hwpparsingserver.repository;

import com.example.hwpparsingserver.domain.DocumentDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentDomain, Long> {
    DocumentDomain findByFolderId(String folderId);
}