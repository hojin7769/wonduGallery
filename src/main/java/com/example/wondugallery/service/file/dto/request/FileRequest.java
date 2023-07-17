package com.example.wondugallery.service.file.dto.request;

import com.example.wondugallery.service.board.entity.Board;
import com.example.wondugallery.service.file.entity.FileEntity;

import java.time.LocalDateTime;

public record FileRequest(
        Long fileSeq,
        String fileName,
        String filePath,
        String fileType,
        String fileUrl,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static FileRequest of(Long fileSeq, String fileName, String filePath, String fileType, String fileUrl, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
     return new FileRequest(fileSeq, fileName, filePath, fileType, fileUrl, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static FileRequest from (FileEntity fileEntity){

        return new FileRequest(
                fileEntity.getFileSeq(),
                fileEntity.getFileName(),
                fileEntity.getFilePath(),
                fileEntity.getFileType(),
                fileEntity.getFileUrl(),
                fileEntity.getCreatedAt(),
                fileEntity.getCreatedBy(),
                fileEntity.getModifiedAt(),
                fileEntity.getModifiedBy()
        );
    }

    public FileEntity toEntitiy(Board entity){
        return FileEntity.of(entity,fileName,filePath,fileType,fileUrl);
    }
}
