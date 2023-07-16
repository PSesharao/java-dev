package com.mindtree.passenger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.passenger.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
	Optional<Train> findByName(String name);
	@Query("SELECT t FROM Train t WHERE t.source = ?1 and t.destination = ?2")
	List<Train> getTriansBySourceAndDestination( String source , String destination);
}
