package stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Hooks {
    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("After All");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @After
    public void afterTest() {
        System.out.println("After Test");
    }
}
