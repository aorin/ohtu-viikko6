package ohtu;

import javax.swing.JTextField;

public class Nollaa extends KenttiaKayttavaToiminto implements Komento {

    private Sovelluslogiikka sovellus;
    private int edellinenArvo;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta);
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenArvo = syoteKentanArvo();
        tuloskenttaanArvo(0);
    }

    @Override
    public void peru() {
        tuloskenttaanArvo(edellinenArvo);
    }
}
