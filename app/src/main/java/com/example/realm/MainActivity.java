package com.example.realm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.realm.DAO.ModeloPersona;
import com.example.realm.DAO.PersonaDAO;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////agregar configuracion inicial
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

        PersonaDAO persona = new PersonaDAO();
        persona.clear();

        llenarDatos();
    }


    private void llenarDatos(){

        List<ModeloPersona> modeloP = new ArrayList<>();

        modeloP.add(new ModeloPersona("raul",0,true));
        modeloP.add(new ModeloPersona("luis",0,true));
        modeloP.add(new ModeloPersona("luis2",0,true));
        modeloP.add(new ModeloPersona("luis3",0,true));
        modeloP.add(new ModeloPersona("luis4",0,true));
        modeloP.add(new ModeloPersona("luis5",0,true));
        modeloP.add(new ModeloPersona("luis6",0,true));
        modeloP.add(new ModeloPersona("luis7",0,true));
        modeloP.add(new ModeloPersona("luis8",0,true));
        modeloP.add(new ModeloPersona("luis9",0,true));
        modeloP.add(new ModeloPersona("luis10",0,true));
        modeloP.add(new ModeloPersona("luis11",0,true));
        modeloP.add(new ModeloPersona("luis12",0,true));
        modeloP.add(new ModeloPersona("luis13",0,true));

        PersonaDAO.addAll(modeloP);

        consultarDatos();
    }

    private void consultarDatos(){

        List<ModeloPersona> nuevoModeloLista = PersonaDAO.getSelected();

        for (ModeloPersona auxModelo: nuevoModeloLista){
            Log.i("R E A L M ",auxModelo.getNombre());
        }
    }
}