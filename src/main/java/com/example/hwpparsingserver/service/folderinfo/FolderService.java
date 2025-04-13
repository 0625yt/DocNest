package com.example.hwpparsingserver.service.folderinfo;

import com.example.hwpparsingserver.domain.UserDomain;
import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.domain.folderinfo.FolderInfoDomain;
import com.example.hwpparsingserver.repository.folderinfo.FolderRepository;
import com.example.hwpparsingserver.repository.folderinfo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

@Service
public class FolderService {
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    public FolderService(FolderRepository folderRepository, UserRepository userRepository) {
        this.folderRepository = folderRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Folder createFolder(FolderInfoDomain requestDto) {
        // userId로 사용자 조회
        UserDomain user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(MessageFormat.format("User not found with ID: {0}", requestDto.getUserId())));

        // Folder 엔터티 생성
        Folder folder = new Folder();
        folder.setFolderName(requestDto.getFolderName());
        folder.setUser(user);
        folder.setDescription(requestDto.getDescription());
        folder.setIsRoot(requestDto.getIsRoot());
        folder.setIsShared(requestDto.getIsShared());

        // parentFolderId가 존재하면 부모 폴더 설정
        if (requestDto.getParentFolderId() != null) {
            Folder parentFolder = folderRepository.findById(requestDto.getParentFolderId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent folder not found with ID: " + requestDto.getParentFolderId()));
            folder.setParentFolder(parentFolder);
        }

        return folderRepository.save(folder);
    }
}