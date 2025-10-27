package com.macariomiguel.autoemail.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "type_message")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    private String type;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EmailHistory> emailHistories;


    public Type(String type) {
        this.type = type;
    }

}
