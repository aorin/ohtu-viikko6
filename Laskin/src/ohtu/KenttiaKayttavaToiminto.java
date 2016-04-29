package ohtu;

import javax.swing.JTextField;

public abstract class KenttiaKayttavaToiminto {

    private JTextField tuloskentta, syotekentta;

    public KenttiaKayttavaToiminto(JTextField tuloskentta, JTextField syotekentta) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    int syoteKentanArvo() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }
    
    void tuloskenttaanArvo(int arvo) {
        syotekentta.setText("");
        tuloskentta.setText("" + arvo);
    }
}
