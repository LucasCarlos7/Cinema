package com.api.cinema.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Long> {

    List<AnaliseEntity> findByFilmeId(Long filmeId);

}
