package com.org.msscbeerservice.repository;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.msscbeerservice.domain.Beer;
import com.org.msscbeerservice.entity.BeerStyleEnum;
@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {
	Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);
    
    Beer findByUpc(String upc);

}
