package com.enterprise.vetSystem.repository;

import com.enterprise.vetSystem.enums.Species;
import com.enterprise.vetSystem.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("""
            SELECT a FROM Animal a
            WHERE (:name is null or UPPER(a.name) LIKE UPPER(CONCAT('%',:name,'%')))
              AND (:species is null or a.species = :species)
    """)
    List<Animal> findByFilters(@Param("name") String name, @Param("species") Species species);

    @Query("SELECT a FROM Animal a WHERE UPPER(a.species) = UPPER(:speciesName)")
    List<Animal> findBySpeciesIgnoreCase(@Param("speciesName") String speciesName);
}
