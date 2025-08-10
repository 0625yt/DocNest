// src/main/java/.../repository/document/DocumentRepository.java
package com.example.hwpparsingserver.repository;

import com.example.hwpparsingserver.domain.DocumentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentDomain, Long> {
    List<DocumentDomain> findByFolderId(Long folderId);
    void deleteByFolderId(Long folderId);
}
