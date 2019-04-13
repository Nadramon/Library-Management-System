package library.views;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Student {

	
	private String 	firstName			= "";
	private String 	lastName			= "";
	private int		ucid				= 0;
	private int		currentBorrowing	= 0;
	private boolean	isActive			= true;

    private String  username            = "";
    private byte[]  password;
    private byte[]  salt;
    private String  passwordo 			= "";
    private boolean isLibrarian			= false;
    private int fee;

	
	
	public Student(String fn, String ln, int id, int cb, boolean ia, boolean il){
		
		firstName 			= fn;
		lastName			= ln;
		ucid				= id;
		currentBorrowing	= cb;
		isActive			= ia;
		isLibrarian			= il;
	}
	
	public Student(String fn, String ln, int id, int cb, boolean ia, String uName, String pWord, boolean isLib) {
        firstName = fn;
        lastName = ln;
        ucid = id;
        currentBorrowing = cb;
        isActive = ia;
        username = uName;
        passwordo = pWord;
        isLibrarian = isLib;
        
    }
/*
 *  Massive list of just getters and setters
 */
	public String getUsername() {return username;}

	public boolean getIsLibrarian() {
		return isLibrarian;
	}
	
	public void setIsLibrarian(boolean isLib) {
		this.isLibrarian = isLib;
	}
	public String getPassword() {
		return passwordo;
	}
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getUcid() {
		return ucid;
	}


	public void setUcid(int ucid) {
		this.ucid = ucid;
	}


	public int getCurrentBorrowing() {
		return currentBorrowing;
	}


	public void setCurrentBorrowing(int i) {
		this.currentBorrowing += i;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	//password generation from 
    //https://www.javacodegeeks.com/2012/05/secure-password-storage-donts-dos-and.html
    public boolean generatePassword(String pw) {
        if (!isStrong(pw)) {
            return false;
        }
        try {
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            salt = new byte[10];
            rand.nextBytes(salt);
            KeySpec specification = new PBEKeySpec(pw.toCharArray(), salt, 1000, 160);
        
            SecretKeyFactory keyFact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            password = keyFact.generateSecret(specification).getEncoded();
        }
        catch(NoSuchAlgorithmException nsae) {
            return false;
        }
        catch(InvalidKeySpecException ikse) {
            return false;
        }
        return true;
    }
    
    //password generation from 
    //https://www.javacodegeeks.com/2012/05/secure-password-storage-donts-dos-and.html
    public boolean isPWordCorrect(String pw) {
        boolean isRight = false;
        try {
            KeySpec specification = new PBEKeySpec(pw.toCharArray(), salt, 1000, 160);
        
            SecretKeyFactory keyFact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] encPW = keyFact.generateSecret(specification).getEncoded();
            if (Arrays.equals(encPW, password)) {
                isRight = true;
            }
        }
        catch(NoSuchAlgorithmException nsae) {
            isRight = false;
        }
        catch(InvalidKeySpecException ikse) {
            isRight = false;
        }
        return isRight;
    }
    
    /**
     * Method to check if the password is strong, i.e. has 8 or more characters, at least one number,
     * lower & upper case letters, and 1 special character
     * @param pWord
     * @return strongPword
     */
    public static boolean isStrong(String pWord) {
        boolean strongPword = false;
        if (pWord.length() >= 8) {
            if (pWord.matches(".*\\d+.*")){
                if (pWord.matches(".*[a-z]+.*")) {
                    if (pWord.matches(".*[A-Z]+.*")) {
                        if (!pWord.contains("\\s")) {
                            strongPword = true;
                        }
                    }
                }
            }
        }
        return strongPword;
    }
	
	
}
