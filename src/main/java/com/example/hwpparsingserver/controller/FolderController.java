package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.domain.folderinfo.FolderInfoDomain;
import com.example.hwpparsingserver.service.folderinfo.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {

    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
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

    // ✅ RESTful DELETE 매핑 추가
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFolder(@PathVariable Long id) {
        folderService.deleteFolderById(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
