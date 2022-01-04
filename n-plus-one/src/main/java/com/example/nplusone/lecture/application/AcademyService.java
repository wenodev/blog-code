package com.example.nplusone.lecture.application;

import com.example.nplusone.lecture.domain.Academy;
import com.example.nplusone.lecture.infra.AcademyRepository;
import com.example.nplusone.lecture.infra.AcademyRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyRepositoryCustom academyRepositoryCustom;

    public AcademyService(AcademyRepository academyRepository, AcademyRepositoryCustom academyRepositoryCustom) {
        this.academyRepository = academyRepository;
        this.academyRepositoryCustom = academyRepositoryCustom;
    }

    @Transactional(readOnly = true)
    public List<String> getAcademy(){
        return extractSubjectNames(academyRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<String> getAcademyWithQuery(){
        return extractSubjectNames(academyRepository.findAllJoinFetch());
    }

    @Transactional(readOnly = true)
    public List<String> getAcademyWithCustom(){
        return extractSubjectNames(academyRepositoryCustom.findAllCustom());
    }

    /**
     * Lazy Load를 수행하기 위해 메소드를 별도로 생성
     */
    private List<String> extractSubjectNames(List<Academy> academies){
        log.info(">>>>>>>>[모든 과목을 추출한다]<<<<<<<<<");
        log.info("Academy Size : {}", academies.size());

        return academies.stream()
                .map(a -> a.getSubjects().get(0).getName())
                .collect(Collectors.toList());
    }

}
