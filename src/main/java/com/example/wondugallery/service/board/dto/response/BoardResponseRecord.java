package com.example.wondugallery.service.board.dto.response;

import com.example.wondugallery.service.board.dto.request.BoardRequestRecod;
import com.example.wondugallery.service.board.entity.Board;

import java.io.Serializable;
import java.time.LocalDateTime;

public record BoardResponseRecord(
         Long boardSeq,
         String boardTitle,
         String boardContent,
         LocalDateTime createAt
) implements Serializable {

    public static BoardResponseRecord of(Long boardSeq, String boardTitle, String boardContent, LocalDateTime createAt) {
      return new BoardResponseRecord(boardSeq, boardTitle, boardContent, createAt);
    }

    public static BoardResponseRecord from(Board board){
       return new BoardResponseRecord(
               board.getBoardSeq(),
               board.getBoardTitle(),
               board.getBoardContent(),
               board.getCreatedAt()
       );
    }



    public Board toEntity(){
        return Board.of(boardSeq, boardTitle,boardContent);
    }
}
