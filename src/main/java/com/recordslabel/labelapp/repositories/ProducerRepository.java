package com.recordslabel.labelapp.repositories;

import com.recordslabel.labelapp.entities.Producer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProducerRepository extends CrudRepository<Producer, Long> {

    List<Producer> findAllByOrderByIdAsc();

}
