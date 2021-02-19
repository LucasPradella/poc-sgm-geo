package br.com.sgm.geo.config;


import br.com.sgm.geo.config.model.Roles;
import br.com.sgm.geo.config.model.UserModel;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AuthTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;


	public AuthTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			authClient(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private void authClient(String token) {
		UserModel user = UserModel.builder().roles(Arrays.asList(Roles.builder().role("ROLE_ADMIN").build())).build();

		Collection<? extends GrantedAuthority> authorities = tokenService.getAuthentication(token);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}


//	private void authClient(String token) {
////		List<GrantedAuthority> authentication1 = tokenService.getAuthentication(token);
//
////		UserModel user = UserModel.builder().roles(authentication1).build();
//
//
//
////		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(tokenService.authentication(token));
//	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
