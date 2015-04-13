package fr.noixcoop.nuceus.logiqueMetier;

import java.util.* ;

import fr.noixcoop.nuceus.metier.Variete;
import fr.noixcoop.nuceus.dao.DaoVarietes;
import fr.noixcoop.nuceus.dao.IDaoVarietes;

public class MetierVarietes implements IMetierVarietes {
	
	private IDaoVarietes daoVarietes = new DaoVarietes() ;
	
	public IDaoVarietes getDaoVarietes(){
		return this.daoVarietes ;
	}
	
	public void setDaoVarietes(IDaoVarietes daoVarietes){
		this.daoVarietes = daoVarietes ;
	}
	
	public List<Variete> consulter(){
		return daoVarietes.consulter() ;
	}
	
	public Variete consulter(String libelle){
		return daoVarietes.consulter(libelle) ;
	}
	
	public boolean ajouter(Variete variete){
		return daoVarietes.ajouter(variete) ;
	}
	
	public boolean modifier(Variete variete){
		return daoVarietes.modifier(variete) ;
	}
	
	public boolean supprimer(String libelle){
		return daoVarietes.supprimer(libelle) ;
	}

	@Override
	public boolean supprimer(Variete variete) {
		// TODO Auto-generated method stub
		return false;
	}
	
}