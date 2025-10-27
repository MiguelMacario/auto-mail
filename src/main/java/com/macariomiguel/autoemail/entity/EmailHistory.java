package com.macariomiguel.autoemail.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_history_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_id", nullable = false)
    private Email email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @Column(name = "sent_date")
    private LocalDateTime date = LocalDateTime.now();

    public EmailHistory(Email email, Message message, Type type) {
        this.email = email;
        this.message = message;
        this.type = type;
    }


}
