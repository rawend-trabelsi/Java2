package tp6Ex2;

public class mainex2 {

    public static void main(String[] args) {
        boolean erreur = false;
        do {
            try {
                Authentification A = new Authentification();
                A.getUserLogin();
                A.getUserPwd();
                erreur = true;
            }
            catch (WrongInputLength e) {
                System.out.println("Erreur de taille : " + e.getMessage());
                erreur = false;
            }
            catch (WrongLoginException e) {
                System.out.println("Erreur login : " + e.getMessage());
                erreur = false;
            } catch (WrongPwdException e) {
                System.out.println("Erreur mot de passe : " + e.getMessage());
                erreur = true;
            } 
        } while (!erreur);
    }
}
