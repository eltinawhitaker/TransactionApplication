package edu.dcccd.trans.repository;


import edu.dcccd.trans.entity.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class SingletonTransaction
{
    private static SingletonTransaction instance = null;
    //trans go in and are not saved
    public List<Transaction> transactions;
    //first tran into the database
    public Long autoIncrementID = 2L;
    private SingletonTransaction()
    {
        transactions = new ArrayList<>();
        Transaction tr01 = new Transaction(1L,"REVENUE","SUNDAY", BigDecimal.valueOf(100.00), "A Revenue");
        Transaction tr02 = new Transaction(2L,"EXPENSE","SUNDAY", BigDecimal.valueOf(50.00), "A Expense");
        transactions.add(tr01);transactions.add(tr02);
    }
    //creates class above
    public static SingletonTransaction getInstance(){
        if(instance == null){
            instance = new SingletonTransaction();
        }
        return instance;
    }
}
