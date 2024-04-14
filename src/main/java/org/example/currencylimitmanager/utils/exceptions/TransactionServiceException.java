package org.example.currencylimitmanager.utils.exceptions;

public class TransactionServiceException  extends RuntimeException {
    public TransactionServiceException(String message){
        super(message);
    }
}
