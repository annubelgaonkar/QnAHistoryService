package dev.qna.qna_history_service.repository;

import dev.qna.qna_history_service.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByUsername(String username);

}
