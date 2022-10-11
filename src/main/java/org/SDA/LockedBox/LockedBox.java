package org.SDA.LockedBox;

public class LockedBox<TValue, TPassword> {
    private final TPassword password;
    private TValue value;

    public LockedBox(TPassword password, TValue value) {
        this.password = password;
        this.value = value;
    }

    public TValue getValue(TPassword password) {
        if (this.password.equals(password)) {
            return value;
        }
        else {
            return null;
        }
    }

    public void setValue(TPassword password, TValue newValue) {
        if (this.password.equals(password)) {
            this.value = newValue;
        }
    }

    public static void example() {
        LockedBox<Integer, String> box = new LockedBox<>("zaq1", 42);

        System.out.println(box.getValue("zaq1"));

        LockedBox<String, Integer> stringBox = new LockedBox<>(400, "Super Secret String");
        System.out.println(stringBox.getValue(400));

        LockedBox<LockedBox<Integer, String>, String> boxception = new LockedBox<>("inception", box);

        System.out.println(boxception.getValue("inception").getValue("zaq1"));
    }
}
