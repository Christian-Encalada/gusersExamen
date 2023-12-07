package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class UsuarioDTO {

	private String id;

	private String username;

	private RolDTO rol;
	private String password;
}

