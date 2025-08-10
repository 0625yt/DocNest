// src/main/java/.../controller/DocumentController.java
package com.example.hwpparsingserver.controller;
import com.example.hwpparsingserver.domain.DocumentDomain;
import com.example.hwpparsingserver.service.DocumentService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    private static final String BASE_DIR = "C:/Temp/uploaded-files";

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    // 폴더별 업로드
    @PostMapping("/upload")
    public ResponseEntity<DocumentDomain> uploadDocument(
            @RequestParam Long folderId,
            @RequestParam MultipartFile file
    ) throws Exception {
        DocumentDomain saved = documentService.upload(folderId, file, BASE_DIR);
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
        DocumentDomain doc = documentService.list(docId).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("문서가 없습니다. id=" + docId));
        Resource resource = new FileSystemResource(doc.getPath());
        String filename = URLEncoder.encode(doc.getName(), StandardCharsets.UTF_8);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    // 단건 삭제
    @DeleteMapping("/{docId}")
    public ResponseEntity<Void> delete(@PathVariable Long docId) throws Exception {
        documentService.delete(docId);
        return ResponseEntity.noContent().build();
    }
}
