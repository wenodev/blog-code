package com.example.nplusone.lecture.application;

import com.example.nplusone.lecture.domain.Academy;
import com.example.nplusone.lecture.domain.Subject;
import com.example.nplusone.lecture.infra.AcademyRepository;
import com.example.nplusone.lecture.infra.AcademyRepositoryCustom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AcademyServiceTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositoryCustom academyRepositoryCustom;

    @Autowired
    private AcademyService academyService;

    @BeforeEach
    public void setup() {
        List<Academy> academies = new ArrayList<>();

        for(int i=0;i<10;i++){
            Academy academy = Academy.builder()
                    .name("강남스쿨"+i)
                    .build();

            academy.addSubject(Subject.builder().name("자바웹개발" + i).build());
            academy.addSubject(Subject.builder().name("파이썬웹개발" + i).build());

            academies.add(academy);
        }

        academyRepository.saveAll(academies);
    }

    @Test
    public void getAcademy_메소드는_Academy여러개를_조회시_Subject가_N1_쿼리가발생한다() throws Exception {
        //given
        List<String> subjectNames = academyService.getAcademy();

        //then
        assertThat(subjectNames.size()).isEqualTo(10);
    }

    @Test
    public void getAcademyWithQuery_메소드는_Academy여러개를_조회시_케테시안_곱이_발생한다() throws Exception {
        //given
        List<String> subjectNames = academyService.getAcademyWithQuery();

        //then
        assertThat(subjectNames.size()).isEqualTo(20);
    }

    @Test
    public void getAcademyWithQuery_메소드는_Academy여러개를_조회시_N1과_카테시안_곱이_발생하지_않는다() throws Exception {
        //given
        List<String> subjectNames = academyService.getAcademyWithCustom();

        //then
        assertThat(subjectNames.size()).isEqualTo(20);
    }

    @AfterEach
    void tearDown(){
        academyRepository.deleteAll();
    }

}

