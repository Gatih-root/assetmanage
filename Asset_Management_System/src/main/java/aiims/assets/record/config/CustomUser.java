package aiims.assets.record.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import aiims.assets.record.models.Employe;

public class CustomUser implements UserDetails {

	private Employe employe;

	public CustomUser(Employe employe) {
		super();
		this.employe = employe;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employe.getRole());

		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return employe.getPassword();
	}

	@Override
	public String getUsername() {
		return employe.getEmail();
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

}
