package com.aboagye.phonebookdirectory.repository;

import com.aboagye.phonebookdirectory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);
}