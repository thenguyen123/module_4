package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
@Query(value = "select * from contract_detail where contract_id =:id",nativeQuery = true)
List<ContractDetail> findByContract_Id(@Param("id") int id);
}
