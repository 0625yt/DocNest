// src/main/java/.../controller/DocumentController.java
package com.example.hwpparsingserver.controller;
import com.example.hwpparsingserver.domain.DocumentDomain;
import com.example.hwpparsingserver.repository.DocumentRepository;
import com.example.hwpparsingserver.service.DocumentService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    private static final String BASE_DIR = "/Users/hong-yuntaeg/dev/temp/uploaded-files";

    public DocumentController(DocumentService documentService, DocumentRepository documentRepository) {
        this.documentService = documentService;
    }

    // 폴더별 업로드
    @PostMapping("/upload")
    public ResponseEntity<DocumentDomain> uploadDocument(
            @RequestParam Long folderId,
            @RequestParam String userId,
            @RequestParam MultipartFile file
    ) throws Exception {
        DocumentDomain saved = documentService.upload(folderId, file, BASE_DIR, userId);
        return ResponseEntity.ok(saved);
    }

    // 폴더별 목록
    @GetMapping
    public List<DocumentDomain> list(@RequestParam Long folderId) {
        return documentService.list(folderId);
    }


    // 단건 다운로드 (id 기반)
    @GetMapping("/download/{docId}")
    public ResponseEntity<Resource> download(@PathVariable Long docId) throws Exception {
        DocumentDomain doc = documentService.getOne(docId);

        // ⚠️ 엔티티 게터 이름 점검: file path/name 필드명이 무엇인지에 맞춰 사용
        // 예) 필드가 filePath/docName 라면 아래 그대로, name/path 라면 getName()/getPath()로 변경
        String filePath = doc.getFilePath();   // ← getPath()일 수도 있음
        String fileName = doc.getDocName();    // ← getName()일 수도 있음

        if (filePath == null || filePath.isBlank()) {
            throw new IllegalStateException("파일 경로가 비어있습니다. id=" + docId);
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalStateException("서버에 파일이 없습니다. id=" + docId + ", path=" + filePath);
        }

        FileSystemResource resource = new FileSystemResource(file);
        String encoded = URLEncoder.encode(fileName != null ? fileName : file.getName(), StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20");

        String contentType = Files.probeContentType(file.toPath());
        if (contentType == null) contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encoded + "\"")
                .contentType(MediaType.parseMediaType(contentType))
                .contentLength(file.length())
                .body(resource);
    }

    // 단건 삭제
    @DeleteMapping("/{docId}")
    public ResponseEntity<Void> delete(@PathVariable Long docId) throws Exception {
        documentService.delete(docId);
        return ResponseEntity.noContent().build();
    }
}
