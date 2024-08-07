package com.socialmedia.application.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "message")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "message_id")
    private UUID id;

    @Transient
    private LocalTime creationDateTime;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToMany(mappedBy = "messages")
    private Set<Chat> chats = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "username")
    private User fromUser;

    @OneToOne
    private User toUser;
}
