package Manishonetoonemapping;

import Manishonetoonemapping.Entity.Gender;
import Manishonetoonemapping.Entity.User;
import Manishonetoonemapping.Entity.UserProfile;
import Manishonetoonemapping.Repository.UserProfileRepository;
import Manishonetoonemapping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Manish");
		user.setEmail("Manish@gmail.com");


		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Thankot");
		userProfile.setBirthOfDate(LocalDate.of(2000, 10, 27));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("9860558459");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);


	}
}
