package org.ayushsingh.junit_mockito_demo.repository;

import org.ayushsingh.junit_mockito_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for managing user entities in the database.
 * This interface extends JpaRepository provided by Spring Data JPA,
 * which provides various methods for CRUD operations on the User entity.
 *
 * @author Ayush Singh
 * @since 2024-04-12
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
}