package com.liv.controlefinanceiro.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.liv.controlefinanceiro.domain.enums.PerfilEnum;

public class UserSS implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS() {

	}

	public UserSS(Integer id, String nome, String senha, Set<PerfilEnum> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String getPassword() {

		return senha;
	}

	@Override
	public String getUsername() {

		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	public boolean hasRole(PerfilEnum perfil) {

		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
