package aiims.assets.record.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import aiims.assets.record.entity.Employe;
import aiims.assets.record.repository.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Employe saveUser(Employe employe) {

		String password=passwordEncoder.encode(employe.getPassword());
		employe.setPassword(password);
		employe.setRole("ROLE_USER");
		Employe newuser = userRepo.save(employe);

		return newuser;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

}
