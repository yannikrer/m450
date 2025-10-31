import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TodoRepository repo = new TodoRepository();
        TodoService service = new TodoService(repo);
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== TODO APP ====");
        boolean running = true;

        while (running) {
            System.out.println("\nMenü:");
            System.out.println("1 - Neues Todo hinzufügen");
            System.out.println("2 - Alle Todos anzeigen");
            System.out.println("3 - Todo als erledigt markieren");
            System.out.println("4 - Beenden");
            System.out.print("Auswahl: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Beschreibung eingeben: ");
                    String desc = scanner.nextLine();
                    TodoItem newItem = service.addTodo(desc);
                    System.out.println("Todo hinzugefügt: " + newItem.getDescription());
                    break;

                case "2":
                    System.out.println("\nAktuelle Todos:");
                    for (TodoItem item : service.getAllTodos()) {
                        System.out.printf("%d: %s [erledigt=%s]%n",
                                item.getId(), item.getDescription(), item.isDone());
                    }
                    break;

                case "3":
                    System.out.print("ID des Todos zum Erledigen: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    service.markAsDone(id);
                    System.out.println("Todo #" + id + " wurde als erledigt markiert.");
                    break;

                case "4":
                    running = false;
                    System.out.println("Beende Programm...");
                    break;

                default:
                    System.out.println("Ungültige Eingabe!");
            }
        }

        scanner.close();
    }
}
