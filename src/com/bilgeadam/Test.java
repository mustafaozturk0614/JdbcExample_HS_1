package com.bilgeadam;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/northwind";
        String username="postgres";
        String password="root";
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("Bağlantı Başarılı");
            String sql="insert into categories (category_name) values('Yeni kategori 5'),('Yeni kategori6'),('Yeni kategori7')  ";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            int count=preparedStatement.executeUpdate();
            System.out.println(count+" tane veri olusturuldu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Bağlantı dosyası bulunamadı");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bağlantı başarısız!!!!!!!!");
        }finally {
            try {
                connection.close();
                System.out.println("bağlantı sonlandırlıdı");
            } catch (SQLException e) {
                System.out.println("baglantı sonlandırılamadı");
            }
        }
    }

}
