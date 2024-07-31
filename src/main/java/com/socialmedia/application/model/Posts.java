package com.socialmedia.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_Id")
    private UUID id;

    @Transient
    private LocalTime creationDate;

    private String text;

    @Column(name = "pictureUrl")
    private String pictureUrl;

    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Users user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    private Set<Comments> comments;
}
