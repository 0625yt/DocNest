package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.domain.folderinfo.FolderInfoDomain;
import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.service.folderinfo.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}