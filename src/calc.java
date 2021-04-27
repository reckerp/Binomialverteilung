import javax.swing.JOptionPane;
public class calc {
    private int x;
    private double p;
    private int n;

    public calc(){}

    public double bV(int pX, String pP, int pN){
        x = pX;
        String[] clip = pP.split("/");
        p = (double)Integer.parseInt(clip[0]) / (double)Integer.parseInt(clip[1]);
        n = pN;
        double res = binomialVerteilung();
        return res;
    }
    public double binomialVerteilung(){
        long pD=0;
        try {
            pD = pascalscheDreieck(n, x);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ("\"X\" darf nicht über \"n\" liegen"), "Fehler!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        double result = (double) pD * ((double) Math.pow(p, x)) * ((double) Math.pow(1-p, n-x));
        return result;
    }

    private long pascalscheDreieck(int n, int k){ // Methode von DG1XPZ 
        long ret=0;
        long[][] pascalMatrix = new long[ n+1 ][ ];   //Anzahl der Zeilen
        for (int i=0; i<pascalMatrix.length;i++){
            pascalMatrix[ i ]=new long[pascalMatrix.length-i];   //Zeile i = i+1 Spalten
            pascalMatrix[ i ][ 0 ]=1;                                             // n-tes Feld der Spalte 0 mit 1en füllen
            pascalMatrix[ 0 ][ i ]=1;                                             // n-tes Feld der Zeile 0 mit 1en  füllen
        }
        for ( int j=0; j<(pascalMatrix.length-1); j++){
            for ( int i=0;i<(pascalMatrix[ j ].length-2);i++){
                pascalMatrix[ j+1 ][ i+1 ]=pascalMatrix[ j+1 ][ i ]+pascalMatrix[ j ][ i+1 ];
            }
        }
        ret=pascalMatrix[ n-k ][ k ];
        return ret;
    }
}
