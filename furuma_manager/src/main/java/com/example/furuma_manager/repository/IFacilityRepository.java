package com.example.furuma_manager.repository;


import com.example.furuma_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
@Query(value = "select * from facility where is_delete = false and name like concat('%',:name,'%')  and  facility_type_id like concat('%',:type,'%')",nativeQuery = true)
Page<Facility> findAd(@Param("name") String name, @Param("type") String facilityType, Pageable pageable);
}
