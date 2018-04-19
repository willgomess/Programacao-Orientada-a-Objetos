
import java.util.ArrayList;
import java.util.Scanner;

class Cliente{
	public String id;
	public String name;
	public String forma = "vive";
	public float saldo_cliente = 0;
	public float saldo;
	
	public Cliente(String idCliente, String name) {
		this.id = idCliente;
		this.name = name;
	}
	
	public String mostrarSaldo() {
		return "nome: "+name + "saldo: "+saldo_cliente + "\n";
	}
	
	public String toString() {
		return " "+name +";"+id +" "+forma +"\n"; 
	}
	
}

class Velhaco{
	public String name;
	public float valor_divida;
	public int id = 0;
	public float total = 0;
	
	
	public Velhaco(String name, float valor, int id) {
		this.name = name;
		this.valor_divida = valor;
		this.id = id;
		this.total = valor_divida + total;
	}
	
	public String toString() {
		return  "id: " + id + "nome: " + name +"valor: " + valor_divida +"\n";
	}
}

class Programa{
	public float money;
	public float saldo = 0;
	public int transacao = 0;
	public int id = 0;
	
	ArrayList<Cliente> clientes;
	ArrayList<Velhaco> velhacos;
	
	public Programa(float money) {
		this.money = money;
		clientes = new ArrayList<Cliente>();
		velhacos =  new ArrayList<Velhaco>();
		saldo = saldo + money;
	}
	
	public String toString() {
		return "O programa foi inicializado com: " +saldo+" " +clientes.toString() +"\n";
	}
	
	public void addClientes(String name, String idCliente) {
		for (Cliente c : clientes)
			if (c.name.equals(name))
				throw new RuntimeException("ERRO | Cliente já foi cadastrado!!");

		
		clientes.add(new Cliente(idCliente, name));
	}
	
	public void devendo(String name, float valor) {
		   if(valor<=saldo) {
			  saldo = saldo + valor;
		      this.velhacos.add(new Velhaco(name,valor,id));
		      id++;
		      return;
		   }
		   else
			   throw new RuntimeException ("ERRO | Saldo insuficiente!!");
		   
		}
	
	public void emprestaDinheiro(String name, float valor) {
		for (Cliente c : clientes)
			if (c.name.equals(name)) { 
				c.saldo = valor + c.saldo;
				this.devendo(name, valor);
		        return;
	        }		
		throw new RuntimeException("ERRO | Cliente ou saldo do cliente é inválido!!");
	}
	
	public String mostrarClientes() {
    	String exit =  "";
    	for(int i = 0; i < clientes.size(); i++)
    	   exit += ""+ this.clientes.get(i).mostrarSaldo();
    	return exit;
    }
	
	public String mostrarVelhacos() {
		 return "" + velhacos.toString();
	}
	
	public void mostrarVelhacoMaster(String name) {
		int i = 0;
		for (Cliente c : clientes) {
			if (c.name.equals(name)) {
				System.out.println(c.mostrarSaldo());
				while( velhacos.get(i).name.equals(name)) {
					       System.out.println( velhacos.get(i).toString());
		                   i++;       
				}
			}
		return;
		}
	    throw new RuntimeException("ERRO | Cliente não encontrado!!");
	}
	
	public void pagamento(String name, float valor) {
		for (Cliente c : clientes)
			if (c.name.equals(name)) {
				if (c.saldo < 0) {
					c.saldo = saldo + valor;
					money = money + valor;
					this.velhacos.add(new Velhaco(name, valor, id));
					id++;
					return;
				}
			}
		throw new RuntimeException("ERRO | Cliente não foi encontrado!!");
	}
	
	public void kill(String name) {
		for( int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).name.equals(name)) {
				this.clientes.remove(clientes.get(i));
				pagou_morreu(name);
		        return;
			}
		}		
		throw new RuntimeException("ERRO | Cliente não foi encontrado!!");
	}
	
	public void pagou_morreu( String name) {
		for(int i = 0 ; i<velhacos.size(); i++) {
			if(velhacos.get(i).name.equals(name))
				this.velhacos.remove(velhacos.get(i));
			    i--;
		}
	}
	
}

class Controller{
	Programa pro;
	Scanner sca;
	
	public Controller() {
 		sca = new Scanner(System.in); 		
 	}
	
	public String query(String line) {
 		String[] ui = line.split(" ");
 		
 	    if (ui[0].equals("init"))
 			pro = new Programa(Float.parseFloat(ui[1]));
 	    else if (ui[0].equals("show"))
 			return " " + pro ;
 	    else if(ui[0].equals("addCliente"))
 	    	pro.addClientes(ui[1],ui[2]);
 	    else if(ui[0].equals("mostrarVelhacos"))
 	    	return "" + pro.mostrarVelhacos() ;
 	    else if(ui[0].equals("emprestaDinheiro"))
 	    	pro.emprestaDinheiro(ui[1],Float.parseFloat(ui[2]));
 	    else if(ui[0].equals("mostrarClientes"))
 	    	return ""+ pro.mostrarClientes();
 	    else if(ui[0].equals("mostrarVelhacoMaster"))
 	        pro.mostrarVelhacoMaster(ui[1]);
 	    else if(ui[0].equals("pagamento"))
 	    	pro.pagamento(ui[1],Float.parseFloat(ui[2]));
 	    else if(ui[0].equals("kill"))
 	    	pro.kill(ui[1]);
 	    else
 	    	return " ERRO | Comando inválido!!";
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




