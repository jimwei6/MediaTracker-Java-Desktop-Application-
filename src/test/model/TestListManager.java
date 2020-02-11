package model;

import exceptions.EmptyStringException;
import exceptions.NullDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestListManager {
    private ListManager listManager;

    @BeforeEach
    public void runBefore() {
        listManager = new ListManager();
    }

    @Test
    public void testConstruct() {
        assertEquals(0, listManager.size());
    }

    @Test
    public void testAddToColl() {
        try {
            MediaList mediaList = new MediaList("Things to watch");
            listManager.addToColl(mediaList);
            assertEquals(1, listManager.size());
        } catch (EmptyStringException e) {
            fail("Should not have ran into EmptyStringException");
        }
    }

    @Test
    public void testRemove() {
        try {
            MediaList mediaList1 = new MediaList("To watch list");
            MediaList mediaList2 = new MediaList("Watched list");
            listManager.addToColl(mediaList1);
            listManager.addToColl(mediaList2);
            assertEquals(2, listManager.size());
            listManager.remove(mediaList2);
            assertEquals(1, listManager.size());
        } catch (EmptyStringException e){
            fail("Should not have ran into EmptyStringException");
        }
    }

    @Test
    public void testFindMediaListByName() {
        try {
            MediaList mediaList = new MediaList("To watch list");
            MediaList mediaList1 = new MediaList("Watched list");
            listManager.addToColl(mediaList);
            listManager.addToColl(mediaList1);
            assertEquals(mediaList, listManager.findMediaListByName("To watch list"));
            assertEquals(mediaList1, listManager.findMediaListByName("Watched list"));
        } catch (EmptyStringException | NullDataException e) {
            e.printStackTrace();
            fail("Should not have ran into any Exception");
        }
    }

    @Test
    public void testFineMediaListByEmptyName() {
        try {
            MediaList mediaList = new MediaList("To watch list");
            listManager.addToColl(mediaList);
            listManager.findMediaListByName("");
        } catch (EmptyStringException e) {
            //expected
        } catch (NullDataException e) {
            fail("Should have ran into EmptyStringException first");
        }
    }

    @Test
    public void testFineMediaListByNullList() {
        try {
            MediaList mediaList = new MediaList("To watch list");
            listManager.addToColl(mediaList);
            listManager.findMediaListByName("do not exist");
        } catch (EmptyStringException e) {
            fail("Should not have ran into EmptyStringException");
        } catch (NullDataException e) {
           //expected
        }
    }

    @Test
    public void testGetList() {
        try {
        MediaList mediaList = new MediaList("To watch list");
        listManager.addToColl(mediaList);
        ArrayList<MediaList> returnedList = listManager.getList();
        assertEquals(1, returnedList.size());
        assertEquals(mediaList, returnedList.get(0));
        } catch (EmptyStringException e) {
            fail("Should not have ran into EmptyStringException");
        }
    }
}
