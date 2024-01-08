//package com.studentapp.jUnit.studentInfo;
//
//import io.restassured.RestAssured;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.serenitybdd.rest.SerenityRest;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//
////start app:
////docker run -p 8085:8080 -d tejasn1/student-app
//
//@RunWith(SerenityRunner.class)
//public class FirstSerenityTestCase {
//    @BeforeClass
//    public void init(){
//        RestAssured.baseURI="http://localhost:8085/student/";
//    }
//    @Test
//    public void get_all_students(){
//        SerenityRest.given()
//        .when()
//        .get("/list")
//        .then()
//        .log().all()
//        .statusCode(200);
//    }
//    @Test
//    public void this_is_a_failed_test() {
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(500);
//    }
//    @Test
//    public void thisIsAPendingTest() {
//            SerenityRest.given()
//                    .when()
//                    .get("/list")
//                    .then()
//                    .log().all()
//                    .statusCode(200);
////            throw new PendingException("Implement me");
//        }
//        @Ignore
//        @Test
//    public void thisIsASkippedTest() {
//            SerenityRest.given()
//                    .when()
//                    .get("/list")
//                    .then()
//                    .log().all()
//                    .statusCode(200);
//        }
//        @Test
//    public void thisIsAErrorTest () {
//        System.out.println("Error in console" + (5/0));
//    }
//    @Test
//    public void fileDoesNotExist () throws FileNotFoundException {
//        File file = new File("C:/pathtest/file.txt");
//        FileReader fr = new FileReader(file);
//        throw new FileNotFoundException("Compromised");
//    }
//    @Test
//    public void manualTest () {
//    }
//    }
