/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
/**
 *
 * @author HP
 */
public class HomeForm extends Form {
    
    Form current;
    public HomeForm() {
       current=this; //Back
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddBillet = new Button("Add Billet");
        Button btnListBillets = new Button("List Billets");
        
        btnAddBillet.addActionListener(e-> new AddBilletForm(current).show());
        btnListBillets.addActionListener(e-> new ListBilletForm(current).show());
        addAll(btnAddBillet,btnListBillets);
          
        
    }
    
}
