package aiims.assets.record.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import aiims.assets.record.entity.Employe;
import aiims.assets.record.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employe employe = userRepo.findByEmail(username);
		System.out.println(employe);
		if (employe == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			return new CustomUser(employe);
		}

	}

}
