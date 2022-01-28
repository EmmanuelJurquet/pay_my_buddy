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
import com.pmb.model.Identification;



@Repository
public class IdentificationDAO implements IidentificationDAO {


	public static final Logger logger = LogManager.getLogger("IdentificationDAO");

	private DataBaseConfig dataBaseConfig = new DataBaseConfig();


	public Identification findbyIdentification ( String userEmail, String userPassword) throws ClassNotFoundException, SQLException {

		Connection  con = dataBaseConfig.getConnection();
		Identification user = null;
		
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(DataBaseConstants.GET_IDENTIFICATION 	 );
				ps.setString(1, userEmail);
				ps.setString(2, userPassword);
 
				rs = ps.executeQuery();
				if (rs.next()) {
					 user =  new Identification ();
					 user.setId(rs.getInt("id"));
					 user.setUserEmail(userEmail);
					 user.setUserPassword(userPassword);
					
					
				}

			} catch (SQLException e) {
			logger.error("An error occured : User could not be found");
			
			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}


			return 	user;
		}
		return null;
		
		
	}
	
}



