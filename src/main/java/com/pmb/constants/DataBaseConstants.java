package com.pmb.constants;

public class DataBaseConstants {

	public static final String GET_IDENTIFICATION = "SELECT id, 'userEmail','userPassword'  FROM identification, WHERE userEmail = ? userPassword = ? ";
	
	public static final String GET_IDENTIFICATION_BY_MAIL = "SELECT id FROM identification WHERE userEmail = ? ";
	
	public static final String GET_USER_PROFILE_BY_EMAIL = "SELECT id ,userFirstName, userLastName, birthdate, userEmail,"
			+ " userAddress,userPhone, userCity, userPostCode FROM User_Profile WHERE userFirstName = ?, userLastName = ?";
	
	public static final String UPDATE_IDENTIFICATION = "UPDATE identification SET userEmail = ?, userPassword = ? ";
	
	public static final String UPDATE_USER_PROFILE = "UPDATE User_Profile SET userFirstName = ?, userLastName=?, birthdate=?,"
			+ " userEmail=?, userAddress=?,userPhone=?, userCity=?, userPostCode=?";
	public static final String GET_CONTACTS = "SELECT id , 'firstName', 'lastName' , 'iban', 'email' FROM contatcs WHERE email = ?";
	
	public static final String UPDATE_CONTACTS = "UPDATE Contacts SET firstName = ? , lastName = ?, iban = ?, email =?";
	
	public static final String ADD_CONTACT = "INSERT  INTO Contacts(firstName,lastName,email,iban) values(?,?,?,?)";
	
	public static final String DELETE_CONTACT = "DELETE FROM Contacts WHERE (firstName = ?, lastName = ?)";
	
	public static final String GET_BALANCE = "SELECT id, balanceAmount, date FROM Balance WHERE userEmail = ?";
	
	public static final String GET_TRANSACTION = "SELECT id, designation, amount, date, ibanTransmitter, ibanReceiver, transmitter, receiver FROM transactions WHERE id = ?";
	
	public static final String SAVE_TRANSACTION = "INSERT INTO transaction (id, designation, amount, date, ibanTransmitter, ibanReceiver, transmitter, receiver) values (?,?,?,?,?,?,?,?)";
	
	
}

