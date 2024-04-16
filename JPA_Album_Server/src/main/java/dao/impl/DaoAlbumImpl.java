package dao.impl;

import dao.IDaoAlbum;
import entity.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoAlbumImpl extends UnicastRemoteObject implements IDaoAlbum {
    private EntityManager em;
    private EntityTransaction tx;

    public DaoAlbumImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("rmi_sql").createEntityManager();
        tx = em.getTransaction();
    }

    public boolean updatePriceOfAlbum(String album_id, double newPrice) throws RemoteException {
        String query = "UPDATE Album a SET a.price = :newPrice WHERE a.id = :album_id";
        try {
            tx.begin();
            em.createQuery(query).setParameter("newPrice", newPrice).setParameter("album_id", album_id).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy danh sách album theo thể loại
     * @param genreName tên thể loại
     * @return danh sách album
     * "SELECT a FROM Album a WHERE a.genre.name = :genreName" (tìm tuyệt đối)
     * "SELECT a FROM Album a WHERE a.genre.name LIKE :genreName" (tìm tuong đối)
     */
    @Override
    public List<Album> listAlbumByGenre(String genreName) throws RemoteException {
        String query = "SELECT a FROM Album a join Genre g on a.genre.id=g.id WHERE a.genre.name like :genreName";
        List<Album> albums = new ArrayList<>();
        try {
            tx.begin();
            albums = em.createQuery(query, Album.class).
                    setParameter("genreName","%"+genreName+"%").getResultList();
            tx.commit();
            return albums;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Tìm số lượng album theo thể loại và sắp xếp theo thứ tự tên thể loại tăng dần
    @Override
    public Map<String, Long> getNumberOfAlbumsByGenre() throws RemoteException {
        String query = "SELECT a.genre.name, COUNT(a) FROM Album a GROUP BY a.genre.name ORDER BY a.genre.name";
        Map<String, Long> result = new HashMap<>();
        try {
            tx.begin();
            List<Object[]> list = em.createQuery(query).getResultList();
            for (Object[] objects : list) {
                result.put((String) objects[0], (Long) objects[1]);
            }
            tx.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        em.close();
    }
}
