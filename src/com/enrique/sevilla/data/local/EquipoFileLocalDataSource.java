package com.enrique.sevilla.data.local;

import com.enrique.sevilla.domain.models.Arbitro;
import com.enrique.sevilla.domain.models.Equipo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EquipoFileLocalDataSource {

    private static EquipoFileLocalDataSource instance=null;

    private String nameFile="Equipo.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Equipo>>() {
    }.getType();

    public void save(Equipo equipo) {
        List<Equipo> equipos = findAll();
        equipos.add(equipo);
        saveToFile(equipos);
    }

    public void saveList(List<Equipo> equipos) {
        saveToFile(equipos);
    }

    private void saveToFile(List<Equipo> equipos) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(equipos));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Equipo findById(String equipoId) {
        List<Equipo> equipos = findAll();
        for (Equipo equipo : equipos) {
            if (Objects.equals(equipo.getId(), equipoId)) {
                return equipo;
            }
        }
        return null;
    }

    public List<Equipo> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()){
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<Equipo>();
    }

    public void delete(String equipoId) {
        List<Equipo> newEquipoList = new ArrayList<>();
        List<Equipo> equipos = findAll();
        for (Equipo equipo : equipos) {
            if (equipo.getId() != equipoId) {
                newEquipoList.add(equipo);
            }
        }
        saveList(newEquipoList);
    }

    private EquipoFileLocalDataSource(){

    }

    public static EquipoFileLocalDataSource getInstance(){
        if(instance==null){
            instance=new EquipoFileLocalDataSource();
        }
        return instance;
    }

}