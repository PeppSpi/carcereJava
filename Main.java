import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
 {
    public static void main(String[] args) throws IOException 
    {
        Scanner scanner = new Scanner(System.in);
        int scelta;

            do {
                System.out.println(" ----- Gestione Detenuti Pollena Trocchia -----");
                System.out.println("1. Aggiungi Detenuto");
                System.out.println("2. Rimuovi Detenuto");                
                System.out.println("3. Cerca Fascicolo Detenuto");
                System.out.println("4. Esci Dalla Gestione");
                System.out.print("Scegli un'opzione: ");
                    try{          
                        scelta = scanner.nextInt(); 
                        scanner.nextLine();
                        }
                    catch(InputMismatchException e)
                        {
                            scanner.nextLine();
                            scelta = -1;
                        } 
                            pulisci.clearScreen();                            
                                if (scelta >= 1 && scelta <=3)
                                {
                                    switch (scelta)
                                    {
                                        case 1: ManagmentDetenuto.aggiungiDetenuto(scanner, scanner);
                                                break;
                                        
                                        case 2: ManagmentDetenuto.eliminaDetenuto(scanner, scanner);
                                                break;

                                        case 3: ManagmentDetenuto.leggiDetenuto(scanner, scanner);
                                                break; 
                                    }                                                
                                } else {System.out.println("Scegli un'operazione valida");}
                            }while(scelta != 4);
                    
        System.out.println("Grazie per aver utilizzato il carcere di Pollena Trocchia, spero verrai arrestato presto!");
        scanner.close();         
    
    }
}    

