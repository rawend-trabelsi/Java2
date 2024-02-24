import java.util.ArrayList;
public class Etudiant implements Statisticable {
	private int matricule;
	 private String nom;
	 public ArrayList<Note> notes;
public Etudiant(int matricule, String nom) {
     this.matricule = matricule;
     this.nom = nom;
     this.notes = new ArrayList<>();
 }

 public void addNote(String intituleCours, float note) {
     Note nouvelleNote = new Note(intituleCours, note);
     notes.add(nouvelleNote);
 }







public int getMatricule() {
	return matricule;
}

public ArrayList<Note> getNotes() {
	return notes;
}

@Override
public float getValue() {
	
	float somme = 0;
    for (Note note : notes) {
        somme += note.getNote();
    }
	return somme;
}

public String getNom() {
	return this.nom = nom;
}

@Override
public String toString() {
	return "Etudiant [matricule=" + matricule + ", nom=" + nom + ", notes=" + notes + "]";
}}