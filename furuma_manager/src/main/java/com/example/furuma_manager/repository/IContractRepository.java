package com.example.furuma_manager.repository;

import com.example.furuma_manager.dto.IContractDto;
import com.example.furuma_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select customer.name as customerName,facility.name as facilityName,contract.end_date as contractEndDay,\n" +
            "            contract.start_date as contractStartDay,contract.deposit as contractDeposit, (sum(ifnull(attach_facility.cost,0)*ifnull(contract_detail.quantity,0))+(facility.cost)) as total\n" +
            "             from `contract` left join `customer` on contract.customer_id=customer.id left join `facility` on facility.id=contract.facility left join \n" +
            "            `contract_detail`  on contract_detail.contract_id=contract.id left join `attach_facility` on attach_facility.id=contract_detail.attach_facility_id group by contract.id", nativeQuery = true)
            Page<IContractDto> getAll(Pageable pageable);








}
