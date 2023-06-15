package com.enrique.sevilla.data.local;

import com.enrique.sevilla.domain.models.Arbitro;
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

public class ArbitroFileLocalDataSource {

    private static ArbitroFileLocalDataSource instance=null;

    private String nameFile="Arbitro.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Arbitro>>() {
    }.getType();

    public void save(Arbitro arbitro) {
        List<Arbitro> arbitros = findAll();
        arbitros.add(arbitro);
        saveToFile(arbitros);
    }

    public void saveList(List<Arbitro> arbitro) {
        saveToFile(arbitro);
    }

    private void saveToFile(List<Arbitro> arbitro) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(arbitro));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }


    public Arbitro findById(String arbitroId) {
        List<Arbitro> arbitros = findAll();
        for (Arbitro arbitro : arbitros) {
            if (Objects.equals(arbitro.getId(), arbitroId)) {
                return arbitro;
            }
        }
        return null;
    }

    public List<Arbitro> findAll() {
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
        return new ArrayList<Arbitro>();
    }

    /*
    public void delete(String arbitroId) {
        List<Arbitro> newArbitroList = new ArrayList<>();
        List<Arbitro> arbitros = findAll();
        for (Arbitro arbitro : arbitros) {
            if (arbitro.getId() != arbitroId) {
                newArbitroList.add(arbitro);
            }
        }
        saveList(newArbitroList);
    }
    */

    private ArbitroFileLocalDataSource(){

    }

    public static ArbitroFileLocalDataSource getInstance(){
        if(instance==null){
            instance=new ArbitroFileLocalDataSource();
        }
        return instance;
    }

}