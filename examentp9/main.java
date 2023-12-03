
public class main {

	public static void main(String[] args) {
    Epreuve epreuve = new Epreuve("Épreuve 1", 3);

    Candidat candidat1 = new Candidat(1, "Candidat 1");
    Candidat candidat2 = new Candidat(2, "Candidat 2");
    Candidat candidat3 = new Candidat(3, "Candidat 3");

    epreuve.ajoutCandidat(candidat1);
    epreuve.ajoutCandidat(candidat2);
    epreuve.ajoutCandidat(candidat3);

    ResultatOral resultatOral1 = new ResultatOral('A');
    ResultatOral resultatOral2 = new ResultatOral('B');
    ResultatPoints resultatPoints3 = new ResultatPoints(90);

    try {
        epreuve.fixeResultat(1, resultatOral1);
        epreuve.fixeResultat(2, resultatOral2);
        epreuve.fixeResultat(3, resultatPoints3);
    } catch (IllegalUpdateException e) {
        System.out.println("Erreur : " + e.getMessage());
    }

    epreuve.terminer();

    System.out.println(epreuve);

    Resultat record = epreuve.getRecord();
    System.out.println("Meilleur résultat réalisé par les participants : " + record);

    Candidat vainqueur = epreuve.getVainqueur();
    System.out.println("Vainqueur : " + vainqueur.getNon());
}


	}


