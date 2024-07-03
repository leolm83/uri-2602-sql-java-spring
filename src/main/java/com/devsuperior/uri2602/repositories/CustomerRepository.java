package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dtos.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM CUSTOMERS WHERE STATE = :state",nativeQuery = true)
    List<CustomerNameMinProjection> searchByState(String state);
    @Query(value = "SELECT obj FROM Customer obj WHERE obj.state = :state")
    List<Customer> searchByStateWithJPQL(String state);//busca todos os dados
    @Query(value = "SELECT new com.devsuperior.uri2602.dtos.CustomerMinDTO(obj.name) FROM Customer obj WHERE obj.state = :state")
    List<CustomerMinDTO> searchNameByStateWithJPQL(String state);//busca todos os dados

}
