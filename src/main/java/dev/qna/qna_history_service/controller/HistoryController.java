package dev.qna.qna_history_service.controller;

import dev.qna.qna_history_service.dto.HistoryRequestDTO;
import dev.qna.qna_history_service.model.History;
import dev.qna.qna_history_service.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("/save")
    public ResponseEntity<History> saveHistory(@RequestBody HistoryRequestDTO historyRequestDTO) {
        return new ResponseEntity<>(historyService.saveHistory(historyRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<History>> getUserHistory(@PathVariable String username) {
        return ResponseEntity.ok(historyService.getUserHistory(username));
    }

}
