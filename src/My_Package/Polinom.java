package My_Package;

/**
 *Clasa polinom reprezinta unitatea de baza a programului.
 *Contine o lista de Monoame, care formeaza polinomul propriu-zis
 *Contine doi constructori.
 *Contine metode de creare si prelucrare a polinoamelor:
 * -Scoaterea monoamelor din sirul introdus de utilizator
 * -Verifica corectitudinea datelor introduse
 * -Simplifica polinomu
 * -Sorteaza poinomul
 * -Inmulteste polinomul cu un scalar
 * ...
 * @author Dorin
 * @version 1.0
 */
import java.util.ArrayList;

public class Polinom {
    private ArrayList<Monom> Polinom = new ArrayList<Monom>();
    private String str;
    private int i = 0 ,c = 0, cond = 0;
    private double coefDouble = 0,powDouble = 0;
    
    /**
     * Constructor gol
     */
    public Polinom(){
    }
    /**
     * Constructorul de baza care primeste datele introduse de tilizator
     * in urma verificarii. Dupa carea apeleaza metoda de despartire a 
     * monoamelor.
     * @param str sirul introdus de utilizator
     */
    public Polinom(String str){
        this.str = str;
        this.split();
    }
    /**
     * Metoda care desface textul introdus de catre utilizator
     * in monoame care sunt adaugate in lista Polinom
     */
    public void split(){
        c = 0;
        coefDouble = 0;
        powDouble = 0;
        String coef = "" ,pow = "";
        
        while(i < str.length() && c == 0){
            if(str.substring(i ,i+1).equals("-") && coef.equals("")){
                coef = coef + "-";
                i++;
            }
            if(str.substring(i ,i+1).equals("+") && coef.equals("")){
                i++;
            }
            if("0123456789.".contains(str.substring(i ,i+1))){
                coef = coef + str.substring(i ,i+1);
                i++;}
            
            if(i < str.length() && !(coef.equals("")) && "+-".contains(str.substring(i ,i+1))){
                c = 3;
            }
            if((i < str.length() && str.substring(i ,i+1).equals("x"))){
                if(coef.equals("")){
                    coef = "1";
                }
                
                c = 1;
                pow = "1";
                i++;
            }
        }
        while(i < str.length() && c == 1){
            if(str.substring(i ,i+1).equals("^")){
                pow="";
                i++;
            }
            if("0123456789".contains(str.substring(i ,i+1)) && i < str.length()){
                pow = pow + str.substring(i ,i+1);
                i++;}
            
            if(i < str.length() && str.substring(i ,i+1).equals("+")) {
                i++;
                c = 0;
            }
            if(i < str.length() && str.substring(i ,i+1).equals("-")) {
                c = 0;
            }
            
        }
        
        if(coef.equals("-")){
            coef = "-1";
        }
        
        if(!coef.equals("")){
            coefDouble = Double.parseDouble(coef);
        }
        else coefDouble=0;
        if(!pow.equals("")){
            powDouble = Double.parseDouble(pow);
        }
        else powDouble = 0;
        Polinom.add( new Monom(coefDouble ,powDouble));
        
        if(i < str.length()){
            this.split();
        }
        this.simplify();
        this.sortare();
        
    }
    /**
     * Prelucrarea listei de monoame printr-o secventa de if-uri
     * si returneaza un sir care reprezinta metoda de
     * reprezentare a polinomului folosind caractere.
     * @return rez - sirul generat
     */
    public String afiseaza(){
        String rez="";
        for(Monom m : Polinom){
            
            if(m.getPow() == 0){
                if(m.getCoef() > 0 && m != Polinom.get(0)){
                    rez = rez + "+" + ((int)m.getCoef());
                }
                else{
                    rez= rez + ((int)m.getCoef());
                }
            }
            
            if(m.getPow() == 1){
                if(m.getCoef() > 0 && m != Polinom.get(0)){
                    if(m.getCoef() == 1){
                        rez = rez + "+x";
                    }
                    else{
                        if(m.getCoef() == -1){
                            rez = rez + "-x";
                        }
                    }
                    if(m.getCoef() != 1 && m.getCoef() != -1) {
                        rez = rez + "+" + ((int)m.getCoef()) + "x";
                    }
                }
                else{
                    
                    if(m.getCoef() == -1){
                        rez = rez + "-x";
                    }
                    else{
                        if(m.getCoef() == 1){
                            rez = rez + "x";
                        }
                        else{
                            rez = rez + ((int)m.getCoef()) + "x";
                        }
                    }
                }
                
            }
            
            if(m.getPow() != 0 && m.getPow() != 1){
                if(m.getCoef() > 0 && m != Polinom.get(0)){
                    if(m.getCoef() == 1){
                        rez = rez + "+" + "x^" + ((int)m.getPow());
                    }
                    else{
                        rez = rez + "+" + ((int)m.getCoef()) + "x^" + ((int)m.getPow());
                    }
                }
                else{
                    if(m.getCoef() == 1){
                        rez = rez + "x^" + ((int)m.getPow());
                    }
                    else{
                        if(m.getCoef() !=1 && m.getCoef() != -1){
                            rez = rez + ((int)m.getCoef()) + "x^" + ((int)m.getPow());
                        }
                        else{
                            rez = rez + "-x^" + ((int)m.getPow());
                        }
                    }
                    
                }
                
            }
        }
        return rez;
    }
    
