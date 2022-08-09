package com.pmb.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.UserProfile;
@Repository
public class UserProfileDAO implements IUserProfileDAO {




	public static final Logger logger = LogManager.getLogger("UserDAO");

	@Autowired
	DataBaseConfig dataBaseConfig;
	
	

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
				logger.debug(ps.toString());

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
	
	public String getUserFirstName ( int id) {
		
		String result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.GET_FIRSTNAME);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			if (rs.next()) {
				
				result= rs.getString("USR_F_NAME");
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
	public List <String> getProfile (int id) {
		
		List <String> result =  new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataBaseConfig.getConnection();

			ps = con.prepareStatement(DataBaseConstants.GET_PROFILE);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				
			//	result=rs.get("USR_F_NAME,USR_L_NAME,USR_EMAIL,USR_BIRTH,USR_ADDR, USR_PHONE,USR_CITY,USR_ZIP");
				
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
					ps.setInt(1, usr.getIdentificationId());
					ps.setString(2, usr.getFirstname());
					ps.setString(3, usr.getLastname());
					ps.setString(4, usr.getEmail());
					ps.setDate(5,Date.valueOf(usr.getBirthdate()));
					ps.setString(6,  usr.getAddress());
					ps.setString(7, usr.getPhone());
					ps.setString(8, usr.getCity());
					ps.setString(9, usr.getZip());
					
					ps.execute();
					
					result= true;
				} 
				 catch (SQLException | ClassNotFoundException e) {
					 e.printStackTrace();
					 logger.error(e);
				 } finally {

						dataBaseConfig.closePreparedStatement(ps);
						dataBaseConfig.closeConnection(con);
					}
				return result;
			}
			
			
		}
	
	
	
	

