package com.example.nplusone.lecture.infra;

import com.example.nplusone.lecture.domain.Academy;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.example.nplusone.lecture.domain.QAcademy.academy;


public class AcademyRepositoryImpl implements AcademyRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public AcademyRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Academy> findAllCustom() {
        return jpaQueryFactory.selectFrom(academy)
                .from(academy)
                .leftJoin(academy.subjects)
                .fetchJoin()
                .fetch();
    }
}
