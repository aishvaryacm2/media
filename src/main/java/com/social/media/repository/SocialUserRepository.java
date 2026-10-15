package com.social.media.repository;

import com.social.media.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<User, Long> {
}
