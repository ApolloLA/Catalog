package org.example;

public abstract class AbstractBusinessLogic implements BusinessLogic{
    private WorkWithDBImpl workWithDBImpl = new WorkWithDBImpl();

    protected WorkWithDBImpl getWorkWithDBImpl() {
        return workWithDBImpl;
    }
}
