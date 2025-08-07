package com.example.hwpparsingserver.repository.folderinfo;

import com.example.hwpparsingserver.domain.folderinfo.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hwpparsingserver.domain.UserDomain;
import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByUser(UserDomain user);
}