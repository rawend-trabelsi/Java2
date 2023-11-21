package tp6Ex2;
import java.util.Scanner;

public class Authentification {
	final String LoginCorrect = "scott";
	final String PwdCorrect = "tiger";
	Scanner sc = new Scanner(System.in);

	public void getUserLogin() throws WrongInputLength,WrongLoginException {
		System.out.print("Login : ");
		String login = sc.nextLine();
		if (login.length() > 10) {
			throw new WrongInputLength("Login trop long");
		}
		if (!login.equals(LoginCorrect)) {
			throw new WrongLoginException("Login incorrect");
		}
		
	}

	public void getUserPwd() throws  WrongInputLength,WrongPwdException {
		System.out.print("Password : ");
		String pwd = sc.nextLine();
		if (pwd.length() > 10) {
			throw new WrongInputLength("Mot de passe trop long");
		}
		if (!pwd.equals(PwdCorrect)) {
			throw new WrongPwdException("Mot de passe incorrect");
		}
		
		}
	}

