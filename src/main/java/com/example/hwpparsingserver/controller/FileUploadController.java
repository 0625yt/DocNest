package com.example.hwpparsingserver.controller;

import com.example.hwpparsingserver.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService; // 정상적으로 주입되어야 합니다.

    @PostMapping("/document")
    public String uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("folder") String folder) {
        return fileUploadService.uploadFile(file, folder);
    }
}