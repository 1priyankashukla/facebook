package edu.iiitb.facebook.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import edu.iiitb.facebook.util.DB;

public class EventDao {

	public static ArrayList<Event> getEventList(int id, String dt) {

		ArrayList<Event> eventPost = new ArrayList<Event>();
		Event ev;

		ResultSet resultSet = null;

		String query;

		query = "select startTime,eventPicId,eventName,location,Events.profileId,Events.eventId,rsvpStatusId,host from Events,EventMembership where Events.eventId=EventMembership.eventId and EventMembership.profileId="
				+ id + " and startTime like'" + dt.substring(0,10) + "%';";

		System.out.println("query for event    " + query);

		Connection connection;
		connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {

				ev = new Event();
				System.out.println("Event ID :  "
						+ resultSet.getInt("Events.eventId"));
				ev.setStartTime(resultSet.getString("startTime"));
				ev.setEventPicId(resultSet.getInt("eventPicId"));
				ev.setEventName(resultSet.getString("eventName"));
				ev.setLocation(resultSet.getString("location"));
				ev.setProfileEventID(resultSet.getInt("Events.eventId"));
				ev.setRsvpStatusId(resultSet.getInt("rsvpStatusId"));
				ev.setHost(resultSet.getString("host"));
				
				System.out.println(" checking startT    "+(ev.getStartTime()).substring(14,16));
				
				int hh;
				String a;
				
				hh=Integer.parseInt(ev.getStartTime().substring(11,13));
				String st;
						
									if(hh>12)
						{
							hh=hh-12;
							a="pm";
						}
						else a="am";
						
				
				
				
				st=Integer.toString(hh)+":"+ev.getStartTime().substring(14,16)+" "+a;
						
				System.out.println("st:     "+st);
				
				ev.setStartT(st);
				eventPost.add(ev);
				System.out.println("Event ID again check:  "
						+ ev.getProfileEventID());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return eventPost;

	}

}
