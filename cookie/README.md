# Springboot Cookie 사용

## 쿠키란?
- 사용자의 부라우저에 저장되는 작은양의 정보이다.
- Http  cookie, Web cookie, Browser cookie 불린다.
- 크롱을 사용중이라면 개발자도구의 Application  탭에서 확인할 수 있다.
(아래의 글에서 확인할 수 있다.)
- 자세한 내용은 정리를 잘 해주신 라이언 서버님의 블로그(https://interconnection.tistory.com/7) 에서 확인 할 수 있습니다.


##  SpringBoot에서 Cookie 사용 방법

우선 Spring spring initializr(https://start.spring.io/)에서 프로젝트를 만들어 줍니다.
- build.gradle
```
plugins {
	id 'org.springframework.boot' version '2.3.3.RELEASE'
	id 'io.spring.dependency-management' version '1.0.10.RELEASE'
	id 'java'
}

group = 'com.weno'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
	implementation 'junit:junit:4.12'
}

test {
	useJUnitPlatform()
}


```

- 
