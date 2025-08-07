package com.example.hwpparsingserver.domain.folderinfo;

public class FolderInfoDomain {

    private String userId;       // 로그인용 ID (yt030625 등)
    private Long userDbId;       // DB용 ID (Long)

    private Long folderId;       // 폴더 ID (DB의 폴더 고유 ID)
    private String folderName;
    private String description;
    private Boolean isRoot;
    private Boolean isShared;
    private Long parentFolderId; // 부모 폴더 ID

    // Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Long getUserDbId() { return userDbId; }
    public void setUserDbId(Long userDbId) { this.userDbId = userDbId; }

    public Long getFolderId() { return folderId; }  // 추가된 폴더 ID
    public void setFolderId(Long folderId) { this.folderId = folderId; }

    public String getFolderName() { return folderName; }
    public void setFolderName(String folderName) { this.folderName = folderName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getIsRoot() { return isRoot; }
    public void setIsRoot(Boolean isRoot) { this.isRoot = isRoot; }

    public Boolean getIsShared() { return isShared; }
    public void setIsShared(Boolean isShared) { this.isShared = isShared; }

    public Long getParentFolderId() { return parentFolderId; }
    public void setParentFolderId(Long parentFolderId) { this.parentFolderId = parentFolderId; }
}
