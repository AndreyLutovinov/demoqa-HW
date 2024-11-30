import org.junit.jupiter.api.*;


public class PracticeFormTest {
   int result;

@BeforeAll
static void beforAll(){
    System.out.println("\n### beforeAll()\n");
}

    @BeforeEach
    void beforeEach() {
        System.out.println("###   beforeEach()\n");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   afterEach()");
        result = 0;

    }

    @AfterAll
    static void AfterAll() {
        System.out.println("\n###   AfterAll()");

    }

    @Test
    void secondTest() {
        System.out.println("###   secondTest()");
        Assertions.assertTrue(result > 2);
    }


    @Test
    void thirdTest() {
        System.out.println("###   thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void firstTest() {
        System.out.println("###   firstTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}