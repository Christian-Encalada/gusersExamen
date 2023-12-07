package ec.voto.api.service;

import java.util.List;
import java.util.Optional;

import ec.voto.api.domain.Usuario;
import ec.voto.api.dto.UsuarioDTO;
import ec.voto.api.repository.UsuarioPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ec.voto.api.common.ApiException;


@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO> {

	@Autowired
	private UsuarioPersistence repository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public UsuarioDTO save(UsuarioDTO dto) {
		Optional<Usuario> optional = find(dto);
		if (optional.isPresent()) {
			throw new ApiException(String.format("Usuario ya registrado en el sistema", dto));
		} else {
			dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

			return mapToDto(repository.save(mapToDomain(dto)));
		}
	}

	public Optional<Usuario> findByUsername(String username) {
		Optional<Usuario> entidad = repository.findByUsername(username);
		return entidad;
	}

	public List<Usuario> findByRolNombre(String nombreRol) {
		List<Usuario> entidad = repository.findByRolNombre(nombreRol);
		return entidad;
	}
	@Override
	public Optional<Usuario> find(UsuarioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Usuario mapToDomain(UsuarioDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}


	@Override
	public UsuarioDTO mapToDto(Usuario domain) {
		return modelMapper.map(domain, UsuarioDTO.class);
	}



}

