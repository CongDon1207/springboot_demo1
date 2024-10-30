package vn.iotstar.services;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.entity.Category;


public interface CategoryService {
List<Category> findByNameContaining(String name);
    
    Page<Category> findByNameContaining(String name, Pageable pageable);
    
    <S extends Category> S save(S entity);
    
    <S extends Category> Optional<S> findOne(Example<S> example);
    
    List<Category> findAll();
    
    List<Category> findAllById(Iterable<Long> ids);
    
    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);
    
    Optional<Category> findById(Long id);
    
    long count();
    
    void deleteById(Long id);
    
    void delete(Category entity);
    
    <S extends Category> List<S> findAll(Example<S> example, Sort sort);
    
    void deleteAll();

	Page<Category> findAll(Pageable pageable);

	
}