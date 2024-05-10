package tpfichier;

import java.io.*;
import static java.lang.System.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        
        out.println("Répertoire courant : " + System.getProperty("user.dir"));
        File rep = new File(".");
        out.println("Chemin relatif : " + rep.getPath());
        out.println("Chemin absolu : " + rep.getAbsolutePath());
        out.println("Chemin canonique : " + rep.getCanonicalPath());

        File[] roots = File.listRoots();
        for (File root : roots) {
            out.println("Racine : " + root);
        }

        File[] filesAndDirs = rep.listFiles();
        if (filesAndDirs != null) {
            out.println("\nListe des répertoires et fichiers dans le répertoire courant :");
            for (File element : filesAndDirs) {
                if (element.isDirectory()) {
                    out.print(element.getName() + "\t");
                    if (element.getName().length() < 8) out.print("\t");
                    out.println("<REP>");
                }
            }
            for (File element : filesAndDirs) {
                if (element.isFile()) {
                    out.print(element.getName() + "\t");
                    if (element.getName().length() < 8) out.print("\t");
                    out.printf("%tc", new Date(element.lastModified()));
                    out.printf("\t%10d octets\n", element.length());
                }
            }
        }

     
        out.println("Filtré des répertoires commençant par la lettre 'b'");
        for (File élément : rep.listFiles(new Filtre('b'))) {
            out.print(élément.getName() + "\t");
            if (élément.getName().length() < 8) out.print("\t");
            if (élément.isDirectory()) out.print("<REP>");
            out.printf("\t%tc", new Date(élément.lastModified()));
            out.printf("\t%5d octets\n", élément.length());
        }
    }
}