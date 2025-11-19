package com.bank.core;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
    private final LocalDateTime date;
    private final TransactionType type;
    private final BigDecimal amount;
    private final BigDecimal resultingBalance;

    public Transaction(TransactionType type, BigDecimal amount, BigDecimal resultingBalance){
        this.date=LocalDateTime.now();
        this.type=type;
        this.amount=amount;
        this.resultingBalance=resultingBalance;
    }
        @Override
        public String toString(){
            return String.format("[%s]%s:%s(Balance:%s)",
            date,type,amount,resultingBalance);
        }
}

