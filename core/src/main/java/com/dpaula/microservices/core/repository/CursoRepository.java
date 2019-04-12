/**
 * 
 */
package com.dpaula.microservices.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dpaula.microservices.core.model.Curso;

/**
 * @author Fernando de Lima
 *
 */
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {

}
