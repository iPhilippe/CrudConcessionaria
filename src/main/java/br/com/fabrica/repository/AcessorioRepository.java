package br.com.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabrica.dominio.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Integer>{

}
