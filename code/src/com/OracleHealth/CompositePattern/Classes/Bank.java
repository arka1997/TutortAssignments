package com.OracleHealth.CompositePattern.Classes;

import com.OracleHealth.CompositePattern.Interfaces.Authentication;
import com.OracleHealth.CompositePattern.Interfaces.Deposition;
import com.OracleHealth.CompositePattern.Interfaces.Withdrawing;

public class Bank implements Authentication, Deposition, Withdrawing {
    private Transactions a;
    @Override
    public void authenticate() {

    }

    @Override
    public void deposit(int debitAmnt) {
        authenticate();
        a.deposit(debitAmnt);
    }

    @Override
    public void withdraw(int creditAmnt) {
        authenticate();
        a.withdraw(creditAmnt);
    }
}
