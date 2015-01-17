package My_Package;
/**
 * Interfata "Operatii_binare_pe_polinoame"
 * impune operatiile care trebuie implementate
 * pentru lucrul cu polinoamele
 * @author Dorin
 * @version 1.0
 */

public interface Operatii_binare_pe_polinoame {
	/**
	 * 
	 * @param p polinom 1
	 * @param q polinom 2
	 * @return rezultatul adunarii polinomului 1 si 2
	 */
    public Polinom add(Polinom p ,Polinom q);
	/**
	 * 
	 * @param p polinom 1
	 * @param q polinom 2
	 * @return rezultatul inmutirii polinomului 1 si 2
	 */
    public Polinom multiply(Polinom p ,Polinom q);
	/**
	 * 
	 * @param p polinom 1
	 * @param q polinom 2
	 * @return rezultatul scaderii polinomului 1 si 2
	 */
    public Polinom substract(Polinom p ,Polinom q);
	/**
	 * 
	 * @param p polinom 1 
	 * @param q polinom 2
	 * @return rezultatul impartirii polinomului 1 si 2
	 */
    public Polinom divide(Polinom p ,Polinom q);
	/**
	 * 
	 * @param p polinomul supus derivarii
	 * @return rezultatul 
	 */
    public Polinom derive(Polinom p);
	/**
	 * 
	 * @param p polinomul  supus integrarii
	 * @return rezultatul 
	 */
    public Polinom integrate(Polinom p);
}
