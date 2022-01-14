# Spring 생태계의 Graphql 의존성 정리

Spring 진영에서 GraqphQL 관련 의존성은 3가지가 있다.

1. com.graphql-java
2. com.graphql-java-kickstart
3. spring-boot-starter-graphql

첫번째 의존성의 경우 **[Andreas Marek](https://github.com/andimarek)** 란 사람이 개인적으로 진행한 프로젝트이고, 스프링에서 계획이 나오기 전부터 작업한 것으로 보입니다.

하지만 스프링 진영에서 GraqphQL 공식 지원을 준비함에따라 사람들이 혼동을 하기 시작했습니다.

그래서 **[Andreas Marek](https://github.com/andimarek)** 은 혼동을 줄이기 위해 com.graphql-java-kickstart를 만들게 되었습니다.

[블로그](https://www.graphql-java.com/blog/moving-projects/)에서 자세한 내용을 확인할 수 있습니다.

스프링에서 공식적으로 지원해주는 세번째 의존성은 현재 공식 릴리즈를 준비중입니다. [[공식문서]](https://docs.spring.io/spring-graphql/docs/1.0.0-SNAPSHOT/reference/html/#overview)

따라서 스프링에서 공식 지원해 주기 전까지는 kickstart를 사용하는 것이 좋아보입니다.
