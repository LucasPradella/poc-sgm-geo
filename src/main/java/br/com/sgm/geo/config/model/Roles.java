package br.com.sgm.geo.config.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
public class Roles implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	private String role;

	@Override
	public String getAuthority() {
		return role;
	}
	
}
