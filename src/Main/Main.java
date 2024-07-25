package Main;

import Metier.Cars;
import Metier.Concession;
import repository.ConcessionRepository;
import repository.Vehicule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello World");

        Vehicule createdTable = new Vehicule();
        createdTable.createVehiculeTable();

        ConcessionRepository concessionRepo = new ConcessionRepository();
        concessionRepo.createConcessionTable();

        program();
    }

    public static void program() {
        boolean continuer = true;
        Concession concession = createConcession();

        while (continuer) {
            continuer = action(concession);
        }
    }

    public static void menu() {
        System.out.println("1. Afficher les véhicules dans la concession m2i");
        System.out.println("2. Ajouter une voiture à une concession");
        System.out.println("3. Créer un véhicule en base de données");
        System.out.println("4. Créer une concession");
        System.out.println("5. afficher les concession");
        System.out.println("7. Quitter");
    }

    public static int choix() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choix = 0;
        try {
            choix = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide.");
        }
        return choix;
    }

    public static boolean action(Concession concession) {
        menu();
        int choix = choix();
        switch (choix) {
            case 1:
                System.out.println("Liste des véhicules dans la concession");
                afficherListeVehicules();
                break;
            case 2:
                System.out.println("Ajouter une voiture à la concession");
                AddCarToConcession(concession);
                break;
            case 3:
                System.out.println("Créer un véhicule en base de données");
                createVehicule();
                break;
            case 4:
                System.out.println("Créer une nouvelle concession");

                AddConcession();
                break;
            case 5:
                System.out.println("Liste  concession");
                afficherConcession();
                break;
            case 7:
                System.out.println("Au revoir");
                return false;
            default:
                System.out.println("Choix invalide");
        }
        return true;
    }
public static void afficherConcession(){
        ConcessionRepository concessionRepo = new ConcessionRepository();
        concessionRepo.getAllConcessions();
}
    public static void afficherListeVehicules() {
        Vehicule vehiculeRepo = new Vehicule();
        vehiculeRepo.listeVehicule();
    }

    public static void createVehicule() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Entrez la marque du véhicule :");
            String brand = br.readLine();
            System.out.println("Entrez le modèle du véhicule :");
            String model = br.readLine();
            Cars newCar = new Cars(brand, model);
            Vehicule vehiculeRepo = new Vehicule();
            vehiculeRepo.AddVehicule(newCar);
            System.out.println("Véhicule créé avec succès :");
            System.out.println(newCar);
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }

    public static Concession createConcession() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Entrez le nom de la concession :");
            String raisonSocial = br.readLine();
            return new Concession(raisonSocial);
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
        return null;
    }

    public static void AddCarToConcession(Concession concession) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Entrez la marque du véhicule :");
            String brand = br.readLine();
            System.out.println("Entrez le modèle du véhicule :");
            String model = br.readLine();

            Cars newCar = new Cars(brand, model);
            ConcessionRepository concessionRepo = new ConcessionRepository();
            //concessionRepo.addConcession(new);
            //concession.addCars(newCar);

            System.out.println("Véhicule ajouté à la concession avec succès :");
            System.out.println(newCar);
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }

    public static void AddConcession() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            System.out.println("Entrez le nom de la concession :");
            String raisonSocial = br.readLine();


            Concession newConcession = new Concession(raisonSocial);
            System.out.println("objet cree conncesion" + newConcession);
            ConcessionRepository concessionRepo = new ConcessionRepository();
            concessionRepo.addConcession(newConcession);
            System.out.println("creation de concession en bdd" + newConcession);

            System.out.println("Véhicule ajouté à la concession avec succès :");
            System.out.println(newConcession);
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }
    public static void deleteConcession(Concession concession) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Entrez la marque du concession :");
            //String
        }catch(Exception e){
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }
}
