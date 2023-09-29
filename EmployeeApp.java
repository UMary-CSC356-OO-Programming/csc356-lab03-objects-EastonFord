import java.util.Scanner; // Import Scanner

class Employee
{
    /* Task 3B: Add instance variables */
    private String firstName;
    private String lastName;
    private int employeeId;
    private double salary;

    /* Task 3C: Add three constructors */
    public Employee()
    {
        this.firstName = "";
        this.lastName = "";
        this.employeeId = 0;
        this.salary = 0.0;
    }
    public Employee( String lastName, String firstName )
    {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Employee( String lastName, String firstName, int employeeId, double salary )
    {
        this(lastName, firstName);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    /* Task 3D: Add mutator and accessor methods for setting and getting info */
    public void setFirstName(String inputString)
    {
        this.firstName = inputString;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setLastName(String inputString)
    {
        this.lastName = inputString;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setEmployeeId(int inputInt)
    {
        this.employeeId = inputInt;
    }
    public int getEmployeeId()
    {
        return employeeId;
    }
    public void setSalary(double inputDouble)
    {
        this.salary = inputDouble;
    }
    public double getSalary()
    {
        return Math.round(salary * 100.0) / 100.0;
    }

    /* Task 3F: Add toString method that returns the formatted string for outputting the list */
    public String toFormattedString()
    {
        return (""+getFirstName()+", "+getLastName()+"\n\tID Number: "+getEmployeeId()+"\n\tSalary: $"+getSalary());
    }

    /* Task 3G: Add equals method that returns true if the names match */
    public Boolean equals( String name )
    {
        return this.lastName.equalsIgnoreCase(name);
    }
}

public class EmployeeApp{
    public static final int MAX_EMPLOYEES = 5; // Declare max employees as a constant

    public static void main(String[] args)
    {
        // Initialize variables
        Scanner keyboard = new Scanner( System.in );
        Employee[]  employees = new Employee[MAX_EMPLOYEES];
        String      inputString;
        int         inputInt;
        double      inputDouble;
        char        choice;
        int         empCount=0;
        int         noMatch;

        // Set default employees to the following information
        employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
        employees[empCount++] = new Employee( "Ryan", "Cornelius" );
        employees[empCount++] = new Employee( "Asimov", "Isaac" );

        // Do while loop to go through the switch statement until the user enters 'q'
        do
        {
            // Output the instructions for the user
            System.out.println( "\n   Enter Selection\n   ===============" );
            System.out.println( "A> Add new Employee" );
            System.out.println( "E> Edit Employee" );
            System.out.println( "L> List Employees" );
            System.out.println( "Q> Quit" );
            System.out.print(  "   Select: " );
            inputString = keyboard.nextLine();
            choice = inputString.toUpperCase().charAt( 0 );
            System.out.println();

            switch( choice )
            {
                // Add new employee case that allows the user to enter info for a new employee
                case 'A':
                    // Check if the employee count has reached the max
                    if ( empCount < MAX_EMPLOYEES )
                    {
                        // Create object for new Employee
                        employees[empCount] = new Employee();

                        // Task 3E: Prompt for user information and set the object
                        // parameters via the mutator methods
                        System.out.print("Enter First Name of new Employee: ");
                        inputString = keyboard.nextLine();
                        employees[empCount].setFirstName(inputString);
                        System.out.print("Enter Last Name of new Employee: ");
                        inputString = keyboard.nextLine();
                        employees[empCount].setLastName(inputString);
                        System.out.print("Enter Employee ID of new Employee: ");
                        inputInt = keyboard.nextInt();
                        employees[empCount].setEmployeeId(inputInt);
                        System.out.print("Enter Salary of new Employee: ");
                        inputDouble = keyboard.nextDouble();
                        employees[empCount].setSalary(inputDouble);

                        keyboard.nextLine();
                        empCount++;
                    } else
                    {
                        System.out.println("Maximum number of employees reached.");
                    }
                    break;

                // Edit employee case that allows the user to enter new ID and salary for an employee
                case 'E':
                    noMatch = 0;
                    // Get the last name of an employee from the user
                    System.out.print( "Enter Last Name of Employee to Edit: " );
                    inputString = keyboard.nextLine();
                    // For loop to check against each employee last name
                    for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
                    {
                        // Verify that the employee entry has been allocated before Editing
                        if ( employees[lp] != null )
                        {
                            // If there is a match, prompt the user for employee ID and salary
                            if ( employees[lp].equals( inputString ) == true )
                            {
                                System.out.print( "Enter Employee ID    : " );
                                inputInt = keyboard.nextInt();
                                employees[lp].setEmployeeId( inputInt );

                                System.out.print( "Enter Employee Salary: " );
                                inputDouble = keyboard.nextDouble();
                                employees[lp].setSalary( inputDouble );

                                keyboard.nextLine();
                                break;
                            }
                        }
                        noMatch++; // This increases if there is no match
                    }
                    // If the no match counter reaches max employees, it means there was no match
                    if(noMatch==MAX_EMPLOYEES)
                    {
                        System.out.println("Employee last name has no match.");
                    }
                    break;

                // List employees case that calls the to formatted string method for each of the employees that aren't null
                case 'L':
                    for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
                    {
                        if (employees[lp] != null)
                        {
                            System.out.println(employees[lp].toFormattedString());
                        }
                    }
                    break;

                // Default case will output that an invalid selection was entered
                default:
                    System.out.println("Invalid Selection.");
                    break;
            }

        } while( choice != 'Q' ); // If the selection is ever 'q', then quit
    }
}
