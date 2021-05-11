package com.trainCGI;

import java.util.Scanner;

public class Student {
    private String firstname;
    private String lastname;
    private String courseList = "";
    private int gradeYear;
    private String studentID;
    private int tuitionBalance = 0;
    private static int id = 1000;

    //Constructor to define the students name and year
    public Student() {
        Scanner in = new Scanner(System.in);

        //Get first name from user
        System.out.print("Enter student first name: ");
        this.firstname = in.nextLine();

        //Get last name from user
        System.out.print("Enter student last name: ");
        this.lastname = in.nextLine();

        //Get grade year from user
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior \nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    //Generate unique ID
    private void setStudentID(){
        //Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    //Enroll in courses
    public void enroll(){
        //Get inside a loop, user hits Q when done
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine().toUpperCase();

            if (!course.equals("Q")){
                int coursePrice = 600;
                courseList = courseList + "\n   " + course;
                tuitionBalance = tuitionBalance + coursePrice;
            }
            else{
                break;
            }
        } while(1 != 0);
    }

    //View balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition(){
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your payment: $");
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of: $" + payment);
        viewBalance();
    }

    //Show info
    public String showInfo(){
        return "\nName: " + firstname + " " + lastname +
                "\nGrade Level: " + gradeYear+
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courseList +
                "\nBalance $" + tuitionBalance + "\n";
    }
}
