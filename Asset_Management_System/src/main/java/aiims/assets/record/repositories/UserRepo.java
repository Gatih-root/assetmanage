package aiims.assets.record.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aiims.assets.record.models.Employe;

public interface UserRepo extends JpaRepository<Employe, Long> {

//	public Employe findByEmail(String emaill);
	public Employe findByUserid(String userid);

	

}
