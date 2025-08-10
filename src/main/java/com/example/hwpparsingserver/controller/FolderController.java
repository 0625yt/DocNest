// src/main/java/.../controller/FolderController.java
package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.domain.DocumentDomain;
import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.domain.folderinfo.FolderInfoDomain;
import com.example.hwpparsingserver.service.DocumentService;
import com.example.hwpparsingserver.service.folderinfo.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {

    private final FolderService folderService;
    private final DocumentService documentService;

    public FolderController(FolderService folderService, DocumentService documentService) {
        this.folderService = folderService;
        this.documentService = documentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Folder> createFolder(@RequestBody FolderInfoDomain folderInfo) {
        Folder folder = folderService.createFolder(folderInfo);
        return ResponseEntity.ok(folder);
    }

    @PostMapping("/select")
    public List<Folder> selectFolder(@RequestBody FolderInfoDomain folderInfo) {
        return folderService.selectFolder(folderInfo);
    }

    // 폴더 삭제: 폴더 문서 전체 삭제 후 폴더 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolder(@PathVariable Long id) {
        documentService.deleteAllInFolder(id);
        folderService.deleteById(id); // 단순 id 기반 삭제 메서드 하나 추가 권장
        return ResponseEntity.noContent().build();
    }

}
