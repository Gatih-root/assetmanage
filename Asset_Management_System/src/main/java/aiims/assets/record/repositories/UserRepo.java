package aiims.assets.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aiims.assets.record.entity.Employe;

public interface UserRepo extends JpaRepository<Employe, Integer> {

	public Employe findByEmail(String emaill);

}
