package br.estacio.terenciani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.estacio.terenciani.model.Turma;
import br.estacio.terenciani.repository.TurmaRepository;


@Controller
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRep;
	
	@RequestMapping(value="/turma", method=RequestMethod.GET)
	public @ResponseBody List<Turma> index(){
		return this.turmaRep.findAll();
	}
	
	@RequestMapping(value="/turma/{id}", method=RequestMethod.DELETE)
	public @ResponseBody HttpStatus excluir(@PathVariable Long id){
		try {
			turmaRep.delete(id);
			return HttpStatus.OK;
		} catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
			
		}
	}
	
	@RequestMapping(value="/turma", method=RequestMethod.POST)
	public @ResponseBody HttpStatus adicionar(@RequestBody Turma turma){
		try{
			turmaRep.save(turma);
			return HttpStatus.OK;
		} catch(Exception e){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
	@RequestMapping(value="/turma/{id}", method=RequestMethod.GET)
	public @ResponseBody Turma listarPorId(@PathVariable Long id){
		return this.turmaRep.findOne(id);
	}
	
	@RequestMapping(value="/turma", method=RequestMethod.PUT)
	public @ResponseBody HttpStatus atualizar(@RequestBody Turma turma){
		try{
			turmaRep.save(turma);
			return HttpStatus.OK;
		} catch(Exception e){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}

