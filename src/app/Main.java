package app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        crearArchivosLineas();

    }

    public static void crearArchivosLineas(){

        String path = "src/files/numerosRandom.csv";
        String linea = "";
        int numLineas = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while( (linea = br.readLine()) != null ){
                numLineas++;
                String archivoNuevo = "src/files/Lineas" + numLineas + ".txt";
                ArrayList<Integer> listaLinea = new ArrayList<>();
                String[] numerosStringLinea = linea.split(",");

                for (int i = 0; i <numerosStringLinea.length ; i++) {
                    listaLinea.add(Integer.parseInt(numerosStringLinea[i]));
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNuevo));
                Collections.sort(listaLinea);

                String lineaNueva ="";

                for (int i = 0; i < listaLinea.size(); i++) {
                    if(i == listaLinea.size()-1){
                        lineaNueva += listaLinea.get(i);
                    }
                    else{
                        lineaNueva += listaLinea.get(i) + ",";
                    }
                }

                writer.write(lineaNueva);
                writer.close();


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long numLineas(String fileName) {

        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines);
        return lines;

    }

}
