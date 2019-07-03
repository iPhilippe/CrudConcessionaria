package br.com.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabrica.dominio.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{

}
