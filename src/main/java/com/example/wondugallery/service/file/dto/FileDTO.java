package com.example.wondugallery.service.file.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
    private Long fileSeq;
    private String fileName;
    private String filePath;
}
