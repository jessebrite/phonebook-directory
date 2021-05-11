package com.aboagye.phonebookdirectory.repository;

import com.aboagye.phonebookdirectory.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	Optional<Owner> findByEmail(String email);

//	@RestResource(path = "searchByKeyword")
	Page<Owner> findByMsisdnContaining(@Param("msisdn") String keywork, Pageable pageable);

	Boolean existsByEmail(String email);
}
