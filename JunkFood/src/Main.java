import java.util.Scanner;

public class Main {
	
	public static void help() {
		System.out.println("------------------------------- MENU ----------------------------------\n"
						 + "                                                                        \n"
						 + "  - iniciar                      |   Inicia a máquina\n"
						 + "  - set                          |   altera ou informa os valores de um espiral\n"
						 + "  - show                         |   Imprime os espirais\n"
						 + "  - reset                        |   Reseta os valores de um espiral\n"
						 + "  - dinheiro                     |   Deposita o dinheiro na conta do cliente\n"
						 + "  - vender                       |   Compra um produto\n"
						 + "  - sair                         |   Encerra as atividades de um sistema\n");
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Maquina maquina = null;
		
		boolean sair = false;
		
		while(!sair) {
			
			System.out.print(">>");
			
			String opicao = input.nextLine();
			
			switch(opicao) {
				
				case "help":
					help();
				break;
				case "iniciar":
					
					System.out.print("Informe a quantidade de espirais: ");
					int limiteDeEspirais = input.nextInt();
					System.out.print("Informe o máximo de produtos: ");
					int maximoDeProdutos = input.nextInt();
					
					maquina = new Maquina(limiteDeEspirais, maximoDeProdutos);
					System.out.println("Máquina inicializada!");
				
				break;
				case "set":
					
					System.out.print("Informe o id do espiral: ");
					int id = Integer.parseInt(input.nextLine());
					System.out.print("Informe o nome: ");
					String nome = input.nextLine();
					System.out.print("Informe a quantidade: ");
					int quantidade = Integer.parseInt(input.nextLine());
					System.out.print("Informe a preço: ");
					float preco = Float.parseFloat(input.nextLine());

					
					try {
						maquina.alterarEspiral(id, new Espiral(nome,quantidade,preco));
						System.out.println("Alterado!");
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				break;
				case "show":
					
					System.out.println(maquina.toString());
					
					for (Espiral e : maquina.getEspirais()) {
						System.out.println(e);
					}
				
					
				break;
				case "reset":
					
					System.out.print("Informe o ID: ");
					int idEspiral = Integer.parseInt(input.nextLine());
					
					try {
						
						maquina.resetarEspiral(idEspiral);
						System.out.println("Resetado");
						
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				break;
				case "dinheiro":
					
					System.out.print("Deposite o dinheiro: ");
					float dinheiro = Float.parseFloat(input.nextLine());
					
					try {
						
						maquina.incerirDinheiro(dinheiro);
						System.out.println("Done!");
						
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				break;
				case "vender":
					
					System.out.print("Informe o id do espiral: ");
					int idEspi = Integer.parseInt(input.nextLine());
					System.out.print("Informe a quantidade do produto que deseja comprar: ");
					int qtd = Integer.parseInt(input.nextLine());
					
					try {
						
						maquina.vender(idEspi, qtd);
						System.out.println("Vendido!");
						
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				break;
				case "troco":
					System.out.println(maquina.troco());
				break;
				case "sair":
					sair = true;
				break;
			}
			
		}
		
	}

}