    /**
     * Metoda afiseaza_r() este o particularizare a metodei afiseaza()
     * Aceasta ne returneaza la fel un sir care reprezinta afisarea
     * polinomului cu caractere, cu exceptia ca coeficientul este
     * real. In prealabil, acesta ese trunchiat la 2 cifre dupa virgula.
     * @return rez - sirul generat pentru a fi afisat.
     */
    public String afiseaza_r(){
        String rez = "";
        for(Monom m : Polinom){
            if(m.getPow() == 0){
                if(m.getCoef() > 0 && m != Polinom.get(0)){
                    rez = rez + "+" + (this.truncate(m.getCoef() ,3));
                }
                else{
                    rez = rez + (this.truncate(m.getCoef() ,3));
                }
            }
            
            if(m.getPow() == 1){
                if(m.getCoef() > 0 && m !=Polinom.get(0)){
                    if(m.getCoef() == 1){
                        rez = rez + "+x";
                    }
                    else{
                        if(m.getCoef() == -1){
                            rez = rez + "-x";
                        }
                    }
                    if(m.getCoef() != 1 && m.getCoef() != -1) {
                        rez = rez + "+"+(this.truncate(m.getCoef() ,3)) + "x";
                    }
                }
                else{
                    
                    if(m.getCoef() == -1){
                        rez = rez + "-x";
                    }
                    else{
                        if(m.getCoef() == 1){
                            rez = rez + "x";
                        }
                        else{
                            rez = rez + (this.truncate(m.getCoef() ,3)) + "x";
                        }
                    }
                }
                
            }
            
            if(m.getPow() != 0 && m.getPow() != 1){
                if(m.getCoef() > 0 && m !=Polinom.get(0)){
                    if(m.getCoef() == 1){
                        rez = rez + "+" + "x^" + ((int)m.getPow());
                    }
                    else{
                        rez = rez + "+" + (this.truncate(m.getCoef(),3)) + "x^" + ((int)m.getPow());
                    }
                }
                else{
                    if(m.getCoef() == 1){
                        rez = rez + "x^" + ((int)m.getPow());
                    }
                    else{
                        if(m.getCoef()!=1 && m.getCoef()!=-1){
                            rez = rez + (this.truncate(m.getCoef() ,3)) + "x^" + ((int)m.getPow());
                        }
                        else{
                            rez = rez + "-x^" + ((int)m.getPow());
                        }
                    }
                    
                }
                
            }
        }
        return rez;
    }

