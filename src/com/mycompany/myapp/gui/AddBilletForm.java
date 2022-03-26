/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Billet;
import com.mycompany.myapp.services.ServiceBillet;
/**
 *
 * @author HP
 */
public class AddBilletForm extends Form {
    
    public AddBilletForm(Form previous) {
        setTitle("Add a new Billet");
        setLayout(BoxLayout.y());
        
        TextField tfchair_billet = new TextField("","Chair number");
        TextField tfvoyage_num= new TextField("", "voyage number");
        TextField tfterminal = new TextField("","Terminal");
        TextField tfportail= new TextField("", "Portail");
        TextField tfembarquement= new TextField("", "Embarquement: dd/mm/yyyy");
        Button btnValider = new Button("Add Billet");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfchair_billet.getText().length()==0)||(tfvoyage_num.getText().length()==0)||(tfterminal.getText().length()==0)||(tfportail.getText().length()==0)||(tfembarquement.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Billet b = new Billet(Integer.parseInt(tfchair_billet.getText()), Integer.parseInt(tfvoyage_num.getText()), Integer.parseInt(tfterminal.getText()), Integer.parseInt(tfportail.getText()), tfembarquement.getText().toString());
                        if( ServiceBillet.getInstance().addBillet(b))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfchair_billet,tfvoyage_num,tfterminal,tfportail,tfembarquement,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
