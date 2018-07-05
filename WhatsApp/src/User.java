public class User {
	private String idUser;
	private Repositorio<Chat> grupos;
	private Repositorio<Mensagem>mensagens;
	int qtdMsg = 0;
	
	public User(String idUser) {
		this.idUser = idUser;
		grupos = new Repositorio<Chat>("grupos");
		mensagens =  new Repositorio<Mensagem>("mensagens");		
	}
	
	public Repositorio<Chat> getGrupos(){
		return grupos;
	}
	
	public void setGrupos(Repositorio<Chat> grupos) {
		this.grupos = grupos;
	}
	
	public Repositorio<Mensagem> getMensagens(){
		return mensagens;
	}
	
	public void setMensagens(Repositorio<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	public void setIdUser(String idUser) {
			this.idUser = idUser;
	}
	
	public String toString() {
		return idUser;
	}

	public Chat retornaChat(Chat c) {
		for(Chat chat : this.grupos.getAll()) 
			if(chat.getChat().equals(c.getChat()))
				return c;
		
		throw new RuntimeException("ERRO!! VOCE NAO ESTA NESSE GRUPO");
	}
	
	public void mostrarMensagens(Chat c) {
		if(this.retornaChat(c) != null) {
			System.out.println(c.mostrarSms(this.getIdUser()));
		}	
	}
	
	public String contagem(Chat c) {
		String saida="";
		for(Mensagem m : c.getSms().getAll()) {
			if(!m.getUser().equals(this.idUser)) {
				if(!m.isLido()) {
					qtdMsg++;
				   m.setLido(true);
				}
			}
		}
		saida += qtdMsg ;
		qtdMsg = 0;
		return saida;
	}
	public String mostrarGroups() {
		String saida ="[ ";
		for(Chat c : grupos.getAll())
			saida+= c.toString() + " ";
		return saida + "]";
	}	
}
