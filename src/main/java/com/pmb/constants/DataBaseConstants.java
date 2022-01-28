package com.pmb.constants;

public class DataBaseConstants {

	public static final String GET_IDENTIFICATION = "SELECT id, 'userEmail','userPassword'  FROM identification, WHERE userEmail = ? userPassword = ? ";
	
	public static final String GET_IDENTIFICATION_BY_MAIL = "SELECT id, 'userEmail', user'Password' FROM  identification WHERE userEmail = ?";
	
	public static final String GET_USER_ID_BY_MAIL = "SELECT id FROM identification WHERE userEmail = ? ";
	
	public static final String GET_USER_PROFILE_BY_EMAIL = "SELECT id ,userFirstName, userLastName, birthdate, userEmail,"
			+ " userAddress,userPhone, userCity, userPostCode FROM User_Profile WHERE userFirstName = ?, userLastName = ?";
	
	public static final String INSERT_IDENTIFICATION ="INSERT INTO identification "	+ "(userEmail, userPassword) VALUES (?,?)";
	
	public static final String UPDATE_IDENTIFICATION = "UPDATE identification SET userEmail = ?, userPassword = ? ";
	
	public static final String UPDATE_USER_PROFILE = "UPDATE User_Profile SET userFirstName = ?, userLastName=?, birthdate=?,"
			+ " userEmail=?, userAddress=?,userPhone=?, userCity=?, userPostCode=?";
	
	
	
}


