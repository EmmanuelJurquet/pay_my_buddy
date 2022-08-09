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
import com.pmb.model.Wallet;

@Repository
public class WalletDAO implements IWalletDAO{

	
	public static final Logger logger = LogManager.getLogger("BalanceDAO");
	
	@Autowired
	DataBaseConfig dataBaseConfig;
	
	public Wallet getSold (int walId)  {
		
		Connection  con = null;
		Wallet balance= null;
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

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e);
		
			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
		
		return balance;
	}
	
	public double getBal (int idOwner) {
		
	Connection  con = null;
	double balance= -1;
		
	

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

			} catch (SQLException  | ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e);

			}
			finally {
				dataBaseConfig.closeResultSet(rs);
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			return balance;
	}
	
	
	public boolean payment (Connection connection ,int idOwner, double amount) {
		
		Connection  con = null;
		boolean rs =  false;
		PreparedStatement ps = null;
			
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.PAYMENT);
				ps.setInt(2,idOwner);
				ps.setDouble(1, amount);
				rs =(ps.executeUpdate() > 0);
				}	
	
			 catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				logger.error(e);
			}
			finally {
				
				dataBaseConfig.closePreparedStatement(ps);
				dataBaseConfig.closeConnection(con);
			}
			return rs;
	}
	public boolean saveWallet (Wallet wal) {
		Connection  con = null;
		boolean result = false;
		PreparedStatement ps = null;
		
		try {
			con = dataBaseConfig.getConnection();
			ps= con.prepareStatement(DataBaseConstants.SAVE_WAL);
			ps.setInt(1, wal.getId());
			ps.setDouble(2, wal.getBalance());
			ps.setString(3, wal.getVisacardnumber());
			ps.setString(4, wal.getExpiration());
			ps.setInt(5, wal.getCryptogram());
			
			result=(ps.execute());
			
			result = true;
			
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