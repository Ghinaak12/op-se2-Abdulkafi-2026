package business;

public class Volkshochschulkurs {
    private String kursname;
    private int kursbeitrag;
    private String wochentag;
    private float startuhrzeit;
    private String[] vorkenntnisse;

    public Volkshochschulkurs(String kursname, int kursbeitrag, String wochentag,
                              float startuhrzeit, String[] vorkenntnisse) {
        this.kursname = kursname;
        this.kursbeitrag = kursbeitrag;
        this.wochentag = wochentag;
        this.startuhrzeit = startuhrzeit;
        this.vorkenntnisse = vorkenntnisse;
    }

    public String getKursname() { return kursname; }
    public void setKursname(String kursname) { this.kursname = kursname; }

    public int getKursbeitrag() { return kursbeitrag; }
    public void setKursbeitrag(int kursbeitrag) { this.kursbeitrag = kursbeitrag; }

    public String getWochentag() { return wochentag; }
    public void setWochentag(String wochentag) { this.wochentag = wochentag; }

    public float getStartuhrzeit() { return startuhrzeit; }
    public void setStartuhrzeit(float startuhrzeit) { this.startuhrzeit = startuhrzeit; }

    public String[] getVorkenntnisse() { return vorkenntnisse; }
    public void setVorkenntnisse(String[] vorkenntnisse) { this.vorkenntnisse = vorkenntnisse; }

    public String getVorkenntnisseAlsString(char trenner) {
        if (vorkenntnisse == null || vorkenntnisse.length == 0) return "";
        StringBuilder ergebnis = new StringBuilder();
        for (int i = 0; i < vorkenntnisse.length; i++) {
            if (i > 0) ergebnis.append(trenner);
            ergebnis.append(vorkenntnisse[i]);
        }
        return ergebnis.toString();
    }

    public String gibVolkshochschuleZurueck(char trenner) {
        return kursname + trenner
                + kursbeitrag + trenner
                + wochentag + trenner
                + startuhrzeit + trenner + "\n"
                + getVorkenntnisseAlsString(trenner) + "\n";
    }
}
