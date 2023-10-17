package com.OracleHealth.CompositePattern.Classes;

import com.OracleHealth.CompositePattern.Interfaces.Deposition;
import com.OracleHealth.CompositePattern.Interfaces.Withdrawing;

public class Transactions implements Deposition, Withdrawing {
    @Override
    public void deposit(int debitAmnt) {

    }

    @Override
    public void withdraw(int creditAmnt) {

    }
}
