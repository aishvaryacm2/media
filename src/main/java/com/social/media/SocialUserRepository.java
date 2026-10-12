package com.social.media;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<User, Long> {
}
