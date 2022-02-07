package com.pmb.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.UserProfile;

public class UserProfileDAO {




	public static final Logger logger = LogManager.getLogger("IdentificationDAO");

	private DataBaseConfig dataBaseConfig = new DataBaseConfig();

	public UserProfile user_Profile_Connection (String userEmail)  throws ClassNotFoundException, SQLException{

		Connection  con = dataBaseConfig.getConnection();

		UserProfile user = null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_USER_PROFILE_BY_EMAIL);
				ps.setString(1, userEmail);


				rs = ps.executeQuery();

				if (rs.next()){
					user = new UserProfile ();
					user.setId(rs.getInt("id"));
					user.setFirstname(user.getFirstname());
					user.setLastname(user.getLastname());
					user.setAddress(user.getAddress());
					user.setBirthdate(user.getBirthdate());
					user.setPhone(user.getPhone());
					user.setCity(user.getCity());
					user.setZip(user.getZip());

				}

			} catch (SQLException e) {
				logger.error("An error occured : User could not be found");

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}


		}
		return user;

	}

	public boolean updateUserProfile (String userEmail)  throws ClassNotFoundException, SQLException{

		Connection  con = dataBaseConfig.getConnection();
		boolean result = false;
		
		if (con!= null) {

			PreparedStatement ps = null;
		
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.UPDATE_USER_PROFILE);
				UserProfile user = new UserProfile();
				ps.setString(1, userEmail);
				ps.setString(2,new String (user.getFirstname()));
				ps.setString(3,new String(user.getLastname()));
				// Comment set une date? 
				ps.setDate(4, Date.valueOf(user.getBirthdate()));
				ps.setString(5, new String (user.getPhone()));
				ps.setString(6,new String(user.getCity()));
				ps.setString(7, new String (user.getZip()));
				
				
				result = (ps.executeUpdate() > 0);

			} catch (SQLException e) {
				logger.error("An error occured : User could not be found");

			} finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			
		} 
		
		return result =  true;

	}
}
