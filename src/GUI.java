import basis.*;
import javax.swing.JOptionPane;

public class GUI implements KnopfLauscher{
    private int x, n;
    private String p;
    private calc myCalc;
    private Knopf calculate;
    private TextFeld tFP, tFX;
    private ZahlenFeld zFN;
    public GUI(){
        Fenster win = new Fenster("Binomial Verteilung - rckp.me", 325, 180);

        Stift myPen = new Stift();
        myPen.bewegeBis(10,25);
        myPen.setzeSchriftGroesse(20);
        myPen.schreibeText("Binomial Verteilung - Bernoulli");
        myPen.setzeSchriftGroesse(15);

        myPen.bewegeBis(10,68);
        myPen.schreibeText("X: ");
        tFX = new TextFeld(30,50, 50,25);

        myPen.bewegeBis(10,108);
        myPen.schreibeText("n: ");
        zFN = new ZahlenFeld(30,90, 50,25);

        myPen.bewegeBis(10,148);
        myPen.schreibeText("p: ");
        tFP = new TextFeld(30,130, 50,25);

        calculate = new Knopf("Calc", 100,125,120,35);
        calculate.setzeKnopfLauscher(this);

    }


    public void bearbeiteKnopfDruck(Knopf knopf) {
        if (knopf==calculate){
            double sum=0;
            myCalc = new calc();
            String[] clip = tFX.text().split(",");



            //x = zFX.ganzZahl();
            p = tFP.text();
            n = zFN.ganzZahl();
            int i = 0;
            for (i = 0; i < clip.length; i++) {
                try {
                    x = Integer.parseInt(clip[i]);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, ("Geben Sie die Zahlen ohne Leerzeichen ein!"), "Fehler!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                double res = myCalc.bV((int)x, (String) p, (int) n);
                sum = sum + res;
                JOptionPane.showMessageDialog(null, ("Ergebnis "+(i+1)+": " + Double.toString(res)), "Ergebnis", JOptionPane.PLAIN_MESSAGE);

            }
            if (i>1){
                JOptionPane.showMessageDialog(null, ("Summe: " + Double.toString(sum)), "Summe", JOptionPane.PLAIN_MESSAGE);

            }

        }
    }
}
