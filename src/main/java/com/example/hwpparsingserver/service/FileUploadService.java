package com.example.hwpparsingserver.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file, String folder) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            // 파일 저장 경로 설정
            String uploadDir = "/Users/hong-yuntaeg/dev/temp/" + folder;
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs(); // 폴더가 없으면 생성
            }

            // 파일 저장
            String filePath = uploadDir + "\\" + file.getOriginalFilename();
            File dest = new File(filePath);
            file.transferTo(dest);
            System.out.println(file.getOriginalFilename());
            return "File uploaded successfully: " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
    }
}