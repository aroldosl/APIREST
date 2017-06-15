package br.estacio.terenciani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.estacio.terenciani.model.Matricula;



@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
