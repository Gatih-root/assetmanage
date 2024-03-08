package aiims.assets.record.service;

import aiims.assets.record.entity.Employe;

public interface UserService {

	public Employe saveUser(Employe employe);

	public void removeSessionMessage();

}
