package main;

import java.util.Map;

import static main.Jauge.valInitJauge;

public class AlterationJauge extends StrategieEffet{
    private Map<TypeJauge,Integer> jaugesCibles;

    public AlterationJauge(Map<TypeJauge, Integer> jaugesCibles) {
        jaugesCibles = jaugesCibles;
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
}
