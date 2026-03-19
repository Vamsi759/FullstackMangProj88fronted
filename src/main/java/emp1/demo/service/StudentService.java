package emp1.demo.service;



import java.util.List;

import emp1.demo.StudentDto.StudentDto;

public interface StudentService {
	
	
    StudentDto save(StudentDto dto);
    StudentDto get(Long id);
    List<StudentDto> getAll();
    StudentDto update(Long id, StudentDto dto);
    void delete(Long id);
    
    
}
