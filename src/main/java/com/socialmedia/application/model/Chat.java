package com.socialmedia.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chat")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "chat_id")
    private UUID id;

    @Transient
    private LocalTime dateTimeFromLastMessage;

    @ManyToMany(mappedBy = "chats")
    private Set<ChatRoom> chatRooms = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "username1", nullable = false)
    private User user1;

    @OneToOne
    @JoinColumn(name = "username2", nullable = false)
    private User user2;

    @ManyToMany
    @JoinTable(
            name = "chatHasMessages",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> messages = new HashSet<>();




}

