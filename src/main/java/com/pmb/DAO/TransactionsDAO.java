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
import org.springframework.stereotype.Repository;

import com.pmb.config.DataBaseConfig;
import com.pmb.constants.DataBaseConstants;

import com.pmb.model.Transactions;

@Repository
public class TransactionsDAO implements ITransactionsDAO{


	
	public static final Logger logger = LogManager.getLogger("TransactionsDAO");
	private DataBaseConfig dataBaseConfig = new DataBaseConfig();

	
	
	public List<Transactions> getTransaction (int idOwner)  {
		
		List<Transactions> result = new ArrayList<>();
		
		Connection  con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
			
			try {
				con = dataBaseConfig.getConnection();
				ps = con.prepareStatement(DataBaseConstants.GET_TRANSACTION);
				ps.setInt(1, idOwner);
				
				rs = ps.executeQuery();

				while (rs.next()){
					
					Transactions transac =  new Transactions ();
					transac.setId(rs.getInt("TRA_USR_PROFILE_ID_EMIT"));
					transac.setId(rs.getInt("TRA_USR_PROFILE_ID_RECEIV"));
					transac.setAmount(rs.getDouble("TRA_AMOUNT"));
					transac.setDate(rs.getDate("TRA_DATE").toLocalDate());
					transac.setDesignation(rs.getString("TRA_DESIGNATION"));
					transac.setFee(rs.getDouble("TRA_FEE"));
					transac.setReceiverfullname(rs.getString("USR_F_NAME") +" "+ rs.getString("USR_L_NAME"));
					result.add(transac);
					
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
		return result;
	}

	public boolean saveTransactions (Transactions tra) {

		boolean rs =  false;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataBaseConfig.getConnection();

			ps = con.prepareStatement(DataBaseConstants.SAVE_TRANSACTIONS);
			ps.setInt(1, tra.getEmmitid());
			ps.setInt(2, tra.getReceivid());
			ps.setString(3, tra.getDesignation());
			ps.setDate(4,Date.valueOf(tra.getDate()));
			ps.setDouble(5, tra.getAmount());
			ps.setDouble(6, tra.getFee());
			logger.debug(ps.toString());
			rs =(ps.executeUpdate() > 0);
		}	

		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("An error occured : Wallet could not be found");

		}
		finally {

			dataBaseConfig.closePreparedStatement(ps);
			dataBaseConfig.closeConnection(con);
		}
		
		return rs;

	}


}

