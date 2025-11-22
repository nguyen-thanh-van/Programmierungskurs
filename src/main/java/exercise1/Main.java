package exercise1;

public class Main {
	public static void main(String[] args) {
		Textbook textbook = new Textbook("Data Structures", 2020, "Jane Doe", "Computer Science");
		System.out.println(textbook.getInfo());
	}
}