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

import br.estacio.terenciani.model.Matricula;
import br.estacio.terenciani.repository.MatriculaRepository;

@Controller
public class MatriculaController {

	@Autowired
	private MatriculaRepository matriculaRep;
	
	@RequestMapping(value="/matricula", method=RequestMethod.GET)
	public @ResponseBody List<Matricula> index(){
		return this.matriculaRep.findAll();
	}
	
	@RequestMapping(value="/matricula/{id}", method=RequestMethod.DELETE)
	public @ResponseBody HttpStatus excluir(@PathVariable Long id){
		try {
			matriculaRep.delete(id);
			return HttpStatus.OK;
		} catch(Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
			
		}
	}
	
	@RequestMapping(value="/matricula", method=RequestMethod.POST)
	public @ResponseBody HttpStatus adicionar(@RequestBody Matricula matricula){
		try{
			matriculaRep.save(matricula);
			return HttpStatus.OK;
		} catch(Exception e){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
	@RequestMapping(value="/matricula/{id}", method=RequestMethod.GET)
	public @ResponseBody Matricula listarPorId(@PathVariable Long id){
		return this.matriculaRep.findOne(id);
	}
	
	@RequestMapping(value="/matricula", method=RequestMethod.PUT)
	public @ResponseBody HttpStatus atualizar(@RequestBody Matricula matricula){
		try{
			matriculaRep.save(matricula);
			return HttpStatus.OK;
		} catch(Exception e){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
