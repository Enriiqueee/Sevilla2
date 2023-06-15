package com.enrique.sevilla.data.local;

import com.enrique.sevilla.domain.models.Partido;
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

public class PartidoFileLocalDataSource {

    private static PartidoFileLocalDataSource instance=null;

    private String nameFile="Partido.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Partido>>() {
    }.getType();

    public void save(Partido partido) {
        List<Partido> partidos = findAll();
        partidos.add(partido);
        saveToFile(partidos);
    }

    public void saveList(List<Partido> partidos) {
        saveToFile(partidos);
    }

    private void saveToFile(List<Partido> partidos) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(partidos));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Partido findById(String partidoId) {
        List<Partido> partidos = findAll();
        for (Partido partido : partidos) {
            if (Objects.equals(partido.getId(), partidoId)) {
                return partido;
            }
        }
        return null;
    }

    public List<Partido> findAll() {
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
        return new ArrayList<Partido>();
    }

    public void delete(String partidoId) {
        List<Partido> newPartidoList = new ArrayList<>();
        List<Partido> partidos = findAll();
        for (Partido partido : partidos) {
            if (partido.getId() != partidoId) {
                newPartidoList.add(partido);
            }
        }
        saveList(newPartidoList);
    }

    private PartidoFileLocalDataSource(){

    }
    public static PartidoFileLocalDataSource getInstance(){
        if(instance==null){
            instance=new PartidoFileLocalDataSource();
        }
        return instance;
    }

}
