/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class Clases {

    // File:representa una referencia a un fichero y proporciona métodos para obtener información sobre el mismo
    File file;
    // FileReader: Permite realizar la lectura de caracteres de un fichero de texto
    FileReader fileReader;
    //FileWriter. proporciona métodos para escribir caracters en un fichero de texto.
    FileWriter fileWriter;
    //BufferedReader: Utilizada anteriormente para leer cadenas de caracteres de teclado.
    //  En general, esta clase permite recuperar cadenas de caracteres de cualquier flujo de entrada,
    //    incluido ficheros. Su constructor tiene formato BufferedReader(Reader r)
    BufferedReader bf;
    //PrintWriter: Proporciona métodos para la escritura de datos de diferentes tipos en un flujo de 
    //  salida, incluido un fichero de texto
    //ObjectInputStream: Permite recuperar objetos de un flujo de entrada, inlcuido ficheros
    //ObjectOutputStream: Permite enviar un objeto a un flujo de salida, incluido ficheros.

    public void lecturaFichero() {
        file = new File("D:\\ALI\\CICE\\Aplicaciones\\006_T119_Ficheros\\ficheros\\filereader.txt");
        try {
            fileReader = new FileReader(file);
            bf = new BufferedReader(fileReader);
            String cadena;
            while ((cadena = bf.readLine()) != null) {
                System.out.println(cadena);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Clases.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Clases.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Clases.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void escrituraFichero() {

        /* PrintWriter: clase que necesitamos para poder escribir en un fichero de texto.
        Constructor: PrinWriter(String nombrefichero)
        print(tipo dato): Nos permite enviar cualquier tipo de dato primitivo Java y sTRING AL FICHERO.
            método sobrecargado existiendo un método print por cada tipo primitivo( a excepción de byte y short)
            además de String.
        println( tipo de dato): similar al anterior, introudiciendo un salto de líneal al final
        write(String cadena) Escribe una cadena de caracteres en el fichero. Igual que print(String dato)
        
        Con PrintWriter, cada vez que crea el objeto, el puntero de escritura se sitúa al principio
        del fichero, por lo que cualquier llamada a los métodos de escritura provocaría que los nuevos
        datos sobrescribieran a los ya existentes.. Para solucionar usamos la clase FileWriter.
        FileWriter desarrollada para escribir cadenas de caracteres en un fichero, perimite decidir a la hora
        de crear el objeto si queremos añadir la información al fichero o sobreescribir su contenido.
        
       
         */
        file = new File("D:\\ALI\\CICE\\Aplicaciones\\006_T119_Ficheros\\ficheros\\filewriter.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    pw.write(i + " ");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Clases.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    public void escrituraFicheroFileWriter(){
    //FileWriter(String fichero, boolean append)
    // append true: añadirán caracteres al final
    // append false: sobreescribirán a los anteriores
    
    }
}
