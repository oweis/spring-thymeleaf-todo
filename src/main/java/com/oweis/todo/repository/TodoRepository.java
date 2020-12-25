package com.oweis.todo.repository;

import com.oweis.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByIsDoneTrue();
    Iterable<Todo> findByIsDoneFalse();

}