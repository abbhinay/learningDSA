package com.company;

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode nextNode;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(EmployeeNode nextNode) {
        this.nextNode = nextNode;
    }

//    @Override
//    public String toString() {
//        return "EmployeeNode{" +
//                "employee=" + employee +
//                ", nextNode=" + nextNode +
//                '}';
//    }

    public String toString() {
        return employee.toString();
    }
}
