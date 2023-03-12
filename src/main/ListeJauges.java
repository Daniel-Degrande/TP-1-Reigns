package main;

import main.Jauge;
import main.TypeJauge;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

import static main.Jauge.valInitJauge;

public class ListeJauges {

    private Map<TypeJauge, Jauge> liste;


    static private final Map<TypeJauge,String> types = Map.of(
            TypeJauge.ARMEE,"Armee",
            TypeJauge.CLERGE,"Clerge",
            TypeJauge.FINANCE,"Finance",
            TypeJauge.PEUPLE,"Peuple"
    );

    public static Map<TypeJauge,String> getNomTypeJauge(){
        return types;
    }

    public ListeJauges(){
        this.liste = new TreeMap<TypeJauge, Jauge>();
        for(Map.Entry<TypeJauge,String> paire : types.entrySet()){
            TypeJauge type = paire.getKey();
            String nom = paire.getValue();
            this.liste.put(type,new Jauge(nom,valInitJauge(15,35)));
        }
    }

    public Jauge getJaugeSelonType(TypeJauge typeCible){
        return this.liste.get(typeCible);
    }

    public void afficherTout(){
        for(Map.Entry<TypeJauge,Jauge> paire : this.liste.entrySet()){
            Jauge la_jauge = paire.getValue();
            la_jauge.afficheJauge();
        }
    }

    public boolean uneJaugeEstDepassee(){
        boolean res = false;
        for(Map.Entry<TypeJauge,Jauge> paire : this.liste.entrySet()){
            Jauge la_jauge = paire.getValue();
            res = res || la_jauge.estDepassee();
        }
        return res;
    }

}
