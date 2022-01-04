package com.example.nplusone.animal.infra;

import com.example.nplusone.animal.domain.Owner;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.example.nplusone.animal.domain.QOwner.owner;

public class OwnerRepositoryImpl implements OwnerRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public OwnerRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Owner> findAllFetchJoin() {
        return queryFactory.selectFrom(owner)
                .innerJoin(owner.cats)
                .fetchJoin()
                .fetch();
    }
}
