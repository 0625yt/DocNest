package com.example.hwpparsingserver.repository.folderinfo;

import com.example.hwpparsingserver.domain.folderinfo.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}