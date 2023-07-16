
package com.mindtree.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.passenger.entity.PendingRequest;

public interface PendingRequestRepository extends JpaRepository<PendingRequest, Long> {

}
