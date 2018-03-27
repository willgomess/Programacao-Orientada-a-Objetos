import java.util.ArrayList;
import java.util.List;

public class Contato {
	private String nome;
	private List<Telefone> telefones;
	
	public Contato(String nome) {
		this.nome = nome;
		this.telefones = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public boolean addFone(Telefone telefone) throws Exception {
		for(Telefone fone : telefones) {
			if(fone.getFoneId().equals(telefone.getFoneId())){
				throw new Exception("ERRO! FONEID JÁ EXISTE!");
			}
		}
		return telefones.add(telefone);
	}
	public boolean rmFone(String foneId) throws Exception  {
		for (Telefone telefone : telefones) {
			if(telefone.getFoneId().equals(foneId)) {
				return telefones.remove(telefone);
			}
		}
		throw new Exception("ERRO! CONTATO NÃO ENCONTRADO!");
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefones=" + telefones + "]";
	}
	
}
