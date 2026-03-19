package emp1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emp1.demo.StudentDto.StudentDto;
import emp1.demo.entity.Student;
import emp1.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public StudentDto save(StudentDto dto) {

		Student s = new Student();

		s.setCourse(dto.getCourse());
		s.setEmail(dto.getEmail());
		
		s.setName(dto.getName());

		repo.save(s);
		dto.setId(s.getId());
		return dto;

	}

	@Override
	public StudentDto get(Long id) {
		Student s = repo.findById(id).orElse(null);

		return new StudentDto(s.getId(), s.getName(), s.getCourse(), s.getEmail());
	}

	
	@Override
	public List<StudentDto> getAll() {
		return repo.findAll().stream().map(s -> new StudentDto(s.getId(), s.getName(), s.getCourse(), s.getEmail()))
				.toList();
	}

	
	
	@Override
	public StudentDto update(Long id, StudentDto dto) {
		Student s = repo.findById(id).orElseThrow();
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		s.setCourse(dto.getCourse());
		repo.save(s);
		dto.setId(id);
		return dto;
	}

	
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
	
}
