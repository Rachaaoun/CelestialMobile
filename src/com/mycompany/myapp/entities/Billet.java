/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;
import java.text.DateFormat;
import java.util.Date;
/**
 *
 * @author HP
 */
public class Billet {
    private int id,chair_billet,voyage_num,terminal,portail;
    private String embarquement;
    
    public Billet(int id, int chair_billet, int voyage_num, int terminal, int portail, String embarquement) {
        this.id = id;
        this.chair_billet = chair_billet;
        this.voyage_num = voyage_num;
        this.terminal = terminal;
        this.portail = portail;
        this.embarquement = embarquement;
    }
     public Billet(int chair_billet, int voyage_num, int terminal, int portail, String embarquement) {
        this.chair_billet = chair_billet;
        this.voyage_num = voyage_num;
        this.terminal = terminal;
        this.portail = portail;
        this.embarquement = embarquement;
    }
      public Billet() {  
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public int getChairBillet() {
        return chair_billet;
    }
    public void setChairBillet(int chair_billet) {
        this.chair_billet = chair_billet;
    }
    
    public int getVoyageNum() {
        return voyage_num;
    }
    public void setVoyageNum(int voyage_num) {
        this.voyage_num = voyage_num;
    }
    
    public int getTerminal() {
        return terminal;
    }
    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }
    
    public int getPortail() {
        return portail;
    }
    public void setPortail(int portail) {
        this.portail = portail;
    }
    
    public String getEmbarquement() {
        return embarquement;
    }
    public void setEmbarquement(String embarquement) {
        this.embarquement = embarquement;
    }
    
    @Override
    public String toString() {
        return "Billet{" + "id=" + id + ", chair_billet=" + chair_billet + ", voyage_num=" + voyage_num +", terminal=" + terminal + ", portail=" + portail +", embarquement=" + embarquement + "\n";
    }
    
}
