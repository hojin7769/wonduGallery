package com.example.wondugallery.service.board;

import com.example.wondugallery.service.board.dto.request.BoardRequestRecod;
import com.example.wondugallery.service.board.dto.response.BoardResponseRecord;
import com.example.wondugallery.service.board.entity.Board;
import com.example.wondugallery.service.board.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public Page<BoardResponseRecord> findAll(Pageable pageable){
        return boardRepository.findAll(pageable).map(BoardResponseRecord::from);

    }

    @Transactional
    public BoardResponseRecord save(BoardRequestRecod boardRequest){
        Board save = boardRepository.save(boardRequest.toEntity());
        return BoardResponseRecord.from(save);
    }


}
