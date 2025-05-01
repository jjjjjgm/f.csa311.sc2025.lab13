package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;
    

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new Database(); // We probably don't want to access our real database...
        recommender = new RecSys();
        promoService = new PromoService();
    
        

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }
     @Test
    public void testLogInWithFakeDatabase() {
        InMemoryDatabase fakeDb = new InMemoryDatabase();
        fakeDb.addAccount("testUser", 12345);
        
        RecSys dummyRecSys = mock(RecSys.class);
        PromoService dummyPromoService = mock(PromoService.class);
        
        AndrewWebServices service = new AndrewWebServices(fakeDb, dummyRecSys, dummyPromoService);
        
        boolean result = service.logIn("testUser", 12345);
        assertTrue("Login should succeed with correct credentials", result);
        
        boolean failedResult = service.logIn("testUser", 54321);
        assertFalse( "Login should fail with incorrect password", failedResult);
    }
    
    // @Test
    // public void testLogIn() {
    //     // This is taking way too long to test
    //     assertTrue(andrewWebService.logIn("Scotty", 17214));
    // }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
    }
    @Test
    public void testSendPromoEmail_withMock() {
        PromoEmailSender mockSender = mock(PromoEmailSender.class);
        PromoController controller = new PromoController(mockSender);

        controller.triggerPromo("test@example.com");

        verify(mockSender).sendPromoEmail("test@example.com");
    }
    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
    }
}
