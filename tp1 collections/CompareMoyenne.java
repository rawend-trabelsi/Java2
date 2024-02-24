import java.util.Comparator;

class CompareMoyenne implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant etudiant1, Etudiant etudiant2) {
        return Float.compare(etudiant1.getValue() , etudiant2.getValue() );
    }
}
