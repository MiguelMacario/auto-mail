package com.macariomiguel.autoemail.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_email")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private Long id;

    private String email;

    @OneToMany(mappedBy = "email", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmailHistory> histories;

    public Email (String email) {
        this.email = email;
    }

}
