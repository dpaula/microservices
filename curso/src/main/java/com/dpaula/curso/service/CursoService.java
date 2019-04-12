/**
 * 
 */
package com.dpaula.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dpaula.microservices.core.model.Curso;
import com.dpaula.microservices.core.repository.CursoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Fernando de Lima
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CursoService {

	private final CursoRepository cursoRepository;

	public Iterable<Curso> list(Pageable pageable) {
		log.info("Listando os cursos");
		return cursoRepository.findAll(pageable);
	}

}
