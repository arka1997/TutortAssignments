package com.OracleHealth.composite_pattern.Classes;

import com.OracleHealth.composite_pattern.Interfaces.Deposition;
import com.OracleHealth.composite_pattern.Interfaces.Withdrawing;

public class Transactions implements Deposition, Withdrawing {
    @Override
    public void deposit(int debitAmnt) {

    }

    @Override
    public void withdraw(int creditAmnt) {

    }
}
