/**
 * The {@code Help} class implements the {@link interfaces.Command} interface to handle the execution
 * of the "help" command, providing information about available commands.
 */
package commandManager.command;

import interfaces.Command;

public class Help implements Command {

    /**
     * Executes the "help" command, displaying information about available commands and their usage.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    @Override
    public void execute(String[] args) {
        System.out.println('\n' + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("help - вывести справку по доступным командам");
        System.out.println("info - вывести информацию о коллекции");
        System.out.println("show - вывести все элементы коллекции в строковом представлении");
        System.out.println("add {element} - добавить новый элемент в коллекцию");
        System.out.println("update id {element} - обновить значение элемента коллекции, id которого равен задванному");
        System.out.println("remove_by_id id - удалить элемент из коллекции по его id");
        System.out.println("clear - очистить коллекцию");
        System.out.println("save - сохранить коллекцию в файл");
        System.out.println("execute_script file_name - считать и исполнить скрипт из указанного файла");
        System.out.println("exit - завершить программу");
        System.out.println("remove_first - удалить первый элемент из коллекции");
        System.out.println("remove_last : удалить последний элемент из коллекции");
        System.out.println("history : вывести последние 10 команд (без их аргументов)");
        System.out.println("sum_of_annual_turnover : вывести сумму значений поля annualTurnover для всех элементов коллекции");
        System.out.println("count_less_than_annual_turnover annualTurnover : вывести количество элементов, значение поля annualTurnover которых меньше заданного");
        System.out.println("print_field_descending_annual_turnover : вывести значения поля annualTurnover всех элементов в порядке убывания");
        System.out.println();
    }
}