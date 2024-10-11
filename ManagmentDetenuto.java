import java.io.*;
import java.util.Scanner;


public class ManagmentDetenuto 
{

    public static void aggiungiDetenuto(Scanner scanner, Scanner pausa) throws IOException 
    {    
        System.out.println("Nome e Cognome:");
        String nomecognome = scanner.nextLine();
        System.out.println("Fascicolo:");
        String fascicolo = scanner.nextLine();
        System.out.println("Codice Identificativo:");
        int id = scanner.nextInt();
        scanner.nextLine();
        FileDetenuto detenuto = new FileDetenuto(nomecognome, fascicolo, id);
        detenuto.salvaInFile();
        System.out.println("Detenuto salvato con successo nel carcere di Pollena Trocchia.");
        System.out.println("Stai per ritornare al menu principale...");
        pausa.nextLine();
        pulisci.clearScreen();
    }

    public static void eliminaDetenuto(Scanner scanner, Scanner pausa) throws IOException
     {
        
        pulisci.clearScreen();
        System.out.println("Inserisci il nome e cognome del detenuto da eliminare:");
        String nomecognome = scanner.nextLine();   
        System.out.println("Inserisci il motivo dell'eliminazione:");
        String motivo = scanner.nextLine();
        String fileNome = nomecognome.toLowerCase() + ".txt";
        File file = new File(fileNome);
        
        if (file.exists()) 
        {
                if (file.delete()) 
                {
                    System.out.println("Detenuto eliminato: " + fileNome + ". Motivo: " + motivo);
                    System.out.println("Stai per ritornare al menu principale.");
                    pausa.nextLine();
                    pulisci.clearScreen();
                } 
                else 
                {
                    System.out.println("Errore durante l'eliminazione del file.");
                    System.out.println("Stai per ritornare al menu principale.");
                    pausa.nextLine();
                    pulisci.clearScreen();
                }
        }
         else 
        {
            System.out.println("Detenuto non trovato.");
            System.out.println("Stai per ritornare al menu principale.");
            pausa.nextLine();
            pulisci.clearScreen();
        }
    }

    public static void leggiDetenuto(Scanner scanner, Scanner pausa) throws IOException 
    {
        pulisci.clearScreen();
        System.out.println("Inserisci il nome ed il cognome del detenuto:");
        String nomecognome = scanner.nextLine();
        String fileNome = nomecognome.toLowerCase() + ".txt";
        File file = new File(fileNome);
        
        if (file.exists()) 
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                pulisci.clearScreen();
                System.out.println("Profilo del detenuto " + nomecognome + ": ");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }pausa.nextLine();
                pulisci.clearScreen();
            }
        } 
        else 
        {
            System.out.println("Detenuto non trovato.");
            pausa.nextLine();
            pulisci.clearScreen();
        }
    }
    
}
