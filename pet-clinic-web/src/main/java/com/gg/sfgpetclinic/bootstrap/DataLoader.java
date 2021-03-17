package com.gg.sfgpetclinic.bootstrap;

import com.gg.sfgpetclinic.model.*;
import com.gg.sfgpetclinic.services.OwnerService;
import com.gg.sfgpetclinic.services.PetTypeService;
import com.gg.sfgpetclinic.services.SpecialtyService;
import com.gg.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findall().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Teeth go brrrr");
        dentistry = specialtyService.save(dentistry);

        Specialty radiology = new Specialty();
        radiology.setDescription("them radios");
        radiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("nip tuck");
        surgery = specialtyService.save(surgery);


        PetType dog = new PetType();
        dog.setName("dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        cat = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Jack");
        owner1.setLastName("Of");
        owner1.setAddress("123 street");
        owner1.setCity("A city");
        owner1.setTelephone("1234567899");
        Pet pet1 = new Pet();
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setName("Fluffy");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Herbert");
        owner2.setLastName("Dom");
        owner2.setAddress("456 street");
        owner2.setCity("B city");
        owner2.setTelephone("98765432");
        Pet pet2 = new Pet();
        pet2.setPetType(cat);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        pet2.setName("Scrachy");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Gamgee");
        vet1.getSpecialties().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Frodo");
        vet2.setLastName("Baggins");
        vet2.getSpecialties().add(dentistry);
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
