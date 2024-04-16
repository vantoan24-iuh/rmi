package client;

import dao.IDaoAlbum;
import dao.impl.DaoAlbumImpl;
import entity.Album;

import java.rmi.Naming;
import java.util.List;
import java.util.Map;

public class Client {
//    private static final String URL = "rmi://LAPTOP-NE7C2S28:2824/";

    private static final String URL = "rmi://192.168.110.83:1234/"; //ping nay dc ko

    public static void main(String[] args) {
        try {
            IDaoAlbum daoAlbum = (IDaoAlbum) Naming.lookup(URL + "daoAlbum");

            System.out.println("Cập nhật giá album khi biết mã album: \n");
            boolean result = daoAlbum.updatePriceOfAlbum("ab1", 200000);
            System.out.println("Result: " + result);

            System.out.println("Tim tuong doi album khi biết loai: \n");
            List<Album> albums = daoAlbum.listAlbumByGenre("1");
            System.out.println(albums);

            System.out.println("Tim so luong album ung voi moi loai: \n");
            Map<String, Long> rs = daoAlbum.getNumberOfAlbumsByGenre();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
