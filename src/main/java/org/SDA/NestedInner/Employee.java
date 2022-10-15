package org.SDA.NestedInner;

public class Employee {
    private final Identity identity;
    private String role;
    private String department;
    private Integer salary;

    public Employee(Integer id, String firstName, String surName, Integer yearBorn, String role, String department, Integer salary) {
        this.identity = new Identity(id, firstName, surName, yearBorn);
        this.role = role;
        this.department = department;
        this.salary = salary;
    }

    public Identity getIdentity() {
        return identity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public class Identity {
        private final Integer id;
        private final String firstName;
        private final String surName;
        private final Integer yearBorn;

        public Identity(Integer id, String firstName, String surName, Integer yearBorn) {
            this.id = id;
            this.firstName = firstName;
            this.surName = surName;
            this.yearBorn = yearBorn;
        }

        public Integer getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSurName() {
            return surName;
        }

        public Integer getYearBorn() {
            return yearBorn;
        }
    }
}
