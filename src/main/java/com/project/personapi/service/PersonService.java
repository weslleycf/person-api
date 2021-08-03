package com.project.personapi.service;


import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.dto.response.MessageResponseDTO;
import com.project.personapi.entity.Person;
import com.project.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPeople(){
        return personRepository.findAll();
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person.builder()

        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Person created with id : " + savedPerson.getId())
                .build();
    }


}


