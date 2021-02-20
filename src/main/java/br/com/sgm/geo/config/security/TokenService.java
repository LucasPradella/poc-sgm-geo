package br.com.sgm.geo.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TokenService {
	
	@Value("${jwt.secret}")
	private String secret;

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<GrantedAuthority> getAuthentication(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();

		return Arrays.stream(claims.get("authorities")
				.toString()
				.replace("[", "")
				.replace("]", "")
				.split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
	}
}
