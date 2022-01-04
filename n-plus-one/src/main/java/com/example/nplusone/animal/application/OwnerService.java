package com.example.nplusone.animal.application;

import com.example.nplusone.animal.domain.Owner;
import com.example.nplusone.animal.infra.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwner(){
        return ownerRepository.findAll();
    }

}
