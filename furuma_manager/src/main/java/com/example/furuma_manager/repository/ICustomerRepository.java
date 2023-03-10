package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.* from `customer` c left join `customer_type` ct on c.customer_type=ct.id  where is_delete = false and c.name like concat('%',:nameSearch,'%') and email like concat('%',:email,'%') and ct.name  like concat('%',:type,'%')",nativeQuery = true)

    Page<Customer> findAll(@Param("nameSearch") String name,@Param("email") String email,@Param("type") String type, Pageable pageable);

}
