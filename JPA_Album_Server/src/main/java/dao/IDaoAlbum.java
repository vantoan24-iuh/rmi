package dao;

import entity.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface IDaoAlbum extends Remote {
    public boolean updatePriceOfAlbum(String album_id, double newPrice) throws RemoteException;
    public List<Album> listAlbumByGenre(String genreName) throws RemoteException;
    public Map<String,Long> getNumberOfAlbumsByGenre() throws RemoteException;
}
