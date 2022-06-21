package com.pmb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.Friend;

@Repository
public class FriendDAO  implements IFriendDAO {



	public static final Logger logger = LogManager.getLogger("ContactsDAO");
	private DataBaseConfig dataBaseConfig = new DataBaseConfig();



	public List<Friend> getFriendList (int idOwner)   {

		List<Friend> result = new ArrayList<>();

		Connection  con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con =dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.GET_FRIEND_LIST);
			ps.setInt(1, idOwner);

			rs = ps.executeQuery();

			while (rs.next()){
				Friend newcontact = new Friend ();
				newcontact.setId(rs.getInt("USR_ID"));
				newcontact.setEmail(rs.getString("USR_EMAIL"));
				newcontact.setFullName (rs.getString("USR_F_NAME") +" "+ rs.getString("USR_L_NAME"));

				result.add(newcontact);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("An error occured : Contacts could not be found");

		}
		finally {
			dataBaseConfig.closeResultSet(rs);
			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeConnection(con);
		}
		return result;
	}




	public boolean addContact ( int idOwner, int idReceiver )  {

		Connection  con = null;
		boolean result = false;

		PreparedStatement ps = null;
		
		try {
			con = dataBaseConfig.getConnection();
			//préparer la requète 
			ps = con.prepareStatement(DataBaseConstants.ADD_FRIEND);
			//édition des values dans la requète
			ps.setInt(1,idOwner);
			ps.setInt(2, idReceiver);

			result = (ps.execute());

		} catch (SQLException | ClassNotFoundException e) {
			logger.error(e);

		} finally {

			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeConnection(con);
		}

		return result ;
	}

	public boolean deleteContact (int idOwner, int idReceiver) {


		Connection  con = null;
		boolean result = false;
		PreparedStatement ps = null;


		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.DELETE_FRIEND);

			ps.setInt(1,idOwner);
			ps.setInt(2, idReceiver);

			result = (ps.execute());

		} catch (SQLException | ClassNotFoundException e) {
			logger.error(e);

		} finally {

			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeConnection(con);
		}

		return result ;
	}

	public boolean verify (int idOwner, int idReceiver) {
		boolean result = false;
		Connection  con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con =dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.VERIFY);
			ps.setInt(1, idOwner);
			ps.setInt(2, idReceiver);

			rs = ps.executeQuery();

			if (rs.next()){
		
				result = true;
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("An error occured : Contacts could not be found");

		}
		finally {
			dataBaseConfig.closeResultSet(rs);
			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeConnection(con);
		}
		return result;
	}

	
	
	
}

