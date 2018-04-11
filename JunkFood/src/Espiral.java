
public class Espiral {
	
	private String nome;
	private int quantidade;
	private float preco;
	private int id;
	private static int nextId;
	
	public Espiral(String nome, int quantidade, float preco) {
		//=============================================== Verificar se vai zerar caso não exista nenhum produto
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.id = nextId;
		nextId++;
	}
	
	public Espiral () {
		this.nome = " - ";
		this.quantidade = 0;
		this.preco = 0;
		this.id = nextId;
		nextId++;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " Índice: " + this.id + " ,Nome: " + this.nome + " ,Quantidade: " + this.quantidade + " U" + " ,Preço: " + this.preco + " RS";
	}

}