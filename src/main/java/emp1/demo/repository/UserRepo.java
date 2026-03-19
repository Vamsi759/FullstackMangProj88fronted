package emp1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emp1.demo.entity.UserRecord;

@Repository
public interface UserRepo extends JpaRepository<UserRecord,Long>{

}
