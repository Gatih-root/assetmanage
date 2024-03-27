package aiims.assets.record.services;

import java.util.List;

import aiims.assets.record.models.Employe;

public interface UserService {

	public Employe saveUser(Employe employe);

	public void removeSessionMessage();

	List<Employe> getAllEmploye();

	Employe getEmployeById(long id);

	public void updateUserStatus(String userId, String newStatus);

//	public void updateLastLogin(String user id);
	public void increaseInVailedAttemt(Employe employe);

	public void resetAttemt(String userid);

	public void lock(Employe employe);

	public String getUserDepartment(String userid);

//	public Employ getUserId(String userId);

}
