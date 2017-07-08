package observer;

import java.time.*;

public class Main {

	public static void main(String[] args) {
		Benutzer user_mar = new Benutzer(1, "Mario", "Kellner");
		Benutzer user_meh = new Benutzer(1, "Mehmet", "Tuefekci");
		Benutzer user_jul = new Benutzer(1, "Julian", "Kranen");
		
		Auktion laptop = new Auktion(1, "Ultra geiler Laptop", "Mega geiler Laptop mit Pentium 4 Prozessor", LocalDateTime.of(2017, Month.JULY, 05, 12, 30));
		
		user_meh.addTobeobachtungsListe(laptop);
		user_jul.addTobeobachtungsListe(laptop);

		laptop.setzeGebot(user_meh, 15.51f);
		
		laptop.setzeGebot(user_meh, 16f);
		
		laptop.setzeGebot(user_jul, 18.99f);
		
		laptop.setzeGebot(user_mar, 49.99f);
		
		laptop.setzeGebot(user_meh, 99.99f);	
	}
}