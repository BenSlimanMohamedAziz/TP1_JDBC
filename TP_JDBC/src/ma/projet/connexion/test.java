package ma.projet.connexion;

public class test {

	public static void main(String[] args) {
		
		connexion.getCon();
		ClientService clientService = new ClientService();
		
		
		clientService.create(new client("Ahmed", "Ahmed"));
		
		System.out.println(clientService.findById(1));
		
		clientService.delete(clientService.findById(18));
		
		client c =new client(2,"Aziz","Aziz");
		
		clientService.update(c);
		
		System.out.println(clientService.findAll());
		
	}

}
