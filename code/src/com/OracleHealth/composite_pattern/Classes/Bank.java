package com.OracleHealth.composite_pattern.Classes;

import com.OracleHealth.composite_pattern.Interfaces.Authentication;
import com.OracleHealth.composite_pattern.Interfaces.Deposition;
import com.OracleHealth.composite_pattern.Interfaces.Withdrawing;

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
