package com.dpaula.microservices.core.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dpaula.microservices.core.model.ApplicationUser;

/**
 * 
 * @author Fernando de Lima
 *
 */
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);

}