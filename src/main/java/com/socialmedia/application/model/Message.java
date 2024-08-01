package com.socialmedia.application.model;

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
    private User fromUsername;

    @ManyToOne
    @JoinColumn(name = "username")
    private User toFriendUsername;

}
