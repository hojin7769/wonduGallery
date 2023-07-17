package com.example.wondugallery.service.file.repository;

import com.example.wondugallery.service.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepositotry extends JpaRepository<FileEntity,Long> {
}
