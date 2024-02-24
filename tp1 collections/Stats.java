import java.util.ArrayList;
import java.util.Collections;

public class Stats {
public static Note meilleurnote (Etudiant e)
{
	return (Collections.max(e.notes));
}
public static float moyenne(Etudiant e) {
    float somme = 0;
    for (Note note : e.notes) {
        somme += note. getValue() ;
    }
    return somme / e.notes.size();
}
public static Note moinsBonneNote (Etudiant e) {
    return Collections.min(e.notes);
}

public static float moyenneGroupe(ArrayList<Etudiant> groupe) {
    float sommeMoyennes = 0;
    for (Etudiant etudiant : groupe) {
        sommeMoyennes += moyenne(etudiant);
    }
    return sommeMoyennes / groupe.size();
}
public static Etudiant meilleurEtudiant(ArrayList<Etudiant> groupe) {
    Etudiant meilleur = groupe.get(0);
    for (Etudiant etudiant : groupe) {
        if (moyenne(etudiant) > moyenne(meilleur)) {
            meilleur = etudiant;
        }
    }
    return meilleur;
} public static Etudiant moinsBonEtudiant(ArrayList<Etudiant> groupe) {
    Etudiant moinsBon = groupe.get(0);
    for (Etudiant etudiant : groupe) {
        if (moyenne(etudiant) < moyenne(moinsBon)) {
            moinsBon = etudiant;
        }
    }
    return moinsBon;

}}