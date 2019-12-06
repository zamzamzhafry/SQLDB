package com.lks.sqldb;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    String IP, DB, DBUserName, DBPassword;

    @SuppressLint("NewApi")
    public Connection connections() {

//      MASUKKAN IP DB DAN USERNAME
        IP = "192.168.1.13";
        DB = "SQLDB";
        DBUserName = "admini";
        DBPassword = "Akukayakucing1()";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection connection = null;
        String ConnectionURL = null;
        try {

            //Hubungkan ke Server SQL
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            //urutan URL JTDS dihubungkan terus ip db username pw
            ConnectionURL = "jdbc:jtds:sqlserver://" + IP + ";database=" + DB + ";user=" + DBUserName + ";password=" + DBPassword
            ;
            connection = DriverManager.getConnection(ConnectionURL);

        }catch (SQLException se) {
            Log.e("ERROR FROM SQL", se.getMessage());
        }catch (ClassNotFoundException e){
            Log.e("ERROR FROM CLASS ", e.getMessage());
        }catch(Exception ex){
            Log.e("ERROR FROM EXCEPTION",ex.getMessage());
        }return connection;

    }
}