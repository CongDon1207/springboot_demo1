package vn.iotstar.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository cateRepo;

	public CategoryServiceImpl(CategoryRepository cateRepo) {
		this.cateRepo = cateRepo;
	}

	@Override
	public List<CategoryEntity> findByName(String name) {
		return cateRepo.findByName(name);
	}

	@Override
	public Page<CategoryEntity> findByNameContaining(String name, Pageable pageable) {
		return cateRepo.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends CategoryEntity> S save(S entity) {
		return cateRepo.save(entity);
	}

	@Override
	public <S extends CategoryEntity> Optional<S> findOne(Example<S> example) {
		return cateRepo.findOne(example);
	}

	@Override
	public List<CategoryEntity> findAll(Sort sort) {
		return cateRepo.findAll(sort);
	}

	@Override
	public Page<CategoryEntity> findAll(Pageable pageable) {
		return cateRepo.findAll(pageable);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return cateRepo.findAll();
	}


	@Override
	public <S extends CategoryEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cateRepo.findAll(example, pageable);
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return cateRepo.findById(id);
	}

	@Override
	public <S extends CategoryEntity> long count(Example<S> example) {
		return cateRepo.count(example);
	}

	@Override
	public <S extends CategoryEntity, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cateRepo.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return cateRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		cateRepo.deleteById(id);
	}


	@Override
	public void delete(CategoryEntity entity) {
		cateRepo.delete(entity);
	}

	@Override
	public <S extends CategoryEntity> List<S> findAll(Example<S> example) {
		return cateRepo.findAll(example);
	}

	@Override
	public void deleteAll() {
		cateRepo.deleteAll();
	}
	
	
	
	
}
