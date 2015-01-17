package My_Package;

/**
 *Aceasta clasa "Monom" reprezinta structura de baza a polinomului.
 *Contine metode de setare si returnare a coeficientului si puterii.
 *Contine un constructor in care se instantiaza puterea si coeficientul.
 * @author Dorin
 * @version 1.0
 */

public class Monom {
    private double coef ,pow;
    /**
     * Constructorul clasei Monom
     * @param coef este coeficientul monomului
     * @param pow este puterea monomului
     */
    
    public Monom(double coef ,double pow){
        this.coef = coef;
        this.pow = pow;
    }
    /**
     * getCoef() returneaza coeficientul
     * @return coef coefcientul monomului
     */
    public double getCoef(){
        return coef;
    }
    /**
     * getPowf() returneaza puterea
     * @return pow puterea monomului
     */
    public double getPow(){
        return pow;
    }
    /**
     * setCoef() seteaza coeficientul
     * @param c valoarea noua a coeficientului
     */
    public void setCoef(double c){
        coef=c;
    }
    /**
     * setPow() seteaza puterea
     * @param c valoarea noua a puterii
     */
    public void setPow(double c){
        pow=c;
    }
}