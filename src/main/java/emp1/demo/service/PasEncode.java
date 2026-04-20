package emp1.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasEncode {
	
	 
	 BCryptPasswordEncoder ap = new BCryptPasswordEncoder();

	 public String encp(String raw) {
		 return ap.encode(raw);
	 }
	 
	 public Boolean match(String newstr,String oldstr) {
		 return ap.matches(newstr,oldstr);
	 }
	/*
	 * 
	 * 
	 * 
	 <dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-crypto</artifactId>
    <version>6.0.0</version>
</dependency>
	 
	 */

}
/*

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {
    public static void main(String[] args) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "myPassword123";

        // Encrypt (Hash)
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        // Verify
        boolean isMatch = encoder.matches(rawPassword, encodedPassword);
        System.out.println("Password Match: " + isMatch);
    }
}
*/
