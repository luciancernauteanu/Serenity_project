//package com.studentapp.jUnit.studentInfo;
//
//import io.restassured.RestAssured;
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.serenitybdd.rest.SerenityRest;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
////start app:
////docker run -p 8085:8080 -d tejasn1/student-app
//
//@RunWith(SerenityRunner.class)
//public class SerenityIdInfo {
//    @BeforeClass
//    public static void init(){
//        RestAssured.baseURI="http://localhost:8085/student/";
//    }
//    @Test
//    public void get_all_students(){
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//    @Test
//    public void this_is_a_failed_test() {
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//    @Test
//    public void thisIsAPendingTest() {
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//    @Ignore
//    @Test
//    public void thisIsASkippedTest() {
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//
//    @Test
//    public void manualTest () {
//
//    }
//    @Test
//    public void test01(){
//        SerenityRest.given()
//                .when()
//                .get("/list")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//}
//
