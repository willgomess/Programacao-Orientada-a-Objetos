public class Agenda {

	private Repositorio<Entrada> entradas;
	private Repositorio<Entrada> favoritos;
	int quantidade = 0;
	public Agenda() {
		entradas = new Repositorio<Entrada>("entradas");
		favoritos = new Repositorio<Entrada>("favoritos");
	}

	public Repositorio<Entrada> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Repositorio<Entrada> favoritos) {
		this.favoritos = favoritos;
	}

	public Repositorio<Entrada> getEntradas() {
		return entradas;
	}
	
	
	public void rmEntry(String identrada) {
		this.entradas.remove(identrada);
	}
	
	public String mostrarFavoritos() {
		String saida="";
		for(Entrada t : favoritos.getAll())
			saida += t.toString() + "\n";
		return saida;
	}
	
	public void favoritar(Entrada id) {
		if(!id.isIsfavorit())
			id.setIsfavorit(true);
		this.favoritos.add(id.getIdentrada(), id);
	}
	
	public void desfavoritar(Entrada id) {
		if(id.isIsfavorit())
			id.setIsfavorit(false);
		this.favoritos.remove(id.getIdentrada());
	}
	
	public String mostrar() {
		String saida="";
		for(Entrada t : entradas.getAll()) {
			if(t instanceof Password) {
				quantidade = ((Password) t).getPassword().length();
				   saida += t.toString() + " " + t.converte(quantidade) + "\n";
			}
			else
			saida += t.toString() + "\n";
		}
		
		
		return saida;
	}
}