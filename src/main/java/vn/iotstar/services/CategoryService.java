package vn.iotstar.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import vn.iotstar.entity.CategoryEntity;

public interface CategoryService {

	void deleteAll();

	<S extends CategoryEntity> List<S> findAll(Example<S> example);

	void delete(CategoryEntity entity);

	void deleteById(Long id);

	long count();

	<S extends CategoryEntity, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	<S extends CategoryEntity> long count(Example<S> example);

	Optional<CategoryEntity> findById(Long id);

	<S extends CategoryEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	List<CategoryEntity> findAll();

	Page<CategoryEntity> findAll(Pageable pageable);

	List<CategoryEntity> findAll(Sort sort);

	<S extends CategoryEntity> Optional<S> findOne(Example<S> example);

	<S extends CategoryEntity> S save(S entity);

	Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);

	List<CategoryEntity> findByName(String name);

}
