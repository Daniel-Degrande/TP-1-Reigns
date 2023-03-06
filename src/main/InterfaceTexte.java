package main;

import java.util.Scanner;

public class InterfaceTexte {


    private Scanner fluxIn;
    InterfaceTexte(){
        fluxIn = new Scanner(System.in);
    }

    public String saisieTexteLibre(String question){
        System.out.println(question);
        System.out.flush();
        String res = fluxIn.nextLine();
        return res;
    }
}
