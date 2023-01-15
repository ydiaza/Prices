package com.inditex.ecommerce.application.ports.output;

import com.inditex.ecommerce.domain.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>{
    @Query(" SELECT p " +
            "FROM Price p " +
            "WHERE p.id.id = ?1 AND p.brandId = ?2 AND ?3 BETWEEN p.startDate AND p.endDate " +
            "AND (p.id.id, p.priority) in " +
            "(SELECT p1.id.id, MAX(p1.priority) FROM Price p1 " +
            "WHERE p1.id.id = ?1 AND p1.brandId = ?2 AND ?3 BETWEEN p1.startDate AND p1.endDate " +
            "GROUP BY p1.id.id) ")
    List<Price> findByIdAndBrandAndDate (Integer productId, Integer brandId, LocalDateTime applicationDate);
}
