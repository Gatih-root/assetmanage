package aiims.assets.record.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import aiims.assets.record.models.Employe;

public interface UserRepo extends JpaRepository<Employe, Long> {

//	public Employe findByEmail(String emaill);
	public Optional<Employe> findByUserid(String userid);

	public Employe getEmployeById(long id);
	
//	@Query("update Employe u set u.InvaledAttemts=?1 where userid=?2 ")
//	@Modifying
//	public void updateInvaledAttemts(int InvaledAttemts,String userid);

	

}
