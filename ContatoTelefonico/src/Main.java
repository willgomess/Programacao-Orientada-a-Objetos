import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Contato  contact = null;
		boolean sair = false;
		
		while(sair!=true) { 
			
			System.out.print(">>");
			String opcoes = input.next();
			
			switch(opcoes) {
			case "init" :
				System.out.print("INFORME O NOME DO CONTATO: ");
				String nome = input.next();
				contact = new Contato(nome);
				System.out.println("done");
				break;
			case "show" :
				System.out.println(contact.toString());
				break;
			case "addFone" :
				System.out.print("INFORME O FONEID: ");
				String fone = input.next();
				System.out.print("INFORME O NUMERO: ");
				int num = Integer.parseInt(input.next());
				
				try {
					contact.addFone(new Telefone(fone, num));
					System.out.println("NUMERO ADICIONADO");
				}
				catch(Exception e){
					System.out.println(e.getMessage());										
				}
				break;
			case "rmFone" :
				System.out.println("INFORME O FONEID: ");
				String foneId = input.next();
				
				try {
					contact.rmFone(foneId);
					System.out.println("FONE REMOVIDO COM SUCESSO");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case "sair" :
				sair = true;
			}
		}		
		
	}
}