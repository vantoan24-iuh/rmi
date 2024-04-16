package dao;

import dao.impl.DaoAlbumImpl;
import entity.Album;
import org.junit.jupiter.api.*;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAlbum {
    private DaoAlbumImpl daoAlbum;

    @BeforeAll
    public void init() throws RemoteException {
        daoAlbum = new DaoAlbumImpl();
    }

    @Test
    public void testUpdatePriceOfAlbum() throws RemoteException {
        boolean result = daoAlbum.updatePriceOfAlbum("ab1", 130000);
        System.out.println("Result: " + result);
    }
    @Test
    public void testListAlbumByGenre() throws RemoteException {
        List<Album> albums = daoAlbum.listAlbumByGenre("1");
        System.out.println(albums);
    }
    @Test
    public void testGetNumberOfAlbumsByGenre() throws RemoteException {
        Map<String, Long> result = daoAlbum.getNumberOfAlbumsByGenre();
        System.out.println(result);
    }
    @AfterAll
    public void tearDown() {
        daoAlbum.close();
    }
}
