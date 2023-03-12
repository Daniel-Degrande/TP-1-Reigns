package main;

abstract public class StrategieEffet {
    protected static Personnage PERSO_CIBLE;

    abstract void strategieEffet();

    void appliquerEffet(){
        strategieEffet();
    }
}
