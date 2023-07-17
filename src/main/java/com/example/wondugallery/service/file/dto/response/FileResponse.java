package com.example.wondugallery.service.file.dto.response;

import com.example.wondugallery.service.board.entity.Board;
import com.example.wondugallery.service.file.entity.FileEntity;

import java.time.LocalDateTime;

public record FileResponse (
        Long fileSeq,
        String fileName,
        String filePath,
        String fileType,
        String fileUrl,
        LocalDateTime createdAt,
        String createBy
) {

    public static FileResponse of(Long fileSeq, String fileName, String filePath, String fileType, String fileUrl, LocalDateTime createdAt, String createBy) {
        return new FileResponse(fileSeq, fileName, filePath, fileType, fileUrl, createdAt, createBy);
    }

    public static FileResponse from (FileEntity fileEntity){
        return new FileResponse(
                fileEntity.getFileSeq(),
                fileEntity.getFileName(),
                fileEntity.getFilePath(),
                fileEntity.getFileType(),
                fileEntity.getFileUrl(),
                fileEntity.getCreatedAt(),
                fileEntity.getCreatedBy()
        );
    }

    public FileEntity toEntitiy(Board entity){
        return FileEntity.of(entity,fileName,filePath,fileType,fileUrl);
    }
}
