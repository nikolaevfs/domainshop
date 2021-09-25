package com.example.domainshop.repository;

import com.example.domainshop.model.Tld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TldRepository extends JpaRepository<Tld,Long> {
    public List<Tld> findAllByOrderByPrice();
}
