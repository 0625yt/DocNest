package com.example.hwpparsingserver.service;

import com.example.hwpparsingserver.domain.DocumentDomain;
import com.example.hwpparsingserver.repository.DocumentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void saveDocument(MultipartFile file, String folderId, String fileName,
                             long fileSize, String fileType, String userId) throws IOException {
        // 1. 파일 저장
        String uploadDir = "/Users/hong-yuntaeg/개발/uploaded-files/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fullPath = uploadDir + fileName;
        File uploadedFile = new File(fullPath);
        file.transferTo(uploadedFile);

        // 2. DB 저장
        DocumentDomain document = new DocumentDomain();
        document.setFileName(fileName);
        document.setFilePath(fullPath);
        document.setFileSize(fileSize);
        document.setFileType(fileType);
        document.setFolderId(folderId);
        document.setUserId(userId);

        documentRepository.save(document);
    }

    public File getDocument(String folderId) {

        String filePath = documentRepository.findByFolderId(folderId).getFilePath();
        File file = new File(filePath);
        System.out.println("file = " + file );
        System.out.println("filePath = " + filePath);
        System.out.println("folderId = " + folderId);

        return file;
    }
}
