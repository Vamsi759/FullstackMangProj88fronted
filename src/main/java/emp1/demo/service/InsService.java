package emp1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emp1.demo.entity.Studentrecord;
import emp1.demo.entity.UserRecord;
import emp1.demo.repository.StudentRecordRepo;
import emp1.demo.repository.UserRepo;

@Service
public class InsService {
	
	@Autowired
	private StudentRecordRepo repo;
	
	 public Studentrecord save(Studentrecord r) {
		Studentrecord s=new Studentrecord();
		s.setName(r.getName());
		s.setCourse(r.getCourse());
		s.setQualification(r.getQualification());
		s.setEmail(r.getEmail());
		repo.save(s);
		 return null;
	 }
	   public Studentrecord get(Long id) {
	    	
		   return repo.findById(id).orElse(null);
	    }
	    public List<Studentrecord> getAll(){
	    	return repo.findAll();
	    }
	    
	    public void delete(Long id) {
	    	repo.deleteById(id);
	    }
	  // -------------------------
	    // ----------------
	    
	    @Autowired
		private UserRepo  urepo;
	    
	    public UserRecord usave(UserRecord u) {
	    	UserRecord u1=new UserRecord();
	    	u1.setEmail(u.getEmail());
	    	u1.setFirstname(u.getFirstname());
	    	u1.setLastname(u.getLastname());
	    	u1.setPassword(u.getPassword());
	    	urepo.save(u1);
	    	
	    	return null;
	    }
		
	    public UserRecord getu(Long id) {
	    	
	    	return urepo.findById(id).orElse(null);
	    	
	    }
	    
	    public List<UserRecord> getallu(){
	    	return urepo.findAll();
	    }
		public void update(Long id, Studentrecord dto) {
			// TODO Auto-generated method stub
			Studentrecord s = repo.findById(id).orElseThrow();
			s.setCourse(dto.getCourse());
			s.setEmail(dto.getEmail());
			s.setName(dto.getName());
			s.setQualification(dto.getQualification());
			repo.save(s);
			
		}
	    
	    
	  //  StudentDto update(Long id, StudentDto dto);
	  //  void delete(Long id);

}
