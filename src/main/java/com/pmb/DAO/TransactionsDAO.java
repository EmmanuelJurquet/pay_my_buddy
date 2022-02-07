package com.pmb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;

import com.pmb.model.Transactions;

public class TransactionsDAO {
	
	
	public static final Logger logger = LogManager.getLogger("TransactionsDAO");

	private DataBaseConfig dataBaseConfig = new DataBaseConfig();

	public Transactions getTransaction (int id) throws ClassNotFoundException, SQLException {
	Connection  con = dataBaseConfig.getConnection();
		
		Transactions transac = null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_TRANSACTION);
				ps.setInt(1, id);


				rs = ps.executeQuery();

				if (rs.next()){
					transac = new Transactions ();
					transac.setId(rs.getInt("id"));
					transac.setAmount(transac.getAmount());
					transac.setDate(transac.getDate());
					transac.setDesignation(transac.getDesignation());
					transac.setTransmitter(transac.getTransmitter());
					transac.setIbanTransmitter(transac.getIbanTransmitter());
					transac.setReceiver(transac.getReceiver());
					transac.setIbanReceiver(transac.getIbanReceiver());
				}

			} catch (SQLException e) {
				logger.error("An error occured : Transaction could not be found");

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}


		}
		return transac;
	}
	// verifier si le param est bon (int id ou Transactions transac)
		public boolean  saveTransaction (int id) throws ClassNotFoundException, SQLException {
			
			Connection  con = dataBaseConfig.getConnection();
			boolean result = false;

			if (con!= null) {

				PreparedStatement ps = null;
			
				try {
					con = dataBaseConfig.getConnection();
					ps = con.prepareStatement(DataBaseConstants.SAVE_TRANSACTION);
					Transactions transac =  new Transactions();
					ps.setInt(1, transac.getId());
					ps.setString(2,transac.getDesignation());
					ps.setDouble(3,transac.getAmount());
					//ps.setDate(4,transac.getDate());
					ps.setObject(5, transac.getTransmitter());
					ps.setObject(6, transac.getIbanTransmitter());
					ps.setObject(7, transac.getReceiver());
					ps.setObject(8, transac.getIbanReceiver());
					
					// demander explication Guillian  : 
					result = (ps.executeUpdate() > 0);

				} catch (SQLException e) {
					logger.error("An error occured : Transaction could not be found");

				} finally {
					
					dataBaseConfig.closePreparedStatement(ps);
					dataBaseConfig.closeConnection(con);
				}
				
			} 
			
			return result;

			
		}
}
