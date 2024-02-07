package com.example.Inherit.PersonAddress;

import com.example.Inherit.PersonAddress.Address;
import com.example.Inherit.PersonAddress.AddressRepository;
import com.example.Inherit.PersonAddress.Person;
import com.example.Inherit.PersonAddress.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public void savePerson(PersonRequest request) {
        Person person = new Person();
        person.setName(request.getName());

        List<Address> addresses = new ArrayList<>();
        for (String addressStr : request.getAddresses()) {
            Address address = new Address();
            address.setCity(addressStr);
            address.setPerson(person);
            addresses.add(addressRepository.save(address));
        }

        person.setAddresses(addresses);
        personRepository.save(person);
    }

    Logger logger = (Logger) LoggerFactory.getLogger(PersonService.class);

    @Scheduled(cron = "0/2 * * * * *")
    public void scheduler() throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        logger.info(formattedDateTime);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getPersonsByCity(String cityName) {
        return personRepository.findByAddressesCity(cityName);
    }

    public List<Person> findPersonsByNamePattern(String namePattern) {
        return personRepository.findByNameLike("%" + namePattern + "%");

    }
}
