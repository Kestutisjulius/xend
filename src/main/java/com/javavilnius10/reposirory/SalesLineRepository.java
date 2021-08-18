package com.javavilnius10.reposirory;

import com.javavilnius10.model.SalesLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalesLineRepository extends JpaRepository<SalesLine, Long> {
    @Query("SELECT p FROM SalesLine p WHERE p.nowDateTime BETWEEN ?1 AND ?2")
    SalesLine getSalesLineByPeriod(LocalDateTime from, LocalDateTime to);

    @Query("SELECT i FROM SalesLine i WHERE i.id=?1")
    SalesLine getSalesLineById(Long id);

    @Query("SELECT l FROM SalesLine l WHERE l.name = ?1")
    SalesLine getSalesLineByName(String name);

    @Query
    List<SalesLine> findByProduct_Id(@NonNull Long id);

}