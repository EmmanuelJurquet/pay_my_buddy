package com.pmb.constants;

public class DataBaseConstants { 

	public static final String GET_IDENTIFICATION = "SELECT * FROM Identification  WHERE IDN_EMAIL = ? AND IDN_PASSWORD = ? ";
	
	public static final String GET_FIRSTNAME ="SELECT USR_F_NAME FROM User JOIN  Identification ON USR_FK_IDN = IDN_ID WHERE IDN_ID = ?";
	
	public static final String GET_PROFILE="SELECT USR_F_NAME, USR_L_NAME,USR_EMAIL, USR_BIRTH, USR_ADDR,USR_PHONE, USR_CITY,USR_ZIP FROM User JOIN  Identification ON USR_FK_IDN = IDN_ID WHERE IDN_ID = ?";
	
	public static final String ADD_IDS = "INSERT INTO Identification (IDN_EMAIL, IDN_PASSWORD) Values(?,?)";
	
	public static final String GET_IDENTIFICATION_BY_EMAIL = "SELECT * FROM Identification WHERE IDN_EMAIL = ? ";
	
	public static final String FIND_ID_BY_EMAIL = "SELECT * FROM Identification JOIN User ON USR_FK_IDN = IDN_ID  WHERE IDN_EMAIL= ?";
	
	public static final String SAVE_USR_PROFILE ="INSERT INTO User ( USR_FK_IDN, USR_F_NAME, USR_L_NAME, USR_EMAIL, USR_BIRTH, USR_ADDR, USR_PHONE, USR_CITY, USR_ZIP) Values (?,?,?,?,?,?,?,?,?)"; 
	
	public static final String SAVE_WAL = "INSERT INTO Wallet (WAL_USR_FK_ID,WAL_BALANCE, WAL_VISA, WAL_EXPIR, WAL_CRYPTO) Values (?,?,?,?,?)";
	
	public static final String GET_USER_PROFILE_BY_ID = "SELECT * FROM User JOIN Identification ON USR_FK_IDN = IDN_ID WHERE IDN_ID = ? ";

	public static final String GET_FRIEND_LIST = "SELECT * FROM User JOIN Friend ON FR_USR_PROFILE_ID_RECEIVER = USR_ID WHERE FR_USR_PROFILE_ID_OWNER = ?";

	public static final String VERIFY = "SELECT * FROM Friend WHERE FR_USR_PROFILE_ID_OWNER = ? AND FR_USR_PROFILE_ID_RECEIVER = ?";
	
	public static final String ADD_FRIEND = "INSERT INTO Friend (FR_USR_PROFILE_ID_OWNER, FR_USR_PROFILE_ID_RECEIVER) Values (?,?)";

	public static final String DELETE_FRIEND = "DELETE FROM Friend WHERE FR_USR_PROFILE_ID_OWNER= ? AND FR_USR_PROFILE_ID_RECEIVER= ?";
	
	public static final String PAY_MY_BUDDY = "INSERT INTO Wallet (WAL_BALANCE) Values (?) WHERE USR_EMAIL = ?";
	
	public static final String PAYMENT = "UPDATE  WALLET  SET WAL_BALANCE =? WHERE  WAL_USR_FK_ID = ? ";
	
	public static final String GET_BAL = "SELECT WAL_BALANCE FROM Wallet JOIN  User ON WAL_USR_FK_ID = USR_ID WHERE WAL_ID = ?";
	
	public static final String GET_BALANCE = "SELECT WAL_ID, WAL_BALANCE, WAL_VISA, WAL_EXPIR, WAL_CRYPTO FROM Wallet JOIN User ON WAL_USR_FK_ID = USR_ID WHERE WAL_ID = ?";

	public static final String GET_TRANSACTION = "SELECT *  FROM Transactions JOIN User ON TRA_USR_PROFILE_ID_RECEIV = USR_ID WHERE TRA_USR_PROFILE_ID_EMIT = ?";
											  
	public static final String SAVE_TRANSACTIONS = "INSERT INTO Transactions(TRA_USR_PROFILE_ID_EMIT,TRA_USR_PROFILE_ID_RECEIV,TRA_DESIGNATION,TRA_DATE,TRA_AMOUNT,TRA_FEE) Values (?,?,?,?,?,?)";

}	

