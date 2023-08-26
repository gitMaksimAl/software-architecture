package Lesson_3;

import java.util.Date;

public class SRP {
    public class Employee {
        private String Name;
        private Date DOB;

        public Employee(String name, Date bday) {
            this.Name = name;
            this.DOB = bday;
        }

        @Override
        public String toString() {
            return String.format("%s: barthday - %s",
                this.Name, this.DOB);
        }
    }

    public class EmployeeSalary {
    
        private int BaseSalary;

        public EmployeeSalary(int salary) {
            this.BaseSalary = salary;
        }

        public int calculateSalary() {
            int tax =  (int)(this.BaseSalary * 0.25);
            return tax;
        }
    }
}
