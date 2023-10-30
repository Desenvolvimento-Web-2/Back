package br.net.trabalho.api.rest;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.trabalho.api.model.Roupa;
import br.net.trabalho.api.repository.RoupaRepository;
import br.net.trabalho.api.rest.dto.RoupaDTO;

@CrossOrigin
@RestController
public class RoupaREST {
	public List<Roupa> lista = new ArrayList<>();
	@Autowired
	private RoupaRepository repo;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/roupas")
	RoupaDTO inserir(@RequestBody
					RoupaDTO roupa) {
		repo.save(mapper.map(roupa, Roupa.class));
		Roupa rou = repo.findByNome(roupa.getNome());
		return mapper.map(rou, RoupaDTO.class);
	}

	@GetMapping("/roupas")
	List<RoupaDTO> listarTodos() {
		List<Roupa> lista = repo.findAll();
		return lista.stream().map(e -> mapper.map(e, RoupaDTO.class))
							 .collect(Collectors.toList());
	}