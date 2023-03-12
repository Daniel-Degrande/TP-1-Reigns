package main;

abstract public class StrategieEffet {


    abstract void strategieEffet();

    abstract String afficherEffet();

    void appliquerEffet(){
        strategieEffet();
    }
}
