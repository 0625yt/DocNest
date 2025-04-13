package com.example.hwpparsingserver.domain.folderinfo;

public class FolderInfoDomain {

    private Long userId;           // 사용자 ID
    private String folderName;     // 폴더 이름
    private String description;    // 폴더 설명
    private Boolean isRoot;        // 루트 폴더 여부
    private Boolean isShared;      // 공유 여부
    private Long parentFolderId;   // 부모 폴더 ID (선택적)

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter and Setter for folderName
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for isRoot
    public Boolean getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(Boolean isRoot) {
        this.isRoot = isRoot;
    }

    // Getter and Setter for isShared
    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    // Getter and Setter for parentFolderId
    public Long getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(Long parentFolderId) {
        this.parentFolderId = parentFolderId;
    }
}