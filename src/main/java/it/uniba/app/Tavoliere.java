public class Tavoliere
{
    private static final char [] ETICHETTA_COLONNE = {'1','2','3','4','5','6','7'};
    private static final String ETICHETTA_RIGHE = "   A  B  C  D  E  F  G";
    private static final short N_RIGHE_COLONNE = 7;
    public Cella [][] tavoliere = new Cella [N_RIGHE_COLONNE][N_RIGHE_COLONNE];
    public Tavoliere(){
        for(int i=0;i<7;i++){
	        for(int j=0;j<7;j++){
                tavoliere[i][j]=new Cella();
	        }
	    }
    }
    public void stampaTavoliere(){
        System.out.println(ETICHETTA_RIGHE);
	    for(int i=0;i<7;i++){
            System.out.print(ETICHETTA_COLONNE[i]+"  ");
	        for(int j=0;j<7;j++){
	            System.out.print(tavoliere[i][j].getIcona()+"  ");
	        }
	        System.out.print(" "+ETICHETTA_COLONNE[i]);
	        System.out.println("");
	    }
	    System.out.println(ETICHETTA_RIGHE);
    }
}
