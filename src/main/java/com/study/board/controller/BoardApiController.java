package com.study.board.controller;

import com.study.board.dto.BoardRequestDTO;
import com.study.board.dto.BoardResponseDTO;
import com.study.board.model.BoardService;
import com.study.exception.CustomException;
import com.study.exception.ErrorCode;
import com.study.paging.CommonParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 게시글 생성
     */
    @PostMapping("/boards")
    public Long save(@RequestBody final BoardRequestDTO params) {
        return boardService.save(params);
    }

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/boards")
    public Map<String, Object> findAll(final CommonParams params) {
        return boardService.findAll(params);
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/boards/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final BoardRequestDTO params) {
        return boardService.update(id, params);
    }
    /**
     * 게시글 삭제
     */
    @DeleteMapping("/boards/{id}")
    public Long delete(@PathVariable final Long id) {
        return boardService.delete(id);
    }
    /**
     * 게시글 상세정보 조회
     */
    @GetMapping("/boards/{id}")
    public BoardResponseDTO findById(@PathVariable final Long id) {
        return boardService.findById(id);
    }

}
