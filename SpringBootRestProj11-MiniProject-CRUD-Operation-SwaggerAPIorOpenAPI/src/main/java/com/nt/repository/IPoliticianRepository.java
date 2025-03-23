package com.nt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Politician;

public interface IPoliticianRepository extends JpaRepository<Politician, Integer>
{
	@Query("from Politician where party in(:party1,:party2,:party3)order by party")
public List<Politician>findAllPoliticianByParties(String party1,String party2,String party3);
}
