package br.com.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabrica.dominio.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
