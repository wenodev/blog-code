package com.example.nplusone.animal.infra;

import com.example.nplusone.animal.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
