package aiims.assets.record.services;

import java.util.List;

import aiims.assets.record.models.Employe;

public interface UserService {

	public Employe saveUser(Employe employe);
	

	public void removeSessionMessage();


	List<Employe> getAllEmploye();

}
