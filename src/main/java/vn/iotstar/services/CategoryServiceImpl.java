package vn.iotstar.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.*;
import vn.iotstar.reponsitory.*;


// Khai báo service
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}

	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}

	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryRepository.findAll(example, pageable);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	public long count() {
		return categoryRepository.count();
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryRepository.findAll(example, sort);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
    
}
