package com.example.hwpparsingserver.service.folderinfo;

import com.example.hwpparsingserver.domain.UserDomain;
import com.example.hwpparsingserver.domain.folderinfo.Folder;
import com.example.hwpparsingserver.domain.folderinfo.FolderInfoDomain;
import com.example.hwpparsingserver.repository.folderinfo.FolderRepository;
import com.example.hwpparsingserver.repository.folderinfo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        // userDbId로 사용자 조회
        UserDomain user = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with userId: " + requestDto.getUserId()));

        Folder folder = new Folder();
        folder.setFolderName(requestDto.getFolderName());
        folder.setUser(user);
        folder.setDescription(requestDto.getDescription());
        folder.setIsRoot(requestDto.getIsRoot());
        folder.setIsShared(requestDto.getIsShared());

        if (requestDto.getParentFolderId() != null) {
            Folder parentFolder = folderRepository.findById(requestDto.getParentFolderId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent folder not found"));
            folder.setParentFolder(parentFolder);
        }

        return folderRepository.save(folder);
    }

    @Transactional(readOnly = true)
    public List<Folder> selectFolder(FolderInfoDomain requestDto) {
        // userId (로그인용 ID)로 조회
        UserDomain user = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with userId: " + requestDto.getUserId()));

        return folderRepository.findByUser(user);
    }


    @Transactional
    public ResponseEntity<String> deleteFolder(@RequestBody FolderInfoDomain folderInfo) {
        Long folderId = folderInfo.getFolderId();  // 수정된 폴더 ID로 찾기
        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new IllegalArgumentException("폴더를 찾을 수 없습니다."));

        folderRepository.delete(folder);
        return ResponseEntity.ok("폴더가 삭제되었습니다.");
    }


    public void deleteById(Long id) {
        folderRepository.deleteById(id);
    }
}