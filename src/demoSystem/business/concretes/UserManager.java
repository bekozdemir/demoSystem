package demoSystem.business.concretes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import demoSystem.business.abstracts.UserService;
import demoSystem.core.GoogleService;
import demoSystem.dataAccess.abstracts.UserDao;
import demoSystem.entities.concretes.User;

public class UserManager implements UserService{

	private boolean verificationEmail=true;
	private boolean googleEmail = false;
	private ArrayList<String> userEmails = new ArrayList<String>(); 
	private ArrayList<String> userPasswords = new ArrayList<String>();
	
	private UserDao userDao;
	private GoogleService googleService;
	
	
	public UserManager(UserDao userDao, GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService = googleService;
	}
	
	private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern  pattern = Pattern.compile(EMAIL_PATTERN);
	public static boolean isValidEmail(final String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
		
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakterden olu�mal�.");
			return;
		}else {
			userPasswords.add(user.getPassword());
		}
		
		if (user.getFirstName().length()<2 && user.getLastName().length()<2) {
			System.out.println("Ad/Soyad en az 2 karakterden olu�mal�d�r.");
			return;
		}
		if (!verificationEmail) {
			System.out.println("L�tfen e-mail adresinizi do�rulay�n�z.");
			return;
		}
		
		if (!isValidEmail(user.getEmail())) {
			System.out.println("Ge�erli bir e-mail adresi giriniz.");
			return;
		}
		
		if (userEmails.contains(user.getEmail())) {
			System.out.println("Bu e-mail adresi zaten kullan�mda.");
			return;
		}
		
		if (googleEmail) {
			googleService.registerToDb(user);	
		}
		
		
		this.userDao.add(user);
		userEmails.add(user.getEmail());
		
		System.out.println("Do�rulama maili " + user.getEmail() + " adresine g�nderildi.");
	}

	@Override
	public void login(String email, String password) {
		if (!userEmails.contains(email) || !userPasswords.contains(password)) {
			System.out.println("Kullan�c� ad�/�ifre ge�er�izdir.");
			return;
		}
		
		if (userEmails.contains(email) && userPasswords.contains(password)) {
			System.out.println("Ho�geldiniz. Kullan�c� :  " + email );
		}else {
			System.out.println("Kullan�c� ad�/�ifre ge�er�izdir.");
		}
		
		
	}

}
