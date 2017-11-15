package br.com.apistats.controllers;

import br.com.apistats.database.ConexaoMySQL;
import br.com.apistats.entity.Jogador;
import br.com.apistats.exceptions.DadoImportanteInvalidoException;
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
public class JogadorController {
	@Autowired
	private JogadorModel jogadorModel;	
	
	@Autowired
	private ConexaoMySQL conexaoMySQL;
	
	@RequestMapping(	
			value = "/jogadores",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Jogador>> jogadores() throws Exception {
		
		List<Jogador> jogadores = jogadorModel.getJogadores();
			
		return new ResponseEntity<List<Jogador>>(jogadores, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/jogador",
			method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResultadoOperacaoAPI inserir(@RequestBody Jogador jogador) throws Exception {
		
			try{
				jogadorModel.inserir(jogador);
			}
			catch(Exception e){
				return new ResultadoOperacaoAPI(e.getMessage(), false);
			}		
		return new ResultadoOperacaoAPI ("Jogador inserido com sucesso!", true);
	}
	
	@RequestMapping(
			value = "/jogador/{idJogador}",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<Jogador> getRegra(@PathVariable Integer idJogador) throws Exception {
		
		Jogador jogador = new Jogador();
		
			try{
				jogador.setIdJogador(idJogador);
				jogador = jogadorModel.getJogadorById(jogador.getIdJogador());
			}
			catch(Exception e){
				return new ResponseEntity<Jogador>(jogador, HttpStatus.BAD_REQUEST);
			}
		
		return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/jogador/{idJogador}",
			method = RequestMethod.PUT,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResultadoOperacaoAPI atualizar(@PathVariable Integer idJogador, @RequestBody Jogador jogador) throws Exception {
		
			try{
				jogador.setIdJogador(idJogador);
				jogadorModel.atualizar(jogador);
			}
			catch(Exception e){
				return new ResultadoOperacaoAPI(e.getMessage(), false);
			}
					
		return new ResultadoOperacaoAPI ("Jogador atualizado com sucesso!", true);
	}

	@RequestMapping(	
			value = "/jogador/goleiros",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Jogador>> goleiros() throws Exception {
		
		List<Jogador> goleiros = jogadorModel.getGoleiros();
			
		return new ResponseEntity<List<Jogador>>(goleiros, HttpStatus.OK);
	}

	@RequestMapping(	
			value = "/jogador/defensores",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Jogador>> defensores() throws Exception {
		
		List<Jogador> defensores = jogadorModel.getDefensores();
			
		return new ResponseEntity<List<Jogador>>(defensores, HttpStatus.OK);
	}

	@RequestMapping(	
			value = "/jogador/meias",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Jogador>> meias() throws Exception {
		
		List<Jogador> meias = jogadorModel.getMeias();
			
		return new ResponseEntity<List<Jogador>>(meias, HttpStatus.OK);
	}

	@RequestMapping(	
			value = "/jogador/atacantes",
			method = RequestMethod.GET,
			produces = "application/json;charset=UTF-8")
	@ResponseBody	
	public ResponseEntity<List<Jogador>> atacantes() throws Exception {
		
		List<Jogador> atacantes = jogadorModel.getAtacantes();
			
		return new ResponseEntity<List<Jogador>>(atacantes, HttpStatus.OK);
	}
	
}
