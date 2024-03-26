package com.ayushsingh.ta_candidate.repository;

import com.ayushsingh.ta_candidate.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.adminEmail = ?1")
    Optional<Admin> findByAdminEmail(String username);
}