package com.example.wondugallery.service.file.entity;

import com.example.wondugallery.common.auditing.AuditingFields;
import com.example.wondugallery.service.board.entity.Board;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(name = "WONDU_FILE")
@Entity
public class FileEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WONDU_FILE_SEQ")
    private Long fileSeq;

    @Setter @ManyToOne(optional = false) private Board board;

    @Column(name = "WONDU_FILE_NAME")
    private String fileName;

    @Column(name = "WONDU_FILE_PATH")
    private String filePath;

    @Column(name = "WONDU_FILE_TYPE")
    private String fileType;

    @Column(name="WONDU_FILE_URL")
    private String fileUrl;

    protected FileEntity() {}

    private FileEntity( Board board, String fileName, String filePath, String fileType, String fileUrl) {
        this.board = board;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileUrl = fileUrl;
    }


    public static FileEntity of( Board board, String fileName, String filePath, String fileType, String fileUrl) {
        return new FileEntity(board,fileName,filePath,fileType,fileUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntity that = (FileEntity) o;
        return Objects.equals(fileSeq, that.fileSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileSeq);
    }
}
