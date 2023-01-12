package com.example.testmodule4.service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<E,K> {
    Iterable<E> findAll();
    Optional<E> findById(K k);
    E save(E e);
    void deleteById(K k);

    Iterable<E> sortByAge();
}
