package aiims.assets.record.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import aiims.assets.record.models.Employe;
import aiims.assets.record.repositories.UserRepo;
import aiims.assets.record.services.FailedAttempt;
import aiims.assets.record.services.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserService userservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Employe empploginupdate = userRepo.findByUserid(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		if ("DISABELED".equals(empploginupdate.getStatus())) {
			throw new DisabledException("your account is DISABELED");
		}
			//empploginupdate.setLastlogin(new Date());
			empploginupdate.setStatus("ACTIVE");

		if (empploginupdate.getInvaledAttemts() >= 3) {
			empploginupdate.setStatus("DISABELED");
		} else {
			empploginupdate.setInvaledAttemts(empploginupdate.getInvaledAttemts()+1);
		}
		System.err.println(empploginupdate.getInvaledAttemts());
		return new CustomUser(userRepo.save(empploginupdate));

	}
}
