package tma.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="smartphone")
public class SmartPhone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idSmartPhone;
	
	private String nameSmartPhone;

	private int priceSmartPhone;
	
	
	public SmartPhone(){
			
		}
	
	public SmartPhone(String idSmartPhone, String nameSmartPhone, int priceSmartPhone) {
		super();
		this.idSmartPhone = idSmartPhone;
		this.nameSmartPhone = nameSmartPhone;
		this.priceSmartPhone = priceSmartPhone;
	}

	public String getidSmartPhone() {
		return idSmartPhone;
	}

	public void setidSmartPhone(String idSmartPhone) {
		this.idSmartPhone = idSmartPhone;
	}

	public String getnameSmartPhone() {
		return nameSmartPhone;
	}

	public void setnameSmartPhone(String nameSmartPhone) {
		this.nameSmartPhone = nameSmartPhone;
	}

	public int getpriceSmartPhone() {
		return priceSmartPhone;
	}

	public void setpriceSmartPhone(int priceSmartPhone) {
		this.priceSmartPhone = priceSmartPhone;
	}

	@Override
	public String toString() {
		return "SmartPhone [idSmartPhone=" + idSmartPhone + ", nameSmartPhone=" + nameSmartPhone + ", priceSmartPhone=" + priceSmartPhone + "]";
	}
}