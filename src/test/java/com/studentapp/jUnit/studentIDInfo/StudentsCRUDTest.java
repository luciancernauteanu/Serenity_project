package com.studentapp.jUnit.studentIDInfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {
    static String firstName = "SMOKEUSER" + TestUtils.GetRandomValue();
    static String lastName = "SMOKEUSER" + TestUtils.GetRandomValue();
    static String programme = "ComputerScience" + TestUtils.GetRandomValue();
    static String email = TestUtils.GetRandomValue() + "test@gmail.com";
    public static int studentID;
    @Steps
    StudentSerenitySteps steps;

    @Title("Create a new student")
    @Test
    public void testCase01() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("C++");
        steps.createStudent(firstName, lastName, email, programme, courses).statusCode(201).spec(ReusableSpecifications.getGenericResponseSpec());
    }

    @Title("Retrieve a student's first name")
    @Test
    public void testCase02() {
        HashMap<String, Object> value = steps.getUserInfoByFirstName(firstName);
        System.out.println("The value is:" + value);
        studentID = (int) value.get("id");
    }

    @Title("Update first name of a student")
    @Test
    public void testCase03() {
        firstName = firstName + "_Updated";
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Python");
        courses.add("C#");
        steps.updateStudentInfo(studentID, firstName, lastName, email, programme, courses);
    }

    @Title("Delete a student data")
    @Test
    public void testCase04() {
        steps.deleteStudent(studentID);
        steps.getDeleteStudentInfo(studentID).statusCode(404);
        }
    }