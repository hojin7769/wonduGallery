package com.example.wondugallery.service.board.entity;

import com.example.wondugallery.common.auditing.AuditingFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Entity
@Getter
@Builder
@NoArgsConstructor
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
    @Column(name="PHOTO_BOARD_FILE_SEQ")
    private Long fileSeq;

    public Board(Long boardSeq, String boardTitle, String boardContent, Long fileSeq) {
        super();
        this.boardSeq = boardSeq;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.fileSeq = fileSeq;
    }

    public static Board of (Long boardSeq, String boardTitle, String boardContent, Long fileSeq) {
        return new Board(boardSeq,boardTitle,boardContent,fileSeq);
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
