package testing.test;

import java.io.File;
import java.io.IOException;

public class TestLombok {
private int age;
public static void main(String[] args)
{
	  try {  
          File file = new File("src/resources/simple.txt");  
          if (file.createNewFile()) {  
              System.out.println("New File is created!");  
          } else {  
              System.out.println("File already exists.");  
          }  
      } catch (IOException e) {  
          e.printStackTrace();  
      }  
	}
}
