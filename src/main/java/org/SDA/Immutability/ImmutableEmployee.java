package org.SDA.Immutability;

public class ImmutableEmployee {
    private final Integer id;
    private final String firstName;
    private final String surName;
    private final String role;
    private final ImmutableEmployee[] teammates;

    public ImmutableEmployee(Integer id, String firstName, String surName, String role, ImmutableEmployee[] teammates) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.role = role;
        this.teammates = teammates;
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

    public String getRole() {
        return role;
    }

    public ImmutableEmployee[] getTeammates() {
        return teammates.clone();
    }

    public static void example() {
        // Mutable objects can be modified after construction
        // Immutable objects cannot be modified after construction (have to be replaced with a new object)

        MutableEmployee mutable = new MutableEmployee(1, "Mateusz", "Zawistowski", "IT Trainer");
        mutable.setFirstName("Marcin");
        mutable.setRole("CEO");

        ImmutableEmployee immutable = new ImmutableEmployee(2, "Mateusz", "Zawistowski", "IT Trainer",
                new ImmutableEmployee[] {
                        new ImmutableEmployee(3, "X", "Y", "Z", null),
                        new ImmutableEmployee(4, "A", "B", "C", null),
                        new ImmutableEmployee(5, "D", "E", "F", null),
                        new ImmutableEmployee(6, "G", "H", "I", null)
                }
        );

        ImmutableEmployee[] teammates = immutable.getTeammates();
        teammates[0] = immutable;

        for (ImmutableEmployee e : immutable.getTeammates()) {
            System.out.printf("%s %s %s\n", e.getFirstName(), e.getSurName(), e.getRole());
        }

        System.out.println();

        for (ImmutableEmployee e : teammates) {
            System.out.printf("%s %s %s\n", e.getFirstName(), e.getSurName(), e.getRole());
        }
    }
}
