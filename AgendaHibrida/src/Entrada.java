public class Contact extends Entrada{

	private Repositorio<Telefone> fones;
	
	public Contact(String id) {
		super(id);
		fones = new Repositorio<Telefone>("telefones");
	}

	public Repositorio<Telefone> getFones() {
		return fones;
	}

	public void setFones(Repositorio<Telefone> fones) {
		this.fones = fones;
	}
	
	public void addFone(Telefone f) {
		this.fones.add(f.getIdfone(), f);
	}
	
	public void rmFone(String idfone) {
	    this.fones.remove(idfone);	
	}
	
	public String mostrarFone() {
		String saida = " [";
		for(Telefone f : fones.getAll())
			saida += f.toString() + "]" + "\n";
		return saida;
	}
	public String toString() {
		return super.toString() + fones.toString();
	}
}