package com.example.wondugallery.service.board;

import com.example.wondugallery.service.board.dto.response.BoardResponseRecord;
import com.example.wondugallery.service.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.service.board
 * @date 2023-10-23
 * @explanation
 */

@DisplayName("게시판 서비스 테스트")
@ExtendWith(MockitoExtension.class)
class BoardServiceTest {


    @InjectMocks private BoardService boardService;

    @Mock private BoardRepository boardRepository;

    @DisplayName("게시판 조회 테스트")
    @Test
    void findAll() {
        // Given
        Pageable pageable = Pageable.ofSize(10);
        given(boardRepository.findAll(pageable)).willReturn(Page.empty());
        // When
        Page<BoardResponseRecord> all = boardService.findAll(pageable);

        // Then
        assertThat(all).isEmpty();
        then(boardRepository).should().findAll(pageable);
    }
}