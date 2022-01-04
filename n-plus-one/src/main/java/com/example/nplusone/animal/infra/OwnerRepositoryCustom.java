package com.example.nplusone.animal.infra;

import com.example.nplusone.animal.domain.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepositoryCustom {
    List<Owner> findAllFetchJoin();
}
