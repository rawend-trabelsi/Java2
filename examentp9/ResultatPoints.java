public class ResultatPoints implements Resultat {
    private int points;

    public ResultatPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }

    @Override
    public int compareTo(Resultat r) {
        if (!(r instanceof ResultatPoints)) {
            throw new IllegalArgumentException("Type de résultat incompatible");
        }

        ResultatPoints autreResultatPoints = (ResultatPoints) r;

        return Integer.compare(this.points, autreResultatPoints.points);
    }
}
