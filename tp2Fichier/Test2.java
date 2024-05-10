package tp2Fichier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {




	    public static void main(String[] args) {
	        try {
	          
	            BufferedReader reader = new BufferedReader(new FileReader("D:\\Fichier\\in.txt"));
	            Scanner scanner = new Scanner(System.in);
	            
	         
	            String line;
	            boolean authenticated = false;
	            while ((line = reader.readLine()) != null) {
	               
	                String[] parts = line.split("/");
	                if (parts.length == 2) {
	                   
	                    System.out.print("Entrez votre login : ");
	                    String login = scanner.nextLine();
	                    System.out.print("Entrez votre mot de passe : ");
	                    String password = scanner.nextLine();
	                    
	                  
	                    if (login.equals(parts[0]) && password.equals(parts[1])) {
	                        System.out.println("Authentification réussie.");
	                        authenticated = true;
	                        break;
	                    }
	                }
	            }
	            
	          
	            if (!authenticated) {
	                System.out.println("Problème d'authentification.");
	            }
	            
	            
	            reader.close();
	            scanner.close();
	            
	        } catch (IOException e) {
	            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
	        }
	    }
	}
