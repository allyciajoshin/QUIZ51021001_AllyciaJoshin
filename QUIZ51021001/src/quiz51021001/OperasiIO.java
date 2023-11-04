/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51021001;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class OperasiIO {
    private int tidaklulus = 0;
    private int lulus = 0;
    private int jumlahdatamhs=0;
    
    public void SimpanData (String bufnim, String bufnama, String bufhuruf, String bufketerangan){
        try{
            FileOutputStream fout=new FileOutputStream("quiz51021001.dat",true);
            DataOutputStream out=new DataOutputStream(fout);
            out.writeUTF(bufnim);
            out.writeUTF(bufnama);
            out.writeUTF(bufhuruf);
            out.writeUTF(bufketerangan);
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
}
    public String readdata(){
        String bufnim, bufnama, bufhuruf, bufketerangan;
        String temp="",data="";
        tidaklulus =0;
        lulus=0;
        jumlahdatamhs=0;
        
        try{
            FileInputStream fin=new FileInputStream("quiz51021001.dat");
            DataInputStream in=new DataInputStream(fin);
          
            while (in.available() > 0) {
                bufnim = in.readUTF();
                bufnama = in.readUTF();
                bufhuruf = in.readUTF();
                
                if (bufhuruf.equals("E")) {
                    tidaklulus++;
                } else {
                    lulus++;
                }
                bufketerangan = in.readUTF();
                System.out.println(bufnim);
                System.out.println(bufnama);
                System.out.println(bufhuruf);
                System.out.println(bufketerangan);
                temp = "nim=" + bufnim + "\t\t nama=" + bufnama + "\n huruf=" + bufhuruf + "\n keterangan=" + bufketerangan; //bentuk string
                data += temp;
                jumlahdatamhs++; 

            }
                    
                    
            in.close();
        }catch(IOException e){
            e.printStackTrace(); 
            //System.out.println(e.toString());
        }
        
        return(data);
}

public int getJumlahDataMhs(){
    return jumlahdatamhs;
}
public int getLulus() {
        return lulus;
    }

public int getTidakLulus() {
        return tidaklulus;
   }
}
