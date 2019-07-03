package br.com.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabrica.dominio.Chave;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer>{

}
