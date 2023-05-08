package com.example.wondugallery.service.file.entity;

import com.example.wondugallery.common.auditing.AuditingFields;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "FILE")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_SEQ")
    private Long fileSeq;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name="FILE_PATH")
    private String filePath;



}
