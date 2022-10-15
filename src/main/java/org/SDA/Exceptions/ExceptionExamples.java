package org.SDA.Exceptions;

import org.SDA.Banking.PremiumAccount;
import org.SDA.Banking.RegularAccount;

public class ExceptionExamples {
    public static void examples() throws MyOwnCustomException {
        // NullPointerException examples
        RegularAccount account = new RegularAccount();
        account = null;

        System.out.println(account.getMoney());

        PremiumAccount premiumAccount = new PremiumAccount(10, null);
        premiumAccount.onMonthPassed();

        // ArrayIndexOutOfBoundsException example
        String[] array = new String[] { "One", "Two", "Three" };
        System.out.println(array[3]);
        getArrayElement(array, 3);

        try {
            String s = getArrayElement(null, 0);
            System.out.println(s);

            throw new MyOwnCustomException("Hello!");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given index is out of array's bounds");
        }
        catch (NullPointerException e) {
            System.out.println("Given array is null!");
        }
        catch (MyOwnCustomException e) {
            System.out.println("Wooho, my exception was thrown!");
        }
        catch (Exception e) {
            // Executes when ANY exception is thrown in the try block
            System.out.println(e.getMessage());
        }
        finally {
            // This block executes ALWAYS
            System.out.println("I will always be here!");
        }

    }

    public static String getArrayElement(String[] array, Integer index) throws ArrayIndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Index is not supposed to be of this value!");
        }
        else {
            return array[index];
        }
    }
}
