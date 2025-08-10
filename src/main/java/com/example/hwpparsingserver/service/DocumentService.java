// src/main/java/.../service/document/DocumentService.java
package com.example.hwpparsingserver.service;

import com.example.hwpparsingserver.domain.DocumentDomain;
import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.repository.DocumentRepository;
import com.example.hwpparsingserver.repository.folderinfo.FolderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final FolderRepository folderRepository;

    public DocumentService(DocumentRepository documentRepository, FolderRepository folderRepository) {
        this.documentRepository = documentRepository;
        this.folderRepository = folderRepository;
    }

    public DocumentDomain upload(Long folderId, MultipartFile file, String baseDir) throws Exception {
        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new IllegalArgumentException("Folder not found: " + folderId));

        File dir = new File(baseDir);
        if (!dir.exists()) dir.mkdirs();

        File saved = new File(dir, file.getOriginalFilename());
        file.transferTo(saved);

        DocumentDomain doc = new DocumentDomain();
        doc.setFolder(folder);
        doc.setName(file.getOriginalFilename());
        doc.setPath(saved.getAbsolutePath());
        doc.setSize(file.getSize());
        return documentRepository.save(doc);
    }

    public List<DocumentDomain> list(Long folderId) {
        return documentRepository.findByFolderId(folderId);
    }

    public void delete(Long docId) throws Exception {
        DocumentDomain d = documentRepository.findById(docId)
                .orElseThrow(() -> new IllegalArgumentException("Document not found: " + docId));
        // 실제 파일 삭제
        try { Files.deleteIfExists(new File(d.getPath()).toPath()); } catch (Exception ignore) {}
        documentRepository.delete(d);
    }

    public void deleteAllInFolder(Long folderId) {
        // 파일 삭제 + 레코드 삭제
        documentRepository.findByFolderId(folderId).forEach(d -> {
            try { Files.deleteIfExists(new File(d.getPath()).toPath()); } catch (Exception ignore) {}
        });
        documentRepository.deleteByFolderId(folderId);
    }
}
