/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL.SXO10
 */
class folderFiles extends Trie {
    //Test
  //  public String msg;
    List<String> listWithoutDuplicates=new ArrayList<>();
    public File[] sortByNumber(String folder) {
          File directory = new File(folder);
        File[] files = directory.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    int s = name.indexOf('_')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });
//

        return files;
    }
    public List splittInsert(File[] file,String directory) throws FileNotFoundException, IOException{
        String[] s=null;
      //  List<String> listWithoutDuplicates=new ArrayList<>();
        for(File f:file)
        {
        String fileName = directory+"\\"+f.getName();
        File ffff = new File(fileName);
        FileReader fr = new FileReader(ffff);
        BufferedReader br = new BufferedReader(fr);
        String st; 
  if ((st = br.readLine()) != null) 
  {
      st=st.toLowerCase();
      s = st.split("\\?|\\%|\\!|\\â‚¹|\\‎₹|\\?|\\â|\\€|\\¬|\\ª|\\,|\\ |\\/|\\:|\\#|\\&|\\<|\\;|//>|\\\\|\\.|\\シ|\\し|\\“|\\”|\\‘|\\\"|\\@|\\£|\\$|\\______|\\…|\\*");
  }
  List<String>s1=new ArrayList<String>();

    ArrayList<String> d = new ArrayList<>();
        Collections.addAll(d, s);

        listWithoutDuplicates = d.stream().distinct().collect(Collectors.toList());
   for(String SS:listWithoutDuplicates)
        {
//             System.out.println(SS);
             Trie.insert(SS,f.getName());
         //    msg=f.getName();
    // JOptionPane.showMessageDialog(null,"Indexing file:"+msg+"from the dircetory you entered", "Logging message", JOptionPane.INFORMATION_MESSAGE); 
 
             
        }
            System.out.println(f.getName());
       
  // Trie.insert(f.getName(), st);
}        return listWithoutDuplicates;
    }
public List sample(String word,String directory) throws FileNotFoundException, IOException{
    List<String> fileContent=Trie.search(word);
    List<String> sample=new ArrayList<>() ;
    System.out.println(fileContent.size());
    for(int i=0;i<fileContent.size();i++)
    {
      String fileName = directory+"\\"+fileContent.get(i);
      FileReader fr = new FileReader(fileName);
       BufferedReader br = new BufferedReader(fr);
       String st; 
  if ((st = br.readLine()) != null) 
  {
      st.toLowerCase();
      sample.add(st+fileContent.get(i));
  }
    }
        return sample;
}
}

