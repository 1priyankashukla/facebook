package edu.iiitb.facebook.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.facebook.action.placeAction;
import edu.iiitb.facebook.util.DB;

public class addPlaceDAO {

	public static int insertPlace(String whereto,String address,String from,String when,String story,int profileId) {
		String insertSQL = "insert into  placeMovement"
				+ "(whereTo, address, story, date, fromPlace, profileId) " + "values('" + whereto
				+ "', '" + address + "', '" + story + "', '" + when + 
				"', '" + from + "',"+profileId+");";
		System.out.println(insertSQL);
		return DB.update(insertSQL);
	}
	
	
	public static ArrayList<placeAction> getPlaces(int profileId) {
		ArrayList<placeAction> placesList = new ArrayList<placeAction>();
		ResultSet resultSet = null;
		String query = "select WhereTo, address, fromPlace from placeMovement where profileId="+profileId+";";
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				placeAction place=new placeAction();
				place.setWhereto(resultSet.getString("WhereTo"));
				place.setAddress(resultSet.getString("address"));
				place.setFrom(resultSet.getString("fromPlace"));
				placesList.add(place);
			}
		} catch (SQLException e) {
           
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return placesList;
	}


}
