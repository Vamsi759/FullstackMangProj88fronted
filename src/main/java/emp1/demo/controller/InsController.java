package emp1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emp1.demo.entity.Studentrecord;
import emp1.demo.entity.UserRecord;
import emp1.demo.entity.UserRecordLogin;
import emp1.demo.service.InsService;

@Controller
@RequestMapping("/ins")
public class InsController {

	@Autowired
	private InsService i;

	@GetMapping("home")
	public String listStudents(Model model) {
		model.addAttribute("studentrecords", i.getAll());
		

		return "home"; // students.html
	}

	@GetMapping("/add")
	public String add() {
		return "registration";
	}

	@GetMapping
	public String addap(Model model) {
		model.addAttribute("ins", i.getAll());
		List<Studentrecord> ap = i.getAll();
		

		return "registeredData";
	}

	@PostMapping("/add")
	public String save(@ModelAttribute Studentrecord s) {
		i.save(s);
		return "redirect:/ins/home";
	}

	// _______________________________-
	// ____________________________
	// _______________________________

	@PostMapping("/useradd")
	public String usersave(@ModelAttribute UserRecord us) {
		i.usave(us);
		return "home";
	}

	@GetMapping("/openusersignup")
	public String editStudents(Model model) {

		return "usersignup";
	}

	@GetMapping("/openuserlogin")
	public String openuserlogin() {

		return "userlogin";
	}

	@PostMapping("userloginrecord")
	public String denap(@ModelAttribute UserRecordLogin us) {
		String mail = us.getEmail();
		String pass = us.getPassword();

		List<UserRecord> ap = i.getallu();
		int r = 0;
		if (us.getEmail().equals("admin@admin") && us.getPassword().equals("admin")) {
			return "adminhome";
		}
		for (int i = 0; i < ap.size(); i++) {
			UserRecord rp = ap.get(i);
			if (rp.getEmail().equals(mail) && rp.getPassword().equals(pass)) {
				return "loginsucesshome";
			}
		}

		return "loginfail";
	}

	@GetMapping("/adminhomedata")
	public String adminhoomedata(Model model) {
		model.addAttribute("studentrecords", i.getAll());

		return "adminregistereddata";

	}

	@GetMapping("/openstudentrecordedit")
	public String studentrecordedit() {

		return "studentrecordeditpage";

	}
	
	 @GetMapping("/openstudentrecordedit/{id}")
	    public String studentrecordedit(@PathVariable Long id, Model model) {
	        model.addAttribute("student", i.get(id));
	        return "studentrecordeditpage";
	    }
	 
	 @PostMapping("/editstudentrecord/{id}")
	    public String update(@PathVariable Long id,
	    		Model model,
	    		@ModelAttribute Studentrecord dto) {
		 model.addAttribute("studentrecords", i.getAll());
			
	    	i.update(id, dto);
	    	return "adminregistereddata";
	    }
	    

    @GetMapping("/deletestudentrecord/{id}")
    public String deleteStudent(@PathVariable Long id,Model model) {
    	i.delete(id);
    	model.addAttribute("studentrecords", i.getAll());
		return "adminregistereddata";
    }

//	@DeleteMapping("/deletestudentrecord")
//	public String deletestudentrecord(@PathVariable Long id) {
//
//		
//
//		i.delete(id);
//		return "adminregistereddata";
//
//	}

	// ---------

}
