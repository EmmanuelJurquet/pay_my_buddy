package com.pmb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.UserProfile;
@Repository
public class UserProfileDAO {




	public static final Logger logger = LogManager.getLogger("UserDAO");

	private DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	
	

	public UserProfile user_Profile_Connection (String email, String password)  throws ClassNotFoundException, SQLException{

		Connection  con = dataBaseConfig.getConnection();

		UserProfile user = null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_USER_PROFILE_BY_EMAIL_AND_PASSWORD);
				ps.setString(1, email);
				ps.setString(2, password);
				logger.debug(ps.toString());

				rs = ps.executeQuery();

				if (rs.next()){
					user = new UserProfile ();
					user.setId(rs.getInt("IDN_ID"));
					user.setFirstname(rs.getString("USR_F_NAME"));
					user.setLastname(rs.getString("USR_L_NAME"));
					user.setEmail(rs.getString("USR_EMAIL"));
					user.setAddress(rs.getString("USR_ADDR"));
					user.setBirthdate(rs.getDate("USR_BIRTH").toLocalDate());
					user.setPhone(rs.getString("USR_PHONE"));
					user.setCity(rs.getString("USR_CITY"));
					user.setZip(rs.getString("USR_ZIP"));

				}

			} catch (SQLException e) {
				e.printStackTrace();
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

	
}
