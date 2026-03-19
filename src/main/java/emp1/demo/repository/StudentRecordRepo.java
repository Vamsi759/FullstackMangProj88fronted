package emp1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emp1.demo.entity.Studentrecord;

@Repository
public interface StudentRecordRepo extends JpaRepository<Studentrecord,Long>{

}
