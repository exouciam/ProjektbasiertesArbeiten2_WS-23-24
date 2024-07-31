package com.socialmedia.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Messages{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "message_Id")
    private UUID id;
    private Long userId;

    private Long userid2;
}
