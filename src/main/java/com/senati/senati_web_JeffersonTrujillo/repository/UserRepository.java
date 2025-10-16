package com.senati.senati_web_JeffersonTrujillo.repository;

import com.senati.senati_web_JeffersonTrujillo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
