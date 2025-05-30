package dev.qna.qna_history_service.service;

import dev.qna.qna_history_service.dto.HistoryRequestDTO;
import dev.qna.qna_history_service.dto.HistoryResponseDTO;
import dev.qna.qna_history_service.model.History;
import dev.qna.qna_history_service.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }
    public History saveHistory(HistoryRequestDTO historyRequestDTO) {
        History history = new History();
        history.setUserAnswer(historyRequestDTO.getUsername());
        history.setTopic(historyRequestDTO.getTopic());
        history.setQuestion(historyRequestDTO.getQuestion());
        history.setUserAnswer(historyRequestDTO.getUserAnswer());
        history.setCorrectAnswer(historyRequestDTO.getCorrectAnswer());
        history.setCorrect(historyRequestDTO.isCorrect());
        history.setTimestamp(LocalDateTime.now());

        return historyRepository.save(history);
    }

    public List<History> getUserHistory(String username) {
        return historyRepository.findByUsername(username);
    }
}
