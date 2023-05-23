package com.insurance.restApp.repository;

import com.insurance.restApp.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClaimsRepository extends JpaRepository<Claim, UUID> {
}
