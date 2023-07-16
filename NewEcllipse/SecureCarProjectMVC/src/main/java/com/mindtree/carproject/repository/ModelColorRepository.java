
package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.ModelColor;
@Repository
public interface ModelColorRepository extends JpaRepository<ModelColor, ModelColorKey> {
	//Optional<ModelColor> findByKey(ModelColorKey key);
}
