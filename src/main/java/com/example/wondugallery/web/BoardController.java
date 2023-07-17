package com.example.wondugallery.web;

import com.example.wondugallery.response.BasicResponse;
import com.example.wondugallery.service.board.BoardService;
import com.example.wondugallery.service.board.dto.request.BoardRequestRecod;
import com.example.wondugallery.service.board.dto.response.BoardResponseRecord;
import com.example.wondugallery.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<BasicResponse> findAll(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable){

        Page<BoardResponseRecord> all = boardService.findAll(pageable);
        List<BoardResponseRecord> content = all.getContent();

        BasicResponse basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .message("조회성공")
                .result(content)
                .build();


        return new ResponseEntity<>(basicResponse,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BasicResponse> save(@RequestBody(required = false) BoardRequestRecod boardRequest){
        BasicResponse basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .message("저장성공")
                .result(List.of(boardService.save(boardRequest)))
                .build();
        return new ResponseEntity<>(basicResponse,HttpStatus.OK);
    }

}
