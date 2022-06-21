package com.pmb.DAO;

import java.sql.Connection;
import java.sql.Date;
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
	
	
	

	public UserProfile user_Profile_Connection (int idOwner)  {

		UserProfile user = null;
		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_USER_PROFILE_BY_ID);
				ps.setInt(1, idOwner);
				
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

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e);
				
			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			return user;

		}
	
	

	public int getIdByEmail  (String email ) {
		
		int result = -1;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataBaseConfig.getConnection();

			ps = con.prepareStatement(DataBaseConstants.FIND_ID_BY_EMAIL);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				
				result=rs.getInt("USR_ID");
				
			}
		}

	 catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		logger.error(e);

	}

	finally {
		dataBaseConfig.closeResultSet(rs);
		dataBaseConfig.closePreparedStatement(ps);
		dataBaseConfig.closeConnection(con);
	}
			return result;
	}
	
	
	public boolean saveIdsInUserProfile (UserProfile usr) {

				Connection  con = null;
				boolean result = false;
				PreparedStatement ps = null;
				
				
				try {
					con = dataBaseConfig.getConnection();
					ps= con.prepareStatement(DataBaseConstants.SAVE_USR_PROFILE);
					ps.setString(1, usr.getFirstname());
					ps.setString(2, usr.getLastname());
					ps.setString(3, usr.getEmail());
					ps.setDate(4,Date.valueOf(usr.getBirthdate()));
					ps.setString(5,  usr.getAddress());
					ps.setString(6, usr.getPhone());
					ps.setString(7, usr.getCity());
					ps.setString(8, usr.getZip());
					
					result = (ps.execute());
				} 
				 catch (SQLException | ClassNotFoundException e) {
						logger.error(e);
				 } finally {

						dataBaseConfig.closePreparedStatement(ps);
						dataBaseConfig.closeConnection(con);
					}
				return result;
			}
			
			
		}
	
	
	
	

