package com.example.Inherit.PersonAddress;

import com.example.Inherit.PersonAddress.Address;
import com.example.Inherit.PersonAddress.AddressRepository;
import com.example.Inherit.PersonAddress.Person;
import com.example.Inherit.PersonAddress.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void savePerson(PersonRequest request) {
        Person person = new Person();
        person.setName(request.getName());

        List<Address> addresses = new ArrayList<>();
        for (String addressStr : request.getAddresses()) {
            Address address = new Address();
            address.setCity(addressStr); // Assuming city is extracted from address string
            address.setPerson(person);
            addresses.add(addressRepository.save(address));
        }

        person.setAddresses(addresses);
        personRepository.save(person);
    }
    //@Transactional(readOnly = true)
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    public List<Person> getPersonsByCity(String cityName) {
        return personRepository.findByAddressesCity(cityName);
    }
}
