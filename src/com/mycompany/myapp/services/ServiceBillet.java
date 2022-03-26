/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Billet;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author HP
 */
public class ServiceBillet {
    public ArrayList<Billet> billets;
    
    public static ServiceBillet instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServiceBillet() {
         req = new ConnectionRequest();
    }
     public static ServiceBillet getInstance() {
        if (instance == null) {
            instance = new ServiceBillet();
        }
        return instance;
    }
     
     public boolean addBillet(Billet b) {
        System.out.println(b);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "create";
    
       req.setUrl(url);
       
       req.addArgument("chair_billet", b.getChairBillet()+"");
       req.addArgument("voyage_num", b.getVoyageNum()+"");
       req.addArgument("terminal", b.getTerminal()+"");
       req.addArgument("portail", b.getPortail()+"");
       req.addArgument("embarquement", b.getEmbarquement());
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     
     public ArrayList<Billet> parseBillets(String jsonText){
        try {
            billets=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Billet b = new Billet();
                float id = Float.parseFloat(obj.get("id").toString());
                b.setId((int)id);
                b.setVoyageNum(((int)Float.parseFloat(obj.get("voyage_num").toString())));
                b.setTerminal(((int)Float.parseFloat(obj.get("terminal").toString())));
                b.setPortail(((int)Float.parseFloat(obj.get("portail").toString())));
                  
                if (obj.get("embarquement")==null)
              b.setEmbarquement("null");
                else
                    b.setEmbarquement(obj.get("embarquement").toString());
                billets.add(b);
            }
            
            
        } catch (IOException ex) {
            
        }
        return billets;
    }
   
      public ArrayList<Billet> getAllBillets(){
        //String url = Statics.BASE_URL+"/Billets/";
        String url = Statics.BASE_URL+"get/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                billets = parseBillets(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return billets;
    }
}
