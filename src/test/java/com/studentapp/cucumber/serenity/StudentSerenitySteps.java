package com.studentapp.cucumber.serenity;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.junit.annotations.Concurrent;

import java.util.HashMap;
import java.util.List;

@Concurrent(threads = "10x")
public class StudentSerenitySteps {
        @Step("Creating a new student with firstName:{0},lastName:{1}, email:{2},programme:{3},course:{4}")
    public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme, List<String> courses) {

        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        return SerenityRest
                .rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when()
                .body(student)
                .post()
                .then()
                .log()
                .all();
    }

        @Step("Get a specific user info by his firstName:{0}")
    public HashMap<String, Object> getUserInfoByFirstName(String firstName) {
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";
        return SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);
    }

        @Step("Updating a student with ID:{0},firstName:{1}, lastName:{2}, email:{3}, programme:{4}, courses:{5}")
    public void updateStudentInfo(int studentID, String firstName, String lastName, String email, String programme, List<String> courses) {

        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        SerenityRest.rest()
                .given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .log()
                .all()
                .when()
                .body(student)
                .put("/" + studentID)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

        @Step("Delete latest student with id:{0}")
    public void deleteStudent(int studentID) {
        SerenityRest
                .rest()
                .given()
                .when()
                .delete("/" + studentID)
                .then();
    }

        @Step("deleted student and verify it is deleted")
    public ValidatableResponse getDeleteStudentInfo(int studentID) {
        return SerenityRest
                .rest()
                .given()
                .when()
                .get("/" + studentID)
                .then();

    }
}