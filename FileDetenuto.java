import java.io.*;

class FileDetenuto
{
private String nomecognome;
private String fascicolo;
private int id;

    public FileDetenuto(String nomecognome, String fascicolo, int id) 
    {
        this.nomecognome = nomecognome;
        this.fascicolo = fascicolo;
        this.id = id;
    }
        @Override
        public String toString() 
        {
            return "Nome e Cognome del Detenuto: " + nomecognome + " \n-Codice Identificativo: " + id + " \n-Fascicolo: " + fascicolo ;
        }

       
       
    public String getFileNome() 
    {
    return nomecognome.toLowerCase() + ".txt";
    }

        
    
    public void salvaInFile() throws IOException 
    {
        String fileNome = getFileNome();
        try (FileWriter writer = new FileWriter(fileNome)) {
            writer.write(toString());
        }
    }


     public static void eliminaFile(String fileNome, String motivo) throws IOException 
     {
        File file = new File(fileNome);
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(fileNome, true)) {
                writer.write("\nDetenuto rimosso dalla banca dati. Motivo: " + motivo);
            }
        } else {
            System.out.println("Fascicolo non trovato.");
        }
    }


    public static void leggiFile(String fileNome) throws IOException {
        File file = new File(fileNome);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("Fascicolo non trovato.");
        }
    }

    
    
}
