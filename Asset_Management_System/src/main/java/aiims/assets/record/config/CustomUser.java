package aiims.assets.record.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import aiims.assets.record.models.Employe;
import aiims.assets.record.services.FailedAttempt;

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
		return employe.getUserid();
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
