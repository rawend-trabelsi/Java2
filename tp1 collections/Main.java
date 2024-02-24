import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant(111, "rawend");
        etudiant1.addNote("Math", 15);
        etudiant1.addNote("Physique", 14);

        Etudiant etudiant2 = new Etudiant(122, "ranim");
        etudiant2.addNote("Math", 12);
        etudiant2.addNote("Physique", 15);

        Etudiant etudiant3 = new Etudiant(133, "loujain");
        etudiant3.addNote("Math", 18);
        etudiant3.addNote("Physique", 11);
        
        ArrayList<Etudiant> groupeEtudiants = new ArrayList<>();
        groupeEtudiants.add(etudiant1);
        groupeEtudiants.add(etudiant2);
        groupeEtudiants.add(etudiant3);
        Collections.sort(groupeEtudiants, new CompareMoyenne());
        System.out.println("Tri par moyenne : " + groupeEtudiants);

        Collections.sort(groupeEtudiants, new CompareNom());
        System.out.println("Tri par nom : " + groupeEtudiants);
        
        System.out.println("Meilleure note de l'étudiant 1 : " + Stats.meilleurnote(etudiant1));
        System.out.println("Moyenne de l'étudiant 2 : " + Stats.moyenne(etudiant2));
        System.out.println("Moins bonne note de l'étudiant 3 : " + Stats.moinsBonneNote(etudiant3));
        System.out.println("Moyenne du groupe : " + Stats.moyenneGroupe(groupeEtudiants));
        System.out.println("Meilleur étudiant du groupe : " + Stats.meilleurEtudiant(groupeEtudiants));
        System.out.println("Moins bon étudiant du groupe : " + Stats.moinsBonEtudiant(groupeEtudiants));
    }
}
