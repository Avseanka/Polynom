package My_Package;
/**
 * Aceasta clasa implementeaza interfata Operatii_binare_pe_polinoame
 * si implementeaza metodele impuse de aceasca.
 * Operatiile implementate sun:
 * -Adunarea
 * -Scaderea
 * -Inmultirea
 * -Derivata
 * -Integrala
 * @author Dorin
 * @version 1.0
 */

public class Procesor implements Operatii_binare_pe_polinoame {
    private Monom m , n;
    private int i = 0 ,j = 0;
    /**
     * Constructor gol pentru initializarea obiectelor de tip procesor in alte clase.
     */
    public Procesor()
    {
    }

    /**
     * Adunarea a doua polinoame primite ca parametri, si returneaza rezultatul
     * ca obiect nou de tip Polinom.
     * @param p -primul polinom
     * @param q -polinomul 2
     * @return rez rezultatul adunarii
     */
    public Polinom add(Polinom p ,Polinom q){
        Polinom rez = new Polinom("");
        rez.setSize(p.getSize() + q.getSize() + 1);
        for(i = 0;i < p.getSize();i++){
            rez.getMonom(i).setCoef(p.getMonom(i).getCoef());
            rez.getMonom(i).setPow(p.getMonom(i).getPow());
        }
        for(int j = 0 ,i = p.getSize();i <( p.getSize() + q.getSize());i++,j++) {
            rez.getMonom(i).setCoef(q.getMonom(j).getCoef());
            rez.getMonom(i).setPow(q.getMonom(j).getPow());
        }
        
        rez.simplify();
        rez.sortare();
        return rez;
    }
    
    /**
     * Metoda neimplementata din interfata Opeatii_binare_pe_polinoame.
     */
    public Polinom divide(Polinom p ,Polinom q){
        Polinom rez = new Polinom("");
        
        return rez;
    }
    
    /**
     * Efectueaza scaderea polinomului 2 din polinomul 1
     * prin intermediul inmutirii polinomului 2 cu scalar (-1) 
     * si apelarea adunarii.
     * @param p polinomul 1
     * @param q polinomu 2
     * @return rez rezultatul scaderii
     */
    public Polinom substract(Polinom p ,Polinom q){
        Polinom rez = new Polinom("");
        q.scalarMultiply(-1);
        rez = this.add(p ,q);
        rez.simplify();
        rez.sortare();
        return rez;
    }
    /**
     * Efectueaza inmultirea a doua polinoame, aceasta se face prin
     * inmultirea fiecarui monom din polinomul 1 cu fiecare element
     * din polinomul 2.
     * @param p polinomul 1
     * @param q polinomu 2
     * @return rez rezultatul inmultirii
     */
    public Polinom multiply(Polinom p,Polinom q){
        int i = 0,j = 0,k = 0;
        Polinom rez = new Polinom("");
        rez.setSize((p.getSize() + 1)*(q.getSize() + 1)); //54
        
        for(i = 0;i < p.getSize();i++){
            for(j = 0;j < q.getSize();j++){
                rez.getMonom(k).setCoef(p.getMonom(i).getCoef() * q.getMonom(j).getCoef());
                rez.getMonom(k).setPow(p.getMonom(i).getPow() + q.getMonom(j).getPow());
                ++k;
            }
        }
        rez.simplify();
        rez.sortare();
        return rez;
    }
    
    /**
     * Derivata polinomului primit ca parametru.
     * @param p polinomul supus derivarii
     * @return rez polinomul derivat
     */
    public Polinom derive(Polinom p){
        Polinom rez = new Polinom("");
        rez.setSize(p.getSize()+1);
        for(int i=0;i<p.getSize();i++){
            if(p.getMonom(i).getPow() == 0){
                p.getMonom(i).setCoef(0);
            }
            else {
                rez.getMonom(i).setCoef(p.getMonom(i).getCoef()*p.getMonom(i).getPow());
                rez.getMonom(i).setPow(p.getMonom(i).getPow() - 1);
            }
        }
        
        rez.simplify();
        rez.sortare();
        return rez;
    }
    /**
     * Integreaza polinomul primit ca parametru
     * @param p polinomul supus integrarii
     * @return rez polinomul integrat
     */
    public Polinom integrate(Polinom p){
        Polinom rez = new Polinom("");
        rez.setSize(p.getSize() + 1);
        for(i = 0;i < p.getSize();i++){
            rez.getMonom(i).setCoef(p.getMonom(i).getCoef() / (p.getMonom(i).getPow() + 1));
            rez.getMonom(i).setPow(p.getMonom(i).getPow() + 1);
        }
        
        rez.simplify();
        rez.sortare();
        return rez;
    }
    
}
