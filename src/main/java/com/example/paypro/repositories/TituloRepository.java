package com.example.paypro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paypro.entitys.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long>{

}
