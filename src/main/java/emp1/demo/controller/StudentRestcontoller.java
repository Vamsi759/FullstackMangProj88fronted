package emp1.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.System.Logger;
import java.util.List;
import java.util.logging.LoggingPermission;

import emp1.demo.StudentDto.StudentDto;
import emp1.demo.service.StudentService;

@RestController 
//@CrossOrigin(origins = "${app.cors.allowed-origin}")
//@CrossOrigin(origins = "http://localhost:3000")

@CrossOrigin(origins = "*")

@RequestMapping("/api/students")
public class StudentRestcontoller {

    @Autowired
    private StudentService service;

    // --- CRUD Operations ---
    

    /**
     * READ - Get all students (equivalent to list() in the old controller)
     * GET /api/students
     * Returns: List<StudentDto>
     */
    
    @GetMapping
    public List<StudentDto> getAllStudents() {
        // Automatically converted to JSON by Spring
    	
    	//Logger.Info("getlsitisimplemented");
    	
        return service.getAll(); 
    }

    /**
     * READ - Get a single student by ID (equivalent to edit(id) form preparation)
     * GET /api/students/{id}
     * Returns: StudentDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto student = service.get(id);
        if (student == null) {
            // Returns 404 Not Found if the student does not exist
            return ResponseEntity.notFound().build(); 
        }
        // Returns 200 OK with the student data
        return ResponseEntity.ok(student);
    }

    /**
     * CREATE - Add a new student (equivalent to save() in the old controller)
     * POST /api/students
     * Request Body: StudentDto (JSON)
     * Returns: The created StudentDto (and a 201 Created status is typical, but 200 is fine here)
     */
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        // @RequestBody converts incoming JSON to StudentDto
        service.save(dto);
        // Return the saved object back
        return dto; 
    }

    /**
     * UPDATE - Update an existing student (equivalent to update() in the old controller)
     * PUT /api/students/{id} (or PATCH)
     * Request Body: StudentDto (JSON)
     * Returns: The updated StudentDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto dto) {
        // Implement logic to update the student with the given id
        service.update(id, dto); 
        // Returns 200 OK with the updated student data
        return ResponseEntity.ok(service.get(id)); 
    }

    /**
     * DELETE - Delete a student by ID (equivalent to delete() in the old controller)
     * DELETE /api/students/{id}
     * Returns: 204 No Content or 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.delete(id);
        // Returns 204 No Content to signify successful deletion with no body
        return ResponseEntity.noContent().build(); 
    }




    
}