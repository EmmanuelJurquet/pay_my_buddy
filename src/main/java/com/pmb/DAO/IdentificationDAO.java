package com.pmb.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.Identification;

@Repository
public class IdentificationDAO implements IidentificationDAO {

	public static final Logger logger = LogManager.getLogger("IdentificationDAO");
	@Autowired
	DataBaseConfig dataBaseConfig;
	

	public Identification findbyIdentification ( String email, String password ) {

		Connection  con = null;
		Identification user = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		try {
			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.GET_IDENTIFICATION );
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			logger.debug(ps.toString());
			
			if (rs.next()) {
				user =  new Identification ();
				user.setId(rs.getInt("IDN_ID"));
				user.setEmail(rs.getString("IDN_EMAIL"));
				user.setPassword(rs.getString("IDN_PASSWORD"));
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

	public Identification identificationByEmail ( String email ) {

		Connection  con = null;
		Identification user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = dataBaseConfig.getConnection();
			ps = con.prepareStatement(DataBaseConstants.GET_IDENTIFICATION_BY_EMAIL );
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user =  new Identification ();
				user.setId(rs.getInt("IDN_ID"));
				user.setEmail(rs.getString("IDN_EMAIL"));
				user.setPassword(rs.getString("IDN_PASSWORD"));
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

		public boolean saveIdsInIdentificationTable (Identification ident) {

			Connection  con = null;
			boolean result = false;
			PreparedStatement ps = null;
			
			
			try {
				con = dataBaseConfig.getConnection();
				ps= con.prepareStatement(DataBaseConstants.ADD_IDS);
				ps.setString(1, ident.getEmail());
				ps.setString(2, ident.getPassword());
				
				result = (ps.execute());
			} 
			 catch (SQLException | ClassNotFoundException e){
				 e.printStackTrace();
					logger.error(e);
			 } finally {

					dataBaseConfig.closePreparedStatement(ps);
					dataBaseConfig.closeConnection(con);
				}
			return result;
		}

}
