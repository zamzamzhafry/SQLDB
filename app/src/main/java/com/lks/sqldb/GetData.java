package com.lks.sqldb;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    Connection connect;
    String ConnectionResult="";
    Boolean isSuccess=false;

    public List<Map<String,String>> getdata(){
        List<Map<String,String>> data=null;
        data=new ArrayList<Map<String, String>>();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connections();
            if (connect == null) {
                //APABILA GAGAL
                ConnectionResult = "Check Internet COnn";
            } else {
                //QUERY VIEW
                String query = "select * msemployee";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Map<String, String> datanum = new HashMap<String, String>();
                    //masukkan data tabel yang akan di insert
                    datanum.put("id", rs.getString("employeeid"));
                    datanum.put("name", rs.getString("name"));
                    datanum.put("email", rs.getString("email"));
                    datanum.put("password", rs.getString("password"));
                    datanum.put("hp", rs.getString("handphone"));
                    datanum.put("pos", rs.getString("position"));
                    //Increment ke next kolom
                    data.add(datanum);

                }
                ConnectionResult = "Successsful";
                isSuccess = true;
                connect.close();
            }}catch (Exception ex){
            isSuccess=false;
            ConnectionResult=ex.getMessage();

        }return data;

            }
        }
