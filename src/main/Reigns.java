package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {

    private static int nbTours;

    /**
     * le personnage joué
     */
    private static Personnage personnage;

    /**
     * la banque de questions
     */
    private static BanqueQuestion questions;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        // début du jeu
        initialiser_partie();

        // tirage des questions, boucle principale (tours du jeu)
        boucle_jeu();

        // fin du jeu
        fin_partie();

    }

    private static void initialiser_partie(){
        System.out.println("Bienvenue sur Reigns");

        questions.initListe();

        System.out.println("Création du personnage...");

        Reigns.personnage = new Personnage();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        personnage.AfficheJauges();
    }

    private static void boucle_jeu(){
        int nbTours = 0;
        while(!personnage.finDuJeu()){
            nbTours++;
            Question question = questions.getQuestionAleatoire();
            reponseQuestion(question);
            personnage.AfficheJauges();
        }
    }

    private static void fin_partie(){
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");
    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        String reponse = "";

        // récupère la réponse

        reponse = (String)InterfaceTexte.reponseQCM("Entrez la réponse (G ou D)",
                Map.of(
                        "G","G",
                        "D","D"
                ),
                null  /*  On ne force pas de réponse, on repose la question j'usqu'à obtenir réusltat valide */ );

        // applique les malus
        if(reponse.equals("G")){
            question.appliqueEffetsGauche(personnage);
        }else{
            question.appliqueEffetsDroite(personnage);
        }
    }

    /*
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */


    /*
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */


    /*
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */

}