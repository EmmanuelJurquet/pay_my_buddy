package com.pmb.DAO;



import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.pmb.model.Transactions;


@Repository
public interface ITransactionsDAO {

	public List<Transactions> getTransaction (int idOwner) ;
	
	public boolean saveTransactions (Connection connection, Transactions tra);
	
	public boolean payment (int idOwner, double amount);
}

