package br.com.fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabrica.dominio.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
