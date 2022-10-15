package org.SDA.NestedInner;

public class NestedInnerExample {
    public static void example() {
         Employee employee = new Employee(1, "Mateusz", "Zawistowski",
                 1999, "IT Trainer", "SDA", 10000000);

         System.out.println(employee.getIdentity().getFirstName());
    }
}
