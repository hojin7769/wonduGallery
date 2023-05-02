package com.example.wondugallery.service.file.dao;

import com.example.wondugallery.service.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Long> {
}
