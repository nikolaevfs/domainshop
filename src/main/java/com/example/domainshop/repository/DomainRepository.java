package com.example.domainshop.repository;

import com.example.domainshop.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainRepository extends JpaRepository<Domain,Long> {

}
