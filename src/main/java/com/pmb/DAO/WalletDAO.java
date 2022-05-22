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
import com.pmb.model.Wallet;

@Repository
public class WalletDAO implements IWalletDAO{

	
	public static final Logger logger = LogManager.getLogger("BalanceDAO");
	
	private DataBaseConfig dataBaseConfig = new DataBaseConfig();
	
	public Wallet getSold (int walId)  throws ClassNotFoundException, SQLException {
		
		Connection  con = dataBaseConfig.getConnection();
		
		Wallet balance= null;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_BALANCE);
				ps.setInt(1,walId);
				
				rs = ps.executeQuery();

				if (rs.next()){
					balance = new Wallet ();
					balance.setId(rs.getInt("WAL_ID"));
					balance.setBalance(rs.getDouble("WAL_BALANCE"));
					balance.setVisacardnumber(rs.getString("WAL_VISA"));
					balance.setExpiration(rs.getString("WAL_EXPIR"));
					balance.setCryptogram(rs.getInt("WAL_CRYPTO"));
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("An error occured : Wallet could not be found");

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
		}
		return balance;
	}
	
	public double getBal (int idOwner) throws ClassNotFoundException, SQLException{
		
	Connection  con = dataBaseConfig.getConnection();
		
		double balance= -1;
		if (con!= null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_BAL);
				ps.setInt(1, idOwner);
				rs = ps.executeQuery();

				if (rs.next()){
					balance = rs.getDouble("WAL_BALANCE");

				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("An error occured : Wallet could not be found");

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
		}	return balance;
	}
	
	
	public boolean payment (int idOwner, double amount) throws ClassNotFoundException, SQLException{
		
		Connection  con = dataBaseConfig.getConnection();
		boolean rs =  false;
		
		if (con!= null) {

			PreparedStatement ps = null;
			
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.PAYMENT);
				ps.setInt(2,idOwner);
				ps.setDouble(1, amount);
				rs =(ps.executeUpdate() > 0);
				
				}	
	

			 catch (SQLException e) {
				e.printStackTrace();
				logger.error("An error occured : Wallet could not be found");

			}
			finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
		}	return rs;
	}
	
}
