package com.pmb.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;
import com.pmb.model.Balance;

@Repository
public class BalanceDAO implements IBalanceDAO{

	
	public static final Logger logger = LogManager.getLogger("BalanceDAO");
	
	private DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public Balance getUserBalance (String userEmail)  throws ClassNotFoundException, SQLException {
		
		Connection  con = dataBaseConfig.getConnection();
		
		Balance balance= null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_BALANCE);
				ps.setString(1, userEmail);


				rs = ps.executeQuery();

				if (rs.next()){
					balance = new Balance ();
					balance.setId(rs.getInt("id"));
					balance.setBalanceAmount(balance.getBalanceAmount());
					//balance.setDate(Date.valueOf(balance.getDate()));
										
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
		return balance;
	}
	
	
}
