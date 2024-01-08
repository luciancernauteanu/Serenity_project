package com.studentapp.jUnit.studentIDInfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTagValuesOf;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

    @WithTags({
        @WithTag("studentFeature:NEGATIVE")
    })
    @Test
    @Title("Provide a 405 status code when incorrect HTTP method is used to access a resource")
    public void invalidMethod() {
        SerenityRest.rest().given().when().post("/list").then().statusCode(405).log().all();
    }

    @WithTags({
            @WithTag("studentFeature:SMOKE"),
            @WithTag("studentFeature:POSITIVE")
    })
    @Test
    @Title("Test will verify if a status code 200 is returned for a GET request")
    public void verifyIfStatusIs200() {
        SerenityRest.rest().given().when().get("/list").then().statusCode(200).log().all();
    }

    @WithTags({
            @WithTag("studentFeature:SMOKE"),
            @WithTag("studentFeature:NEGATIVE")
    })
    @Test
    @Title("Test will provide an status code of 400 when use tries to access and invalid resource")
    public void incorrectResource() {
        SerenityRest.rest().given().when().get("/listgd").then().statusCode(400).log().all();
    }
}
