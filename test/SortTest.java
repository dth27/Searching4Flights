/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import model.Flight;
import org.junit.*;
import static org.junit.Assert.*;
import service.SearchService;
/**
 *
 * @author Dottedsocks
 */
public class SortTest {
   private SearchService e;
   ArrayList<Flight> flListiunsorted = new ArrayList<>();
   ArrayList<Flight> flListi1 = new ArrayList<>();
   ArrayList<Flight> flListi0 = new ArrayList<>();
   ArrayList<Flight> flListiretti = new ArrayList<>();
   mockDatabaseManager mm;
   
    @Before
    public void setUp(){
        //work to be performed before each test
        //Mogulega bua til tvo flug?
        mm = new mockDatabaseManager();
        e = new SearchService();
        flListiunsorted = mm.getlist(2);
        flListi1 = mm.getlist(1);
        flListi0 = mm.getlist(0);
        
        flListiretti.add(mm.flug3);
        flListiretti.add(mm.flug2);
        flListiretti.add(mm.flug);
        
        
    }
    @After
    public void tearDown(){
        //Cleanup work to be performed after each test
        flListiunsorted = null;
        flListi1 = null;
        flListi0 = null;
        mm = null;
        e = null;
    }
    @Test
    public void testSort0(){
        //test one part. behavior
        //assert...(..);
        // assert a certain condition that will
        //indicate whether the test passed
        e.sortFlights(flListi0);
        assertNull(flListi0);
        
    }
    @Test
    public void testSort1(){
        e.sortFlights(flListi1);

    }
     @Test
    public void testSort3(){
        
        e.sortFlights(flListiunsorted);
        assertEquals(flListiretti, flListiunsorted);
        System.out.println("Listi obj: " + flListiunsorted.get(0).getTicket_price());
        System.out.println("Listi obj: " + flListiunsorted.get(1).getTicket_price());
        System.out.println("Listi obj: " + flListiunsorted.get(2).getTicket_price());
        System.out.println("Mock obj: " + flListiretti.get(0).getTicket_price());
        System.out.println("Mock obj: " + flListiretti.get(1).getTicket_price());
        System.out.println("Mock obj: " + flListiretti.get(2).getTicket_price());
    }
}
