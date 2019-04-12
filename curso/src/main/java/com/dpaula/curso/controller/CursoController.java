/**
 * 
 */
package com.dpaula.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpaula.curso.service.CursoService;
import com.dpaula.microservices.core.model.Curso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * @author Fernando de Lima
 *
 */
@RestController
@RequestMapping("v1/admin/curso")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints de gerenciamento dos cursos")
public class CursoController {

	private final CursoService cursoService;
	
	@ApiOperation(value = "Listando todos os cursos disponíveis", response = Curso[].class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<Curso>> list(Pageable pageable) {
		return new ResponseEntity<>(cursoService.list(pageable), HttpStatus.OK);
	}
}
