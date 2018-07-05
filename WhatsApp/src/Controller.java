import java.util.Scanner;

public class Controller {
		
		Scanner sca;
		Repositorio<User> users;
		Repositorio<Chat> grupos;
		int indicemensagem = 0;
		
	public Controller() {
		sca = new Scanner(System.in);
		users = new Repositorio<User>("usuarios");
	    grupos = new Repositorio<Chat>("grupos");
	}

	public String query(String line) {
		String[] ui = line.split(" ");

		
		if (ui[0].equals("addUser")) 
			users.add(ui[1], new User(ui[1]));
		else if(ui[0].equals("allUser")) {
			String saida="[ ";
			for(User us : users.getAll())
				saida+= us.toString() + " ";
			return saida + "]";
		}
		else if(ui[0].equals("newChat")) {
			users.get(ui[1]).getGrupos().add(ui[2], new Chat(ui[2]));
		    grupos.add(ui[2],new Chat(ui[2]));
		    grupos.get(ui[2]).userChats.add(ui[1], users.get(ui[1]));
		}
		else if(ui[0].equals("enviarMensagem")) {
			indicemensagem++;
			String texto = "";
		    for(int i = 3 ; i<ui.length; i++)
		    	texto += ui[i] + " ";
		    grupos.get(ui[1]).escrever(new Mensagem(""+indicemensagem,users.get(ui[2]).getIdUser(),texto));
		}
		else if(ui[0].equals("lerGrupo")) {
			System.out.println(users.get(ui[1]).getGrupos().get(ui[2]).mostrarSms(users.get(ui[1]).getIdUser()));
		}
		else if(ui[0].equals("invite")) {
			users.get(ui[1]).getGrupos().get(ui[2]).adicionarAoGrupo(users.get(ui[3]));
			grupos.get(ui[2]).userChats.add(ui[3], users.get(ui[3]));
		}
		else if(ui[0].equals("sairDoGrupo")) {
			users.get(ui[1]).getGrupos().remove(grupos.get(ui[2]).getChat());
			grupos.get(ui[2]).getUserchats().remove(ui[1]);
			grupos.get(ui[2]).escrever(new Mensagem(""+indicemensagem, users.get(ui[1]).getIdUser(), "saiu"));
		}
		else if(ui[0].equals("chats"))
			System.out.println(users.get(ui[1]).mostrarGroups());
		else if(ui[0].equals("myUsers"))
			System.out.println(grupos.get(ui[1]).mostrarUsers());
		else if(ui[0].equals("showGrupos")) {
			String saida = "";
			for(Chat c : grupos.getAll())
				saida += c.toString();
			return saida;
		}
		else if(ui[0].equals("mensagemdogrupo")) {
			String saida = "";
			for(Mensagem m : grupos.get(ui[1]).sms.getAll())
				saida += m + " ";
			return saida;
		}
		else if(ui[0].equals("mostrarnotific")) {
			String saida="";
			for(Chat c : users.get(ui[1]).getGrupos().getAll()) {
				saida+= c.getChat() + "(" + users.get(ui[1]).contagem(c)+ ")";
			}
			return saida;
		}
		else
			return " Comando invalido";
		return "done";
	}

		public void shell() {
			while (true) {
				String line = sca.nextLine();
				try {
					System.out.println(query(line));
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
			}
		}
		
		public static void main(String[] args) {
	        Controller c = new Controller();
	        c.shell();
	    }
	  
	}