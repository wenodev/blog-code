package com.example.nplusone.animal.application;

import com.example.nplusone.animal.domain.Cat;
import com.example.nplusone.animal.domain.Owner;
import com.example.nplusone.animal.infra.OwnerRepository;
import com.example.nplusone.animal.infra.OwnerRepositoryCustom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OwnerServiceTest {
    @Autowired
    private OwnerRepositoryCustom ownerRepositoryCustom;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerService ownerService;

    @BeforeEach
    void setUp(){
        List<Cat> cats = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            cats.add(new Cat("cat" + i));
        }

        List<Owner> owners = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            owners.add(
                    Owner.builder()
                            .name("owner" + i)
                            .cats(cats)
                            .build());
        }
        ownerRepository.saveAll(owners);
    }

    @Test
    void test_getOwner_with_custom_repository(){
        System.out.println("with_query_repository");
        ownerRepositoryCustom.findAllFetchJoin();
    }

    @Test
    void test_getOwner_with_repository(){
        System.out.println("with_repository");
        ownerRepository.findAll();
    }

    @Test
    void test_getOwner_with_service(){
        System.out.println("with_service");
        ownerService.getOwner();
    }

    @AfterEach
    void tearDown(){
        ownerRepository.deleteAll();
    }

}