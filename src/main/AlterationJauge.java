package main;

import java.util.Map;

import static main.Jauge.valInitJauge;

public class AlterationJauge extends StrategieEffet{
    private Map<TypeJauge,Integer> jaugesCibles;

    static Personnage PERSO_CIBLE;

    public AlterationJauge(Map<TypeJauge, Integer> jaugesCibles) {
        this.jaugesCibles = jaugesCibles;
    }

    @Override
    void strategieEffet() {
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            TypeJauge type = paire.getKey();
            int valeur = paire.getValue();
            PERSO_CIBLE.getJaugeSelonType(type).incrementeValeur(valeur);
        }
        //super.PERSO_CIBLE.;
    }

    @Override
    String afficherEffet() {
        String res = "";
        for(Map.Entry<TypeJauge,Integer> paire : jaugesCibles.entrySet()){
            res += ListeJauges.getNomTypeJauge().get(paire.getKey()) + " : " + paire.getValue().toString() + " ; ";
        }
        return res;
    }
}
