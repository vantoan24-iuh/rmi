package server;

import dao.IDaoAlbum;
import dao.impl.DaoAlbumImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String URL = "rmi://192.168.110.83:1234/";

//    private static final String URL = "rmi://LAPTOP-NE7C2S28:2824/";
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            IDaoAlbum daoAlbum = new DaoAlbumImpl(); // Remote Object

            LocateRegistry.createRegistry(1234);

            context.rebind(URL + "daoAlbum", daoAlbum);

            System.out.println("Server is running..."	);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
