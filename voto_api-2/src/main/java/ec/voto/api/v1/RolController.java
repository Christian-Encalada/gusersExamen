package ec.voto.api.v1;

import java.util.List;

import ec.voto.api.dto.RolDTO;
import ec.voto.api.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.voto.api.dto.ApiResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v1.0/rol" })
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listar() {
        List<RolDTO> list = service.findAll(new RolDTO());
        ApiResponseDTO<List<RolDTO>> response = new ApiResponseDTO<>(true, list);
        return (new ResponseEntity<Object>(response, HttpStatus.OK));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody RolDTO RolDTO) {
        RolDTO RolDTOResult = service.save(RolDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, RolDTOResult), HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody RolDTO RolDTO) {
        RolDTO resultDTO = service.update(RolDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody RolDTO RolDTO) {
        RolDTO resultDTO = service.delete(RolDTO);
        return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
    }




}
