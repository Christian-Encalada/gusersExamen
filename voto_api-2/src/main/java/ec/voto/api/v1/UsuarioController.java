package ec.voto.api.v1;

import java.util.List;


import ec.voto.api.domain.Usuario;
import ec.voto.api.dto.UsuarioDTO;
import ec.voto.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.voto.api.dto.ApiResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v1.0/usuario" })
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<UsuarioDTO> list = service.findAll(new UsuarioDTO());
		ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<Object>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody UsuarioDTO UsuarioDTO) {
		UsuarioDTO UsuarioDTOResult = service.save(UsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, UsuarioDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody UsuarioDTO UsuarioDTO) {
		UsuarioDTO resultDTO = service.update(UsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminar(@RequestBody UsuarioDTO UsuarioDTO) {
		UsuarioDTO resultDTO = service.delete(UsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}


	@GetMapping(value = "id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") String id) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}


	@GetMapping(value = "username/{username}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorUsername(@Valid @PathVariable("username") String username) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.findByUsername(username)), HttpStatus.OK);
	}

	@GetMapping(value = "por_rol/{nombreRol}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorRol(@Valid @PathVariable("nombreRol") String nombreRol) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.findByRolNombre(nombreRol)), HttpStatus.OK);
	}

}