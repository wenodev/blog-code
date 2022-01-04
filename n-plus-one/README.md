# N+1 문제

**n+1 문제란?**  
연관된 엔티티를 조회할 때 엔티티 정보를 한번에 가져오는게 아니라 조회하는 만큼 select쿼리가 발생해 데이터베이스에 부하를 가해 성능을 저하시키는 문제이다.

**해결 방법**
1. @Query 어노테이션을 사용해서 fetchJoin을 작성 (inner join)
2. @EntityGraph를 사용해서 쿼리 수행 시 불러올 필드명을 정하는 방법 (outer join)
3. FetchMode.SUBSELECT
4. BatchSize 설정

1,2번은 카테시안 곱 문제가 발생하는 문제가 있는데, 이는 distinct나 Set을 사용해서 해결할 수 있다.   
3번은 좋지만 쿼리가 두번 발생되고, Entity 영역에 어노테이션이 하나 추가된다.   
4번은 In을 활용하는 방법인데, 근본적인 해결이라기 보단 우회하는 느낌이며 설정한 갯수 만큼은 어쨌든 쿼리가 발생한다.   
결과적으로는 QueryDsl 사용하는게 좋다.   
JOIN을 작성하면 한번의 쿼리에 데이터를 가져올 수 있기 때문이다.

예시)   
```java
@Override
public List<Owner> findAllFetchJoin() {
    return queryFactory.selectFrom(product)
            .innerJoin(product.images)
            .fetchJoin()
            .fetch();
}
```

참고1  : [https://jojoldu.tistory.com/165](https://jojoldu.tistory.com/165)

참고2 : [https://incheol-jung.gitbook.io/docs/q-and-a/spring/n+1](https://incheol-jung.gitbook.io/docs/q-and-a/spring/n+1)

참고3: [https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/](https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/)