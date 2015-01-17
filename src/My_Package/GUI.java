package My_Package;

/**
*Clasa GUI creaza interfata de interactiune intre utilizator si program.
*Contine doua spatii pentru introducerea polinoamelor,
*cu exemple de introducere a acestora
*Un Box pentru alegerea operatiei dorite
*Un spatiu pentru afisarea rezultatului
*Si Informatii despre fiecare componenta
* @version 1.0
* @author Dorin
* @date 10 martie 2014
*/

public class GUI extends javax.swing.JFrame {
    
    /**
     * Creates new form GUI
     */
    public Polinom p;
    public Polinom q;
    public Polinom p1=new Polinom();
    public Polinom q1=new Polinom();
    final private Procesor proc=new Procesor();
    /**
     * Constructorul clasei GUI care initializeaza cmponentele
     * print metoda initComponents()
     */
    public GUI() {
        initComponents();
    }
    
    /**
     *Aceasta metoda initializeaza toate componentele ferestrei, si o face vizibila.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelPolinom3 = new javax.swing.JLabel();
        labelRez1 = new javax.swing.JLabel();
        labelOperatii1 = new javax.swing.JLabel();
        textFieldPolinom2 = new javax.swing.JTextField();
        boxOperatii1 = new javax.swing.JComboBox();
        labelPolinom4 = new javax.swing.JLabel();
        Rezultat = new javax.swing.JLabel();
        textFieldPolinom1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(160, 160, 250));

        labelPolinom3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelPolinom3.setText("Polinomul P");

        labelRez1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelRez1.setText("Rezultatul:");

        labelOperatii1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelOperatii1.setText("Operatii disponibile:");

        textFieldPolinom2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        textFieldPolinom2.setText("Exemplu:  2x^2-x+23");
        textFieldPolinom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldPolinom2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textFieldPolinom2MouseExited(evt);
            }
        });
        textFieldPolinom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPolinom2ActionPerformed(evt);
            }
        });

        boxOperatii1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        boxOperatii1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adunare", "Scadere", "Inmultire", "Integrala P", "Derivata P", "Integrala Q", "Derivata Q" }));
        boxOperatii1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxOperatii1ActionPerformed(evt);
            }
        });

        labelPolinom4.setBackground(new java.awt.Color(204, 204, 255));
        labelPolinom4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelPolinom4.setText("Polinomul Q");

        Rezultat.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        textFieldPolinom1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        textFieldPolinom1.setText("Exemplu:  2x^2-x+23");
        textFieldPolinom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldPolinom1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textFieldPolinom1MouseExited(evt);
            }
        });
        textFieldPolinom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPolinom1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rezultat, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRez1)
                            .addComponent(labelPolinom4))
                        .addGap(0, 173, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldPolinom2)
                            .addComponent(labelPolinom3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPolinom1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                        .addGap(18, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelOperatii1)
                            .addComponent(boxOperatii1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOperatii1)
                    .addComponent(labelPolinom3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxOperatii1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPolinom1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(labelPolinom4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldPolinom2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(labelRez1)
                .addGap(18, 18, 18)
                .addComponent(Rezultat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    
    /**
     * Metoda apeleaza operatiile alese de utilizator in urma la accesarea boxului 
     * @param evt - alegerea unei operatii
     */
    private void boxOperatii1ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String itemText = (String)boxOperatii1.getSelectedItem( );
        if(itemText.equals("Inmultire") && p1.verificare(textFieldPolinom1.getText())
                && q1.verificare(textFieldPolinom2.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
            Rezultat.setText(proc.multiply(p ,q).afiseaza());
        }
        if(itemText.equals("Adunare") && p1.verificare(textFieldPolinom1.getText())
                && q1.verificare(textFieldPolinom2.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
            Rezultat.setText(proc.add(p ,q).afiseaza());
        }
        if(itemText.equals("Scadere")&& p1.verificare(textFieldPolinom1.getText())
                && q1.verificare(textFieldPolinom2.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
            Rezultat.setText(proc.substract(p ,q).afiseaza());
        }
        if(itemText.equals("Derivata P") && p1.verificare(textFieldPolinom1.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
            Rezultat.setText(proc.derive(p).afiseaza());
           
        }
        if(itemText.equals("Derivata Q")&& p1.verificare(textFieldPolinom2.getText())){
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
            Rezultat.setText(proc.derive(q).afiseaza());
        }
        if(itemText.equals("Integrala Q") && p1.verificare(textFieldPolinom2.getText())){
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
            Rezultat.setText(proc.integrate(q).afiseaza_r());
        }
        if(itemText.equals("Integrala P")&& p1.verificare(textFieldPolinom1.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
            Rezultat.setText(proc.integrate(p).afiseaza_r());
        }
        
    }                                            
    /**
     * Metoda primeste polinomul nr.1 introdus de utilizator in spatiul rezervat, si 
     * verifica corectitudinea acestuia
     * @param evt - accesarea spatiului
     */
    private void textFieldPolinom1ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
        if(p1.verificare(textFieldPolinom1.getText())){
            p = new Polinom(textFieldPolinom1.getText());
            p.split();
        }
        else{
            Eroare error = new Eroare();
            error.run();
        }
    }                                                 
    /**
     * Metoda primeste polinomul nr.2 introdus de utilizator in spatiul rezervat, si 
     * verifica corectitudinea acestuia
     * @param evt - accesarea spatiului
     */
    private void textFieldPolinom2ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
        if(q1.verificare(textFieldPolinom2.getText())){
            q = new Polinom(textFieldPolinom2.getText());
            q.split();
        }
        else{
            Eroare error = new Eroare();
            error.run();
        }
    }                                                 
    /**
     * Dispatitia exemplului la click peste spatiul de introducere a polinomului nr.1
     * @param evt Click cu mouse-ul peste spatiul de text
     */
    private void textFieldPolinom1MouseClicked(java.awt.event.MouseEvent evt) {                                               
        if(textFieldPolinom1.getText().equals("Exemplu:  2x^2-x+23")){
            textFieldPolinom1.setText("");
        }
    }                                              
    /**
     * Dispatitia exemplului la click peste spatiul de introducere a polinomului nr.2
     * @param evt Click cu mouse-ul peste spatiul de text
     */
    private void textFieldPolinom2MouseClicked(java.awt.event.MouseEvent evt) {                                               
        if(textFieldPolinom2.getText().equals("Exemplu:  2x^2-x+23")){
            textFieldPolinom2.setText("");
        }
    }                                              
    /**
     * Afiseaza exemplul daca iese mouse-ul din spatiul de introducere a polinomului nr.1
     * si citirea polinomului de catre utilizator in cazul in care spatiu nu este gol.
     * @param evt iesirea mouse-ului din spatiul de introducere a polinomului
     */ 
    private void textFieldPolinom1MouseExited(java.awt.event.MouseEvent evt) {                                              
        if(textFieldPolinom1.getText().equals("")){
            textFieldPolinom1.setText("Exemplu:  2x^2-x+23");
        }
        else{
            if(p1.verificare(textFieldPolinom1.getText())){
                p = new Polinom(textFieldPolinom1.getText());
                p.split();
            }
            else{
                if(!textFieldPolinom1.getText().equals("Exemplu:  2x^2-x+23")){
                    Eroare error = new Eroare();
                    error.run();
                }
            }
        }
    }                                             
    /**
     * Afiseaza exemplul daca iese mouse-ul din spatiul de introducere a polinomului nr.2
     * si citirea polinomului de catre utilizator in cazul in care spatiu nu este gol.
     * @param evt iesirea mouse-ului din spatiul de introducere a polinomului
     */ 
    private void textFieldPolinom2MouseExited(java.awt.event.MouseEvent evt) {                                              
        if(textFieldPolinom2.getText().equals("")){
            textFieldPolinom2.setText("Exemplu:  2x^2-x+23");
        }
        else{
            if(q1.verificare(textFieldPolinom2.getText())){
                q = new Polinom(textFieldPolinom2.getText());
                q.split();
            }
            else{
                if(!textFieldPolinom2.getText().equals("Exemplu:  2x^2-x+23")){
                    Eroare error = new Eroare();
                    error.run();
                }
            }
        }
    }                                             
    
    /**
     * Initializeaza interfata grafica si arunca exceptii in urma 
     * unor blocuri try-catch
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel Rezultat;
    private javax.swing.JComboBox boxOperatii1;
    private javax.swing.JLabel labelOperatii1;
    private javax.swing.JLabel labelPolinom3;
    private javax.swing.JLabel labelPolinom4;
    private javax.swing.JLabel labelRez1;
    private javax.swing.JTextField textFieldPolinom1;
    private javax.swing.JTextField textFieldPolinom2;
    // End of variables declaration                   
}
