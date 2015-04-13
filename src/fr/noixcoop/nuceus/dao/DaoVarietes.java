package fr.noixcoop.nuceus.dao;

import java.util.* ;
import java.sql.* ;

import fr.noixcoop.nuceus.metier.Variete;
import fr.noixcoop.nuceus.technique.ConnexionBD;

public class DaoVarietes implements IDaoVarietes {
	
	public List<Variete> consulter(){
		List<Variete> varietes = new ArrayList<Variete>() ;
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			Statement requete = connexion.createStatement() ;
			ResultSet resultat = requete.executeQuery("select libelle,aoc from VARIETE ;") ;
			while(resultat.next()){
				if(resultat.getInt("aoc") == 1){
					varietes.add(new Variete(resultat.getString("libelle"), true)) ;
				}
				else{
					varietes.add(new Variete(resultat.getString("libelle"), false)) ;
				}
			}
			resultat.close() ;
			requete.close() ;
		}
		catch(Exception e){
			System.out.println("Erreur dans DaoVarietes::consulter(String)...") ;
		}
		return varietes ;
	}
	
	public Variete consulter(String libelle){
		Variete variete = null ;
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			Statement requete = connexion.createStatement() ;
			ResultSet resultat = requete.executeQuery("select aoc from VARIETE where libelle='" + libelle + "';") ;
			if(resultat.next()){
				boolean aoc = false ;
				if(resultat.getInt("aoc") == 1){
					aoc = true ;
				}
				variete =  new Variete(libelle,aoc) ;
			}
			resultat.close() ;
			requete.close() ;
		}
		catch(Exception e){
			System.out.println("Erreur dans DaoVarietes::consulter(String)...") ;
		}
		return variete ;
	}
	
	public boolean ajouter(Variete variete){
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			Statement requete = connexion.createStatement() ;
			int nbTuples = 0 ;
			if(variete.isAoc() == true){
				nbTuples = requete.executeUpdate("INSERT INTO VARIETE VALUES ('" + variete.getLibelle() + "', '1') ;") ;
			}
			else {
				nbTuples = requete.executeUpdate("INSERT INTO VARIETE VALUES ('" + variete.getLibelle() + "', '0') ;") ;
			}
			requete.close() ;
			if(nbTuples == 1){
				return true ;
			}
			else {
				return false ;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage()) ;
			return false ;
		}
	}
	
	public boolean modifier(Variete variete){
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			// Votre code ici
			return true ;
		}
		catch(Exception e){
			System.out.println("Erreur dans DaoVarietes::modifier(Commune)...") ;
			return false ;
		}
	}
	
	public boolean supprimer(String libelle){
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			Statement requete = connexion.createStatement() ;
			int nbTuples = requete.executeUpdate("delete from VARIETE where libelle='" + libelle + "' ;") ;
			requete.close() ;
			if(nbTuples == 1){
				return true ;
			}
			else {
				return false ;
			}
		}
		catch(Exception e){
			System.out.println("Erreur dans DaoVarietes::supprimer(String)...") ;
			return false ;
		}
	}
	
	public boolean supprimer(Variete variete){
		Connection connexion = ConnexionBD.getConnexion() ;
		try {
			Statement requete = connexion.createStatement() ;
			int nbTuples = requete.executeUpdate("delete from VARIETE where libelle='" + variete.getLibelle() + "'"
					+ ", aoc='"+ variete.isAoc() +"' ;") ;
			requete.close() ;
			if(nbTuples == 1){
				return true ;
			}
			else {
				return false ;
			}
		}
		catch(Exception e){
			System.out.println("Erreur dans DaoVarietes::supprimer(String)...") ;
			return false ;
		}
	}
	
}
