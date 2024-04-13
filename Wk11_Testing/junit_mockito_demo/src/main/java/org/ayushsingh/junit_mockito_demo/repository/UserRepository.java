package org.ayushsingh.junit_mockito_demo.repository;

import org.ayushsingh.junit_mockito_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}