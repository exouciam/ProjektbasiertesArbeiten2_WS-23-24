package com.socialmedia.application.repository;

import com.socialmedia.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
