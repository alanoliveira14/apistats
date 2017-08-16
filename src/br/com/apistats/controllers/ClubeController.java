package br.com.apistats.controllers;

import br.com.apistats.database.ConexaoMySQL;
import br.com.apistats.entity.Clube;
import br.com.apistats.entity.Jogador;
import br.com.apistats.exceptions.DadoImportanteInvalidoException;
import br.com.apistats.models.ClubeModel;
import br.com.apistats.models.JogadorModel;
import br.com.apistats.ResultadoOperacaoAPI;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubeController {
	
	@Autowired
	private ClubeModel clubeModel;	
	
	@Autowired
	private ConexaoMySQL conexaoMySQL;

	@RequestMapping(	
			value = "/clubes",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Clube>> clubes() throws Exception {
		
		List<Clube> clubes = clubeModel.getClubes();
			
		return new ResponseEntity<List<Clube>>(clubes, HttpStatus.OK);
	}
	
}
