package com.example.wondugallery.service.board.repository;

import com.example.wondugallery.config.DBConfig;
import com.example.wondugallery.config.datasource.DataSourceConfig;
import com.example.wondugallery.service.board.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.service.board.repository
 * @date 2023-10-06
 * @explanation
 */
@DisplayName("JPA 연결 테스트")
@Import({BoardRepositoryTest.TestJpaConfig.class})
@DataJpaTest
class BoardRepositoryTest {


    private final BoardRepository boardRepository;


    public BoardRepositoryTest( @Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Board> boards = boardRepository.findAll();

        // Then
        assertThat(boards)
                .isNotNull();
    }

    @EnableJpaAuditing
    @TestConfiguration
    public static class TestJpaConfig {
        @Bean
        public AuditorAware<String> auditorAware() {
            return () -> Optional.of("uno");
        }
    }
}