    /**
     * Returneaza monomul cu numarul de ordine dat de parametrul de intrare
     * @param i numarul de ordine a monomului
     * @return monomul dat
     */
    public Monom getMonom(int i){
        return Polinom.get(i);
    }
    /**
     * Inmultirea cu scalar a polinmului.
     * @param i -scalarul.
     */
    public void scalarMultiply(int i){
        for(Monom  m : Polinom){
            m.setCoef(i * m.getCoef());
        }
    }
    /**
     * Returneaza marimea polinomului
     * @return Polinom.size() -marimea data de metoda size()
     */
    public int getSize(){
        return Polinom.size();
    }
    /**
     * Creaza un numar de monoame cu coeficientul si puterea 0
     * numarul de monoame este dat de parametrul de intrare
     * @param i - numarul de monoame
     */
    public void setSize(int i){
        for(int j = 0; j < i - 1;j++){
            Polinom.add( new Monom(0 ,0));
        }
    }
    /**
     * Metoda de adaugare a monoamelor, pentru a adauga din exteriorul casei
     * @param coefDouble coeficientul pentru monomul nou
     * @param powdouble puterea pentru monomul nou
     */
    public void add(Double coefDouble,Double powdouble){
        Polinom.add( new Monom(coefDouble ,powDouble));
    }
    /**
     * Metoda de simpificare a polinomului.
     * In urma la secventa de instructiuni, polinomul este simplificat pentru
     * a evita prezenta a doua puteri egale intrun polinom.
     */
    public void simplify(){
        int a = 0 ,b = 0, c = 0;
        out:
        for(a = 0;a < Polinom.size();a++){
            if(c == 1){
                --a;
                c = 0;
            }
            for(b = a + 1;b < Polinom.size();b++){
                if(Polinom.get(a).getPow() == Polinom.get(b).getPow()){
                    Polinom.get(b).setCoef((Polinom.get(a).getCoef() + Polinom.get(b).getCoef()));
                    Polinom.remove(a);
                    c = 1;
                    continue out;
                }
                
            }
        }
        for(a = 0;a < Polinom.size();a++){
            if(Polinom.get(a).getCoef() == 0){
                Polinom.remove(a);
            }
        }
    }
    /**
     * Metoda de sortare.
     * Sorteaza polinomul utilizind algoritmul BubbleSort
     * Sortarea se face in baza puterii, descendent.
     */
    public void sortare(){
        int a = 0,b = 0;
        double auxCoef = 0,auxPow = 0;
        for(a = 0;a < Polinom.size() - 1;a++){
            for(b = 0;b < Polinom.size() - a - 1;b++){
                if(Polinom.get(b).getPow() < Polinom.get(b + 1).getPow()){
                    auxPow = Polinom.get(b).getPow();
                    auxCoef = Polinom.get(b).getCoef();
                    
                    Polinom.get(b).setPow(Polinom.get(b + 1).getPow());
                    Polinom.get(b).setCoef(Polinom.get(b + 1).getCoef());
                    
                    Polinom.get(b + 1).setPow(auxPow);
                    Polinom.get(b + 1).setCoef(auxCoef);
                    
                }
                
            }
            
        }
    }
    /**\
     * Metoda de trunchiere utilizata doar in cadrul clasei, pentru metoda de afisare
     * a coeficientilor reali.
     * @param value valoarea care urmeaza a fi trunchiata
     * @param places numarul de cifre dupa virgula
     * @return valoarea trunchiata
     */
    private static double truncate(double value ,int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        
        long factor = (long) Math.pow(10 ,places);
        value = value * factor;
        long tmp = (long) value;
        return (double) tmp / factor;
    }
    
    /**
     * Metoda utilizeaza o secventa de instrunctiuni pentru a verifica corectitudinea
     * introducerii a polinomului in GUI de catre utilizator, pentru a evita intrarea programului
     * in bucla.
     * @param s sirul dat de utilizator
     * @return valoare de true sau false
     */
    public boolean verificare(String s){
        int i = 0;
        
        for(i = 0;i < s.length();i++){
        	if(s.substring(0,1).equals("^")){
        		return false;
        	}
        	if(i < s.length() - 1 && s.substring(i+1 ,i+2).equals("^") && !s.substring(i ,i+1).equals("x")){
        		return false;
        	}
            if(!"+-0123456789x^".contains(s.substring(i ,i + 1))){
                return false;
            }
            if(("^+-".contains(s.substring(i ,i + 1))) && ("+-^".contains(s.substring(i + 1 ,i + 2)))){
                return false;
            }
            if(i < s.length() - 1 && s.substring(i ,i + 1).equals("x") && ("0123456789".contains(s.substring(i + 1,i + 2)))){
                return false;
            }
            if(i < s.length() - 1 && ("0123456789".contains(s.substring(i ,i + 1)) && s.substring(i + 1 ,i + 2).equals("^"))){
                return false;
            }
            if(i < s.length() - 1 && ("x^".contains(s.substring(i ,i + 1))) && s.substring(i + 1 ,i + 2).equals("x")){
                return false;
            }
            if(!"0123456789x".contains(s.substring(s.length() - 1 ,s.length()))){
                return false;
            }
            
            if(i < s.length() - 1 && "x".equals(s.substring(i ,i + 1)) && "0123456789".contains(s.substring(i + 1 ,i + 2)))
            {
                return false;
            }
        }
        
        return true;
    }
}