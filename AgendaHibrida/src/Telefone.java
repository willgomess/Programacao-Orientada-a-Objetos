
public class Telefone {

	private String idfone;
	private String number;
	
	public Telefone(String idfone, String number) {
		this.idfone = idfone;
		this.number = number;
	}

	public String getIdfone() {
		return idfone;
	}

	public void setIdfone(String idfone) {
		this.idfone = idfone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		return  idfone + ":" + number;
	}
}