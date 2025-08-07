package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PolarisProxyController {

    private final DocumentService documentService;

    public PolarisProxyController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload/document")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("folderId") String folderId,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileSize") long fileSize,
            @RequestParam("fileType") String fileType,
            @RequestParam("userId") String userId
    ) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }

        try {
            documentService.saveDocument(file, folderId, fileName, fileSize, fileType, userId);
            return ResponseEntity.ok("File uploaded and saved.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/download/document")
    public ResponseEntity<File> downloadFile(@RequestParam("folderId") String folderId) {
        File document = documentService.getDocument(folderId);
        if (document != null && document.exists()) {
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
