package main;

public class Effet {
    private String nom;
    private String alias;
    private StrategieEffet action;

    public Effet(String nom, String alias,StrategieEffet strategie) {
        this.nom = nom;
        this.alias = alias;
        this.action = strategie;
    }
}
