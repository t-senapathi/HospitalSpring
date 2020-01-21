package global.coda.hms.model;

import javax.persistence.*;

/**
 * The type Employee.
 */
@Entity
@Table(name = "t_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * The Id.
     */
    int id;
    @Column(name = "first_name")
    /**
     * The First name.
     */
    String firstName;
    @Column(name = "last_name")
    /**
     * The Last name.
     */
    String lastName;

    /**
     * Instantiates a new Employee.
     */
    public Employee() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
