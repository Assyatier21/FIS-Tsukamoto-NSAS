/*
 * Nama    : Muhammad Sholeh
 * NIM     : 09021281823172
 * Kelas   : Reguler C 2018
 */

package fuzzytsukamoto;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class RulesMaker 
{
    public static void main(String[] args) 
    {
        String rules_line = "";
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    for (int l = 0; l < 2; l++) 
                    {
                        for (int m = 0; m < 2; m++) 
                        {
                            if(m == 0)
                            {
                                if(i == 0)
                                    rules_line += "IF UN IS Rendah1 AND ";
                                else if(i == 1)
                                    rules_line += "IF UN IS Sedang1 AND ";
                                else
                                    rules_line += "IF UN IS Tinggi1 AND ";
                                
                                if(j == 0)
                                    rules_line += "NR IS Rendah2 AND ";
                                else if(j == 1)
                                    rules_line += "NR IS Sedang2 AND ";
                                else
                                    rules_line += "NR IS Tinggi2 AND ";
                               
                                if(k == 0)
                                    rules_line += "UT IS Rendah3 AND ";
                                else if(k == 1)
                                    rules_line += "UT IS Sedang3 AND ";
                                else
                                    rules_line += "UT IS Tinggi3 AND ";
                                
                                if(l == 0)
                                    rules_line += "TP IS Kurang1 AND ";
                                else
                                    rules_line += "TP IS Baik1 AND ";
                                rules_line += "TW IS Kurang2" + " THEN Kelulusan \n";
                            }
                            else
                            {
                                if(i == 0)
                                    rules_line += "IF UN IS Rendah1 AND ";
                                else if(i == 1)
                                    rules_line += "IF UN IS Sedang1 AND ";
                                else
                                    rules_line += "IF UN IS Tinggi1 AND ";
                                
                                if(j == 0)
                                    rules_line += "NR IS Rendah2 AND ";
                                else if(j == 1)
                                    rules_line += "NR IS Sedang2 AND ";
                                else
                                    rules_line += "NR IS Tinggi2 AND ";
                               
                                if(k == 0)
                                    rules_line += "UT IS Rendah3 AND ";
                                else if(k == 1)
                                    rules_line += "UT IS Sedang3 AND ";
                                else
                                    rules_line += "UT IS Tinggi3 AND ";
                                
                                if(l == 0)
                                    rules_line += "TP IS Kurang1 AND ";
                                else
                                    rules_line += "TP IS Baik1 AND ";
                                rules_line += "TW IS Baik2" + " THEN Kelulusan \n"; 
                                
                            }
                        }
                    }
		}
            }
        }
        File file = new File("D:\\ruleOfTsukamoto.txt");
        Path path = Paths.get("D:\\ruleOfTsukamoto.txt");
        byte[] bytes = rules_line.getBytes();
        
        try 
        {
            Files.write(path, bytes);
        }
        catch (IOException e){}
        System.out.println(rules_line);
    }
}