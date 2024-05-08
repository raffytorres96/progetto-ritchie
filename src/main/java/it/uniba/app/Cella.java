public class Cella
{
    static final char ICONA_CELLA_VUOTA='\u25A1';
    static final char ICONA_GIOCATORE1='\u26C0';
    static final char ICONA_GIOCATORE2='\u26C2';
    private int stato;
    /*
    lo stato sarà 0 se la cella è vuota, 1 se è presente una pedina del giocatore 1,
    2 se è presente una pedina del giocatore 2.
    */
    public Cella(){
        stato=0;
    }
    public int getStato(){
        return stato;
    }
    public char getIcona(){
        if(this.getStato()==1){
            return ICONA_GIOCATORE1;
        }
        else if(this.getStato()==2){
            return ICONA_GIOCATORE2;
        }
        else{
            return ICONA_CELLA_VUOTA;
        }
    }
    public void setStato(int s){
        try{
            if(s>=0 && s<=3){
                this.stato=s;
            }
            else{
                throw new ArithmeticException("Errore. Stato diverso da 0,1 o 2.");
            }
        }catch(Exception e){
            System.out.println("Errore nell'assegnazione di un nuovo stato alla cella.");
        }
    }
}
