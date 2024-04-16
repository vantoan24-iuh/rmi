package dao;

import dao.impl.DaoAlbumImpl;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        DaoAlbumImpl daoAlbum = new DaoAlbumImpl();
        boolean result = daoAlbum.updatePriceOfAlbum("ab1", 120000);
        System.out.println("Result: " + result);
    }
}
