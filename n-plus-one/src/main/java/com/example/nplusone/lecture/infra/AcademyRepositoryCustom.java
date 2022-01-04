package com.example.nplusone.lecture.infra;

import com.example.nplusone.lecture.domain.Academy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepositoryCustom {
    List<Academy> findAllCustom();
}
