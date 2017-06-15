package br.estacio.terenciani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estacio.terenciani.model.Turma;



@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
