package aiims.assets.record.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import aiims.assets.record.models.Departments;
import aiims.assets.record.models.Employe;
import aiims.assets.record.repositories.UserRepo;
import jakarta.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Employe saveUser(Employe employe) {	
		
		employe.setRole("ROLE_USER");
		
		RandomPasswordGenerator generator = new RandomPasswordGenerator();
		String pass = generator.generatePassword();
		System.out.println("Random password: " + pass);
		
		employe.setPassword(passwordEncoder.encode(pass));		
		Employe newuser = userRepo.save(employe);
		newuser.setPassword(pass);
		return newuser;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}
	 public List<Employe> getAllEmploye() {
	        return userRepo.findAll();
	    }

	@Override
	public Employe getEmployeById(long id) {
		Optional<Employe> optional=userRepo.findById(id);
		Employe employe=null;
		if(optional.isPresent()) {
			employe=optional.get();
		} else {
			throw new RuntimeException("employe not found for id::" +id);
		}
		return employe;
	}
	
	//change

	 public void updateLastLogin(String userid) {
	       Employe user = userRepo.findByUserid(userid).orElse(null);
	        if (user != null) {
	            user.setLastlogin(new Date());
	            userRepo.save(user);
	        }
	    }

	@Override
	public void updateUserStatus(String userId, String newStatus) {
		 Employe employe = userRepo.findByUserid(userId).orElse(null);
	        if (employe != null) {
	        	  employe.setStatus(newStatus);
	            userRepo.save(employe);
	        }
	    }

	@Override
	public void increaseInVailedAttemt(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetAttemt(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lock(Employe employe) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
    public String getUserDepartment(String userid) {
        Employe employe = userRepo.findByUserid(userid).orElse(null);
        if (employe != null) {
            return employe.getDepartment(); // Assuming there's a getter method for the department field in the Employe class
        } else {
            return null; // Or you can throw an exception if the user is not found
        }
    }

	
		
	
	

}
