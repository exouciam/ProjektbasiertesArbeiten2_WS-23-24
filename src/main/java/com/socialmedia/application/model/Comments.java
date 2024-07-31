package com.socialmedia.application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_Id")
    private UUID id;

    @Column(name = "text")
    private String text;

    @Transient
    private LocalTime creationDate;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;
}
