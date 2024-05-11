/**
 * The {@code CommandInvoker} class is responsible for handling and invoking commands in the application.
 * It maintains a mapping of command names to their corresponding {@link interfaces.Command} implementations.
 * It also provides a method for accepting and processing user input commands.
 */
package commandManager;

import commandManager.command.*;
import input.MyInputStream;
import interfaces.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CommandInvoker {

    final Map<String, Command> commands;

    /**
     * Constructs a new instance of {@code CommandInvoker} and initializes the mapping of command names to commands.
     */
    public CommandInvoker() {
        commands = new HashMap<>();
        commands.put("add", new Add());
        commands.put("exit", new Exit());
        commands.put("help", new Help());
        commands.put("show", new Show());
        commands.put("clear", new Clear());
        commands.put("update", new Update());
        commands.put("remove_by_id", new Remove());
        commands.put("remove_first", new RemoveFirst());
        commands.put("print_field_descending_annual_turnover", new PrintAnnualturnover());
        commands.put("count_less_than_annual_turnover annualTurnover", new PrintLessTurnover());
        commands.put("sum_of_annual_turnover", new SumTurnover());
        commands.put("save", new Save());
        commands.put("execute_script", new ExecuteScript(commands));
        commands.put("info", new Info());
    }

    /**
     * Reads and processes user input commands in an infinite loop.
     */
    public void inputCommands() {
        MyInputStream scanner = new MyInputStream();
        String[] tok = new String[]{"help"};
        commands.get(tok[0]).execute(tok);

        while (true) {
            String line = MyInputStream.Scan();
            String[] tokens = line.split(" ");

            try {
                Command command = commands.get(tokens[0]);
                command.execute(tokens);
            } catch (NoSuchElementException e) {
                System.out.println("Команда введена некорректно, повторите ввод");
            } catch (NullPointerException e) {
                System.out.println();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}