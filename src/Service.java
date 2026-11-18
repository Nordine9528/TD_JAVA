import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Service extends Thread {

    private String nom;
    private FileWriter fileWriter;

    public Service(String nom) {
        this.nom = nom;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void run() {
        System.out.println("Bonjour, je suis le processus " + nom);

        Random random = new Random();
        int duree = 250 + random.nextInt(2251); //nb random entre 250 et 2500
        System.out.println("Mon traitement prendra " + duree + " milliseconde");

        try {
            Thread.sleep(duree);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Traitement interrompu");
        }

        synchronized (fileWriter) {
            try {
                fileWriter.write("Le " + nom + " a ecris ici" + "\n");
                fileWriter.flush(); // envois les données vers un fichier
            } catch (IOException e) {
                System.out.println("Erreur d'écriture : " + e.getMessage());
            }
        }

        System.out.println("Ici le processus " + nom + ", j'ai finis de travailler\n");
    }

    public String getNom() {
        return nom;
    }
}