package com.pmb.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.Contacts;


public class ContactDAO  implements IContactsDAO {

	

	public static final Logger logger = LogManager.getLogger("ContactsDAO");

	private DataBaseConfig dataBaseConfig = new DataBaseConfig();

	public Contacts Conctact_onnection (String email)  throws ClassNotFoundException, SQLException{

		Connection  con = dataBaseConfig.getConnection();
		
		Contacts contact = null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_CONTACTS);
				ps.setString(1, email);


				rs = ps.executeQuery();

				if (rs.next()){
					contact = new Contacts ();
					contact.setId(rs.getInt("id"));
					contact.setFirstName(contact.getFirstName());
					contact.setLastName(contact.getLastName());
					contact.setEmail(contact.getEmail());
					contact.setIban(contact.getIban());
					
				}

			} catch (SQLException e) {
				logger.error("An error occured : Contacts could not be found");

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}


		}
		return contact;

	}

	public boolean updateContacts (String  firstName, String lastName )  throws ClassNotFoundException, SQLException{

		Connection  con = dataBaseConfig.getConnection();
		boolean result = false;

		if (con!= null) {

			PreparedStatement ps = null;
		
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.UPDATE_CONTACTS);
				Contacts cont = new Contacts();
				ps.setString(1, firstName);
				ps.setString(2,lastName);
				ps.setString(3,new String(cont.getEmail()));
				ps.setString(5,new String(cont.getIban()) );
				
				
				// demander explication Guillian  : 
				result = (ps.executeUpdate() > 0);

			} catch (SQLException e) {
				logger.error("An error occured : User {}",firstName, lastName ,"could not be found");

			} finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			
		} 
		
		return result ;

	}
	
	public boolean addContact (Contacts contact) throws ClassNotFoundException, SQLException {
		
		Connection  con = dataBaseConfig.getConnection();
		boolean result = false;

		if (con!= null) {

			PreparedStatement ps = null;
		
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.ADD_CONTACT);
				Contacts cont = new Contacts();
				ps.setString(1,new String (cont.getFirstName()));
				ps.setString(2,new String (cont.getLastName()));
				ps.setString(3,new String(cont.getEmail()));
				ps.setString(5,new String(cont.getIban()) );
				
				
				// demander explication Guillian  : 
				result = (ps.executeUpdate() > 0);
				//Demander comment loggger le nom/prenom du contact
			} catch (SQLException e) {
				logger.error("Cannot Add Contact");

			} finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			
		} 
		
		return result ;
		
	}
	public boolean deleteContact (String firstName,String lastName)throws ClassNotFoundException, SQLException{
		
		Connection  con = dataBaseConfig.getConnection();
		boolean result = false;
		
		if (con!= null) {

			PreparedStatement ps = null;
		
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.DELETE_CONTACT);
				Contacts cont = new Contacts();
				ps.setString(1, cont.getFirstName());
				ps.setString(2, cont.getLastName());
				
				
				// demander explication Guillian  : 
				result = (ps.executeUpdate() > 0);
				//Demander comment loggger le nom/prenom du contact
			} catch (SQLException e) {
				logger.error("Cannot remove  {}", firstName,lastName );

			} finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			
		} 
		return result ;
	}
}
