package fuzzytsukamoto;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FuzzyTsukamoto 
{
    static double alfa[]= new double[108];
    static double zFinal[]= new double[108];
    
    public static double[] UjianNasional(double v)
    {
        double rendah = 0, sedang = 0, tinggi = 0;
        
        if(v <= 10)
            rendah = 1;
        else if(v > 10 && v < 20)
            rendah = ((20-v)/10);
        else if(v >= 20)
            rendah = 0;
        
        if(v <= 15 || v >= 29)
            sedang = 0;
        else if(v > 15 && v < 22)
            sedang = ((v-15)/7);
        else if(v > 22 && v < 29)
            sedang = ((29-v)/7);
        else if(v == 22)
            sedang = 1;
        
        if(v <= 25)
            tinggi = 0;
        else if(v > 25 && v < 35)
            tinggi = ((v-25)/10);
        else if(v >= 35)
            tinggi = 1;
        
        double[] UN = {rendah, sedang, tinggi};
        return UN;
    }
    
    public static double[] NilaiRapot(double v)
    {
        double rendah = 0, sedang = 0, tinggi = 0;
        
        if(v <= 55)
            rendah = 1;
        else if(v > 55 && v < 65)
            rendah = ((65-v)/10);
        else if(v >= 65)
            rendah = 0;
        
        if(v <= 60 || v >= 85)
            sedang = 0;
        else if(v > 60 && v < 72)
            sedang = ((v-72)/12);
        else if(v > 72 && v < 85)
            sedang = ((85-v)/13);
        else if(v == 72)
            sedang = 1;
        
        if(v <= 75)
            tinggi = 0;
        else if(v > 75 && v < 88)
            tinggi = ((v-75)/13);
        else if(v >= 88)
            tinggi = 1;
        
        double[] NR = {rendah, sedang, tinggi};
        return NR;
    }
    
    public static double[] UjianTulis(double v)
    {
        double rendah = 0, sedang = 0, tinggi = 0;
        
        if(v <= 50)
            rendah = 1;
        else if(v > 50 && v < 60)
            rendah = ((60-v)/10);
        else if(v >= 60)
            rendah = 0;
        
        if(v <= 55 || v >= 85)
            sedang = 0;
        else if(v > 55 && v < 75)
            sedang = ((v-55)/10);
        else if(v > 75 && v < 85)
            sedang = ((85-v)/10);
        else if(v == 75)
            sedang = 1;
        
        if(v <= 75)
            tinggi = 0;
        else if(v > 75 && v < 88)
            tinggi = ((v-75)/13);
        else if(v >= 88)
            tinggi = 1;
        
        double[] UT = {rendah, sedang, tinggi};
        return UT;
    }
   
    public static double[] TesPsikologi(double v)
    {
        double kurang = 0, baik = 0;
        
        if(v <= 65)
            kurang = 1;
        else if(v > 65 && v < 75)
            kurang = ((75-v)/10);
        else if(v >= 75)
            kurang = 0;
        
        if(v <= 70)
            baik = 0;
        else if(v > 70 && v < 75)
            baik = ((v-70)/5);
        else if(v >= 75)
            baik = 1;
        
        double[] TP = {kurang, baik};
        return TP;
    }
    
    public static double[] TesWawancara(double v)
    {
        double kurang = 0, baik = 0;
        
        if(v <= 65)
            kurang = 1;
        else if(v > 65 && v < 75)
            kurang = ((75-v)/10);
        else if(v >= 75)
            kurang = 0;
        
        if(v <= 70)
            baik = 0;
        else if(v > 70 && v < 80)
            baik = ((v-70)/10);
        else if(v >= 80)
            baik = 1;
        
        double[] TW = {kurang, baik};
        return TW;
    }
    
    public static double Diterima(double a)
    {
        double z = 0;
        if(a == 0)
            z = 0;
        else
        {
            double r = a * 15;
            z = 60 + r;
        }
        return z;
    }
   
    public static double Tidak_Diterima(double a)
    {
        double z = 0;
        if(a == 0)
            z = 0;
        else
        {
            double r = a * 18;
            z = 70 - r;
        }
        return z;
    }
    
    public static void setAlfaValue(double[] UN, double[] NR, double[] UT, double[] TP, double[] TW)
    {
        int z = 0;
        for(int i = 0; i < UN.length; i++)
        {
            for(int j = 0; j < NR.length; j++)
            {
		for(int k = 0; k < UT.length; k++)
                {
                    for (int l = 0; l < TP.length; l++) 
                    {
                        for (int m = 0; m < TW.length; m++) 
                        {
                            double x = (Math.min(Math.min(Math.min(Math.min(UN[i], NR[j]), UT[k]), TP[l]), TW[m]));
                            alfa[z] = x;
                            z++;
                        }
                    }
		}
            }
        }  
    }
    
    public static void setZValue()
    {
        String rules = "";
        int idx = 0;
        
        try 
        {
            FileReader fr = new FileReader("D:\\rulesFinal.txt");
            BufferedReader reader = new BufferedReader(fr);
            
            while(rules != null) 
            {
                rules = reader.readLine();
                if(rules != null)
                {
                    String[] temp = rules.split(" ");
                    if(temp[temp.length-1].equals("Tidak_Diterima"))
                    {
                        zFinal[idx] = Tidak_Diterima(alfa[idx]);
                        idx++;
                    }
                    else
                    {
                        zFinal[idx] = Diterima(alfa[idx]);
                        idx++;
                    }
                }
            }
        }
        catch (IOException e)
        {System.out.println("File Not Found!");}
    }
   
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        double[] UN = UjianNasional(input.nextDouble());
        double[] NR = NilaiRapot(input.nextDouble());
        double[] UT = UjianTulis(input.nextDouble());
        double[] TP = TesPsikologi(input.nextDouble());
        double[] TW = TesWawancara(input.nextDouble());
        double result = 0;
        
        setAlfaValue(UN, NR, UT, TP, TW);
        setZValue();
        
        double finalRes = 0;
        double aTotal = 0;
        
        for(int i = 0; i < zFinal.length; i++)
        {
            System.out.println("alfa ke-" + (i+1) + " " + alfa[i] + " --- zValue ke-" + (i+1) + " " + zFinal[i]);
        }
        System.out.println("");
       
        for(int i = 0; i < alfa.length; i++)
        {
            finalRes += (alfa[i] * zFinal[i]);
            aTotal += alfa[i];
        }
        result = (finalRes/aTotal);
        System.out.println("Hasil Akhir FIS Tsukamoto : " +  result);
        
        if(result < 60)
            System.out.println("Status Kelulusan : Tidak Diterima");
        else 
            System.out.println("Status Kelulusan : Diterima");
        
    }
}
