package com.gg.sfgpetclinic.services;

import com.gg.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findbyId(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}