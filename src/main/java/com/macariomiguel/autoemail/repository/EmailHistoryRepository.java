package com.macariomiguel.autoemail.repository;

import com.macariomiguel.autoemail.entity.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailHistoryRepository extends JpaRepository<EmailHistory, Long> {
}
