package com.example.wondugallery.service.board.entity;

import com.example.wondugallery.common.auditing.AuditingFields;
import com.example.wondugallery.service.file.entity.FileEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@Entity
@Getter
@Table(name = "PHOTO_BOARD")
public class Board extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_BOARD_SEQ")
    private Long boardSeq;
    @Column(name="PHOTO_BOARD_TITLE")
    private String boardTitle;
    @Column(name="PHOTO_BOARD_CONTENT")
    private String boardContent;
    @ToString.Exclude
    @Column(name="PHOTO_BOARD_FILE_SEQ")
    @OneToMany( mappedBy = "WONDU_FILE", cascade = CascadeType.ALL)
    private final Set<FileEntity> files = new LinkedHashSet<>();


    protected Board() {}

    private Board(Long boardSeq, String boardTitle, String boardContent) {
        this.boardSeq = boardSeq;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    public static Board of(Long boardSeq, String boardTitle, String boardContent) {
        return new Board(boardSeq,boardTitle,boardContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(boardSeq, board.boardSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardSeq);
    }
}
