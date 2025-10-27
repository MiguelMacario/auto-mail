package com.macariomiguel.autoemail.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "message")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name ="message_text")
    private String text;

    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Message(String text, Integer version, Type type) {
        this.text = text;
        this.version = version;
        this.type = type;
    }

    @Override
    public String toString(){
        return "Message: " + text;
    }
}
