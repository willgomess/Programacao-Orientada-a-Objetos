import java.util.ArrayList;
import java.util.List;

public class Maquina {
	
	private List<Espiral> espirais;
	private float saldoCliente;
	private float lucro;
	private int limiteDeEspirais;
	private int maximoDeProdutos;
	
	public Maquina(int limiteDeEspirais, int maximoDeProdutos) {
		
		this.limiteDeEspirais = limiteDeEspirais;
		this.saldoCliente = 0;
		this.lucro = 0;
		this.espirais = new ArrayList<>();
		this.maximoDeProdutos = maximoDeProdutos;
		
		//Adiciono os produtos com base na quantidade permitida.
		for(int i = 0; i < limiteDeEspirais; i++) {	
				this.espirais.add(new Espiral());
		}
		
	}

	public List<Espiral> getEspirais() {
		return espirais;
	}

	public void setEspirais(List<Espiral> espirais) {
		this.espirais = espirais;
	}

	public float getSaldoCliente() {
		return saldoCliente;
	}

	public void setSaldoCliente(float saldoCliente) {
		this.saldoCliente = saldoCliente;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

	public int getLimiteDeEspirais() {
		return limiteDeEspirais;
	}

	public void setLimiteDeEspirais(int limiteDeEspirais) {
		this.limiteDeEspirais = limiteDeEspirais;
	}

	public int getMaximoDeProdutos() {
		return maximoDeProdutos;
	}

	public void setMaximoDeProdutos(int maximoDeProdutos) {
		this.maximoDeProdutos = maximoDeProdutos;
	}
	
	public boolean resetarEspiral(int idEspiral) throws Exception {
		
		for (Espiral espiral : espirais) {
			if(espiral.getId() == idEspiral) {
				espiral.setNome(" - ");
				espiral.setQuantidade(0);
				espiral.setPreco(0);
				return true;
			}
		}
		
		throw new Exception("Erro | ID informado não existe!");
	}
	
	public boolean alterarEspiral(int idEspiral, Espiral esp) throws Exception {
		
		for (Espiral espiral : espirais) {
			if(this.getMaximoDeProdutos() >= esp.getQuantidade()) {
				if(espiral.getId() == idEspiral) {
					espiral.setNome(esp.getNome());
					espiral.setQuantidade(esp.getQuantidade());
					espiral.setPreco(esp.getPreco());
					return true;
				}
			}else {
				throw new Exception("Não foi possível adicionar o produto, a quantidade máxima é(são): " + this.getMaximoDeProdutos() + " U");
			}
		}
		throw new Exception("Erro | ID não encontrado! ou nao há espaço suficiente para os produtos!");
	}
	
//================================================== DINHEIRO =========================================================	
	
	public boolean incerirDinheiro(float dinheiro) throws Exception {
		
		if(dinheiro > 0) {
			this.saldoCliente += dinheiro;
			return true;
		}
		
		throw new Exception("Dinheiro precisa ser maior que zero!");
	}
	
	public boolean vender(int idEspiral,int quantidade) throws Exception {
		for (Espiral espiral : espirais) {	
			if(espiral.getId() == idEspiral) {
				espiral.setQuantidade(espiral.getQuantidade() - quantidade);
				setSaldoCliente(getSaldoCliente() - (quantidade * espiral.getPreco()));
				if(getSaldoCliente() > 0) {
					return true;
				}
			}
		}
		throw new Exception("Erro | Id não encontrado!");
	}
	
	public float troco() {
		return getSaldoCliente();
	}
	

	@Override
	public String toString() {
		return "Saldo: " + this.getSaldoCliente();
	}
	
}

