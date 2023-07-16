
package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.embed.ModelColorKey;
import com.mindtree.carproject.entity.ModelColor;

public interface ModelColorRepository extends JpaRepository<ModelColor, ModelColorKey> {

}
