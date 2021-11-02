package com.buscaminas.repositories;

import com.buscaminas.entities.Cell;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CellRepository extends CrudRepository<Cell, Long> {

}
