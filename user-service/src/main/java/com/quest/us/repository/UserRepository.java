package com.quest.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quest.us.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(Long userId);

}
