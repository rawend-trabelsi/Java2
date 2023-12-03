public class ResultatOral implements Resultat {
    private char appreciation;

    public ResultatOral(char appreciation) {
        if (appreciation != 'A' && appreciation != 'B' && appreciation != 'C') {
            throw new IllegalArgumentException("Appreciation invalide");
        }
        this.appreciation = appreciation;
    }

    public char getAppreciation() {
        return appreciation;
    }

    @Override
    public String toString() {
        return String.valueOf(appreciation);
    }

    @Override
    public int compareTo(Resultat r) {
        if (!(r instanceof ResultatOral)) {
            throw new IllegalArgumentException("Type de résultat incompatible");
        }

        ResultatOral autreResultatOral = (ResultatOral) r;

        if (this.appreciation == autreResultatOral.appreciation) {
            return 0;
        } else if (this.appreciation < autreResultatOral.appreciation) {
            return 1;
        } else {
            return -1;
        }
    }
}
