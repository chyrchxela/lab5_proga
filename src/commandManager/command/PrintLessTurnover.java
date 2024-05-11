/**
 * The {@code RemoveLower} class implements the {@link interfaces.Command} interface to handle the execution
 * of the "remove_lower" command, removing organizations from the collection managed by
 * {@link dataManager.OrganizationManager} with annual turnover lower than the specified organization.
 */
package commandManager.command;

import dataManager.OrganizationManager;
import input.CollectionInput;
import input.MyInputStream;
import interfaces.Command;
import organization.Organization;

import java.util.ArrayList;

public class PrintLessTurnover implements Command {
    private int count = 0;

    /**
     * Executes the "remove_lower" command, removing organizations from the collection
     * with annual turnover lower than the specified organization.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    @Override
    public void execute(String[] args) {
        // Get the collection of organizations
        ArrayList<Organization> dec = OrganizationManager.getInstance().getCollection();

        // Input information for the organization to compare
        Organization organization = CollectionInput.organizationInput(new MyInputStream());

        // Iterate through organizations and add those with higher annual turnover to the new collection
        for (Organization org : dec) {
            if (org.getAnnualTurnover() > organization.getAnnualTurnover()) {
                count ++;
            }
        }

        System.out.println("Количество орагнизаций с годовым оборотом меньше " + organization.getAnnualTurnover() + ": " + count);
    }
}