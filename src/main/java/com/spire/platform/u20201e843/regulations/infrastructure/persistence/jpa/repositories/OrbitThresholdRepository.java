package com.spire.platform.u20201e843.regulations.infrastructure.persistence.jpa.repositories;

import com.spire.platform.u20201e843.regulations.domain.model.entities.OrbitThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrbitThresholdRepository extends JpaRepository<OrbitThreshold,Long> {

    Optional<OrbitThreshold> findByOrbitClass(String orbitClass);

    boolean existsByOrbitClass(String orbitClass);
}
