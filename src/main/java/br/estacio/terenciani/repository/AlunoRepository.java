package br.estacio.terenciani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estacio.terenciani.model.Aluno;
@Repository
public interface AlunoRepository extends 
JpaRepository<Aluno, Long>{

}
