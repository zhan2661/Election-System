import java.util.Scanner;
import java.io.File;
public class Util{
  public static int countLines(String filename) throws Exception{
    Scanner sc = new Scanner(new File(filename));//create the new Scanner to scan filename;
    int n =0;
    while(sc.hasNextLine()){//if hasNextline then n++;
    n++;
    sc.nextLine();
    }
    return n;
  }
  public static String [] splitIntoStrings(String str){
    int i =0,n=0;
    Scanner sc = new Scanner(str);//create the new Scanner to scan the str;
    while(sc.hasNext()){//count how many words they have;
    n++;
    sc.next();
    }
    Scanner sca = new Scanner(str);//create another Scanner to scan the line;
    String sts []= new String [n];//create the String array ;
    while(sca.hasNext()){//put the words into array;
    sts[i]=(sca.next());
    i++;
    }
    return sts;
  }
  public static int [] splitIntoInts(String str){//The split() methods use a clearly documented two-pass strategy of counting, the reading tokens into an array.
    int i =0,n=0;
    Scanner sc = new Scanner(str);//create the new Scanner to sacn the str;
    while(sc.hasNext()){//find how many ints str has;
    n++;
    sc.next();
    }
    Scanner sca = new Scanner(str);//create another Scanner to scan the str;
    int numb []= new int [n];//creat the int array;
    while(sca.hasNext()){
    int a = Integer.parseInt(sca.next());//transfer the string to int;
    numb[i]=a;//put the int into int array;
    i++;
    }
    return numb;
  }
  
}