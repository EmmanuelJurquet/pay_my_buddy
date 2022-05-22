package com.pmb.DAO;


import java.util.List;

import org.springframework.stereotype.Repository;
import com.pmb.model.Transactions;


@Repository
public interface ITransactionsDAO {

		
	
	public List<Transactions> getTransaction (int idOwner) ;
	
	public boolean saveTransactions (Transactions tra);
	
}
