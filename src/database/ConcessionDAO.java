package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Metier.Voiture;

public class ConcessionDAO {
	private BDD database;
	
	public ConcessionDAO() {
		this.database = new BDD();
	}
	
	public Voiture insertionVoiture(String marque, String model) throws SQLException {
		HashMap<Integer, String> datas = new HashMap<Integer, String>(); 
		datas.put(1, marque);
		datas.put(2, model);
		this.database.executeCudRequete("insert into voiture(marque, model) values (?,?)", datas);
		Voiture voiture = new Voiture();
		return voiture;
	}
	
	public ArrayList<Voiture> FindToutesVoiture() throws SQLException{
		String select = "Select * from voiture";
		ArrayList<Voiture> voitures = new ArrayList<Voiture>();
		ResultSet set = this.database.selectRequete(select);
		while(set.next())
        {
        	voitures.add(new Voiture(set.getInt("id"),set.getString("marque"), set.getString("model")));
        }
		return voitures;
	}
	
	public void supprimerVoiture(int id) throws SQLException {
		ArrayList<Data> datas = new ArrayList<Data>(); 
		datas.add(new Data(1, "int", String.valueOf(id)));
		this.database.executeCudRequete("delete from voiture where id = ?", datas);
		
	}
}
