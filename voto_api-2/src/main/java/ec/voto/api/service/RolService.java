package ec.voto.api.service;
import java.util.Optional;

import ec.voto.api.domain.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import ec.voto.api.domain.Rol;
import ec.voto.api.dto.RolDTO;
import ec.voto.api.repository.RolPersistence;

@Service
public class RolService extends GenericCrudServiceImpl<Rol, RolDTO> {

	@Autowired
	private RolPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Rol> find(RolDTO dto) {
		return repository.findById(dto.getId());
	}



	@Override
	public Rol mapToDomain(RolDTO dto) {
		return modelMapper.map(dto, Rol.class);
	}

	@Override
	public RolDTO mapToDto(Rol domain) {
		return modelMapper.map(domain, RolDTO.class);
	}

	public Optional<Rol> findByNombre(String nombre) {
		Optional<Rol> entidad = repository.findByNombre(nombre);
		return entidad;
	}


}
