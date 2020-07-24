package com.alura.discoteca.repository;

import com.alura.discoteca.models.Disco;
import org.springframework.data.repository.CrudRepository;

public interface DiscoRepository extends CrudRepository<Disco, Long> {
}
