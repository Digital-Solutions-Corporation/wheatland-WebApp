package com.fiap.wheatland.wheatland.repository;

import com.fiap.wheatland.wheatland.model.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {
}
