public class Epreuve {
    private String denomination;
    private int max;
    private int effectifs;
    private boolean etat;
    private Candidat[] candidats;

    public Epreuve(String denomination, int max) {
        this.denomination = denomination;
        this.max = max;
        this.candidats = new Candidat[max];
    }

    public void ajoutCandidat(Candidat c) {
        if (effectifs < max) {
            candidats[effectifs++] = c;
        } else {
            System.out.println("Impossible d'ajouter plus de candidats, la limite est atteinte.");
        }
    }

    public void terminer() {
        this.etat = true;
    }

    public boolean estTerminee() {
        return etat;
    }

    public Resultat getRecord() {
        Resultat record = candidats[0].getResultat();
        for (int i = 1; i < effectifs; i++) {
            if (candidats[i].getResultat().compareTo(record) > 0) {
                record = candidats[i].getResultat();
            }
        }
        return record;
    }

    public Candidat getVainqueur() {
        Resultat record = getRecord();
        for (int i = 0; i < effectifs; i++) {
            if (candidats[i].getResultat().compareTo(record) == 0) {
                return candidats[i];
            }
        }
        return null;
    }

    public void fixeResultat(int id, Resultat r) throws IllegalUpdateException {
        if (estTerminee()) {
            throw new IllegalUpdateException("Impossible de mettre à jour les résultats, l'épreuve est terminée.");
        }

        for (int i = 0; i < effectifs; i++) {
            if (candidats[i].getId() == id) {
                candidats[i].setResultat(r);
                return;
            }
        }
        System.out.println("Candidat non trouvé avec l'ID : " + id);
    }

    public Resultat getResultat(int id) {
        for (int i = 0; i < effectifs; i++) {
            if (candidats[i].getId() == id) {
                return candidats[i].getResultat();
            }
        }
        System.out.println("Candidat non trouvé avec l'ID : " + id);
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Epreuve : " + denomination + ", État : ");
        result.append(etat ? "Terminée" : "Non terminée").append("\n");

        for (int i = 0; i < effectifs; i++) {
            result.append("Candidat ").append(i + 1).append(": ").append(candidats[i].getNon()).append("\n");
        }

        return result.toString();
    }}