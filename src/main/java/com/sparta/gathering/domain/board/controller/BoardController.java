package com.sparta.gathering.domain.board.controller;

import com.sparta.gathering.common.response.ApiResponse;
import com.sparta.gathering.common.response.ApiResponseEnum;
import com.sparta.gathering.domain.board.dto.request.BoardRequestDto;
import com.sparta.gathering.domain.board.entity.Board;
import com.sparta.gathering.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/{gatherId}")
@Tag(name = "Board API", description = "보드 API")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/boards")
    @Operation(tags = {"boards"}, description = "Board 생성")
    public ApiResponse<?> createBoard(
            @PathVariable(name = "gatherId") Long gatherId,
            @RequestBody BoardRequestDto boardRequestDto)
    {
        Board board = boardService.createBoard(gatherId, boardRequestDto);
        return ApiResponse.successWithData(board, ApiResponseEnum.BOARD_CREATED);
    }

    @PutMapping("/boards/{boardsId}")
    @Operation(tags = {"boards"}, description = "Board 수정")
    public ApiResponse<?> updateBoard(
            @PathVariable(name = "gatherId") Long gatherId,
            @PathVariable(name = "boardsId") Long boardsId,
            @RequestBody BoardRequestDto boardRequestDto)
    {
        Board updatedBoard = boardService.updateBoard(gatherId, boardsId, boardRequestDto);
        return ApiResponse.successWithData(updatedBoard, ApiResponseEnum.BOARD_UPDATED);
    }

    @DeleteMapping("/boards/{boardsId}")
    @Operation(tags = {"boards"}, description = "Board 삭제")
    public ApiResponse<?> deleteBoard(
            @PathVariable(name = "gatherId") Long gatherId,
            @PathVariable(name = "boardsId") Long boardsId)
    {
        boardService.deleteBoard(gatherId, boardsId);
        return ApiResponse.successWithoutData(ApiResponseEnum.BOARD_DELETED);
    }

}