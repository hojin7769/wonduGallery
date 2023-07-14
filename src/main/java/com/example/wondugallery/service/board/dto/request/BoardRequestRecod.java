package com.example.wondugallery.service.board.dto.request;

import com.example.wondugallery.service.board.entity.Board;

import java.time.LocalDateTime;

public record BoardRequestRecod(
         Long boardSeq,
         String boardTitle,
         String boardContent,
         Long fileSeq,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static BoardRequestRecod of (Long boardSeq, String boardTitle, String boardContent, Long fileSeq, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
       return new BoardRequestRecod(boardSeq, boardTitle, boardContent, fileSeq, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static BoardRequestRecod from(Board board){
        return new BoardRequestRecod(
                board.getBoardSeq(),
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getFileSeq(),
                board.getCreatedAt(),
                board.getCreatedBy(),
                board.getModifiedAt(),
                board.getModifiedBy()
        );
    }
    public Board toEntity(){
        return Board.of(boardSeq, boardContent, boardTitle, fileSeq);
    }
}
