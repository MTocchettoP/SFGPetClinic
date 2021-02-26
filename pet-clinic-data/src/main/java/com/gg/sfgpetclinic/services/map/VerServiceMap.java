package com.gg.sfgpetclinic.services.map;

import com.gg.sfgpetclinic.model.Vet;
import com.gg.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VerServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {


    @Override
    public Set<Vet> findall() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
