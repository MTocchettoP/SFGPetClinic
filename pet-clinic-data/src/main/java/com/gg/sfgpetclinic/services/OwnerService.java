package com.gg.sfgpetclinic.services;

import com.gg.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
