import java.util.Scanner;
import java.io.File;
public class Vote{
  private String a[];//create a String array; Fields of the class are private and fields/methods are non-static.
  public Vote(String candidates[], int ranks[]){
    String  cand[] = new String[ranks.length];//copy the candidate array to cand array;
    for(int g=0;g<cand.length;g++){
      cand[g]=candidates[g];
    }
    a =new String[ranks.length];//String array same length as the ranks array;
    if(candidates.length!=ranks.length){// if the candidates array length is not equal to the length of ranks throw the Exception. 
      throw new RuntimeException("candidates.length "+ candidates.length+" != "+ranks.length+" ranks.length");
    }
    int mins=0;
    for(int f =0;f<ranks.length;f++){//check the if the ranks contain the "0";
      if(ranks[f]==0)
      {
        mins++;
      }
    }
    if(mins!=1){// if there has no "0", in the ranks array; then each number in the ranks mins one;
      for(int i=0;i<ranks.length;i++){
        ranks[i]=ranks[i]-1;
      }
    }
    for(int n=0;n<candidates.length;n++){
      for(int m =0;m<candidates.length;m++){
        if(ranks[m]== n){// sort the cand array to the right order and put it in the String array[];
          a[n]=cand[m];
        }
      } 
    }
  }
  public String toString(){
    String n = "";
    if(a.length==0){//if string array's length is 0; the print out "Vote{}";
      n+="Vote{}";
    }else{
      n+="Vote{"+a[0];//else add the each item into the String array;
      for (int i =1;i<a.length;i++){
        n+=", "+ a[i];
      }
      n+="}";
     }
    return n;
  }
  public static Vote[] readVoteFile(String filename) throws Exception{//The readVoteFile() is clearly laid out and has comments describing what is happening.
    int lines = Util.countLines(filename);// read the how many lines the file has.
    Scanner sc = new Scanner(new File(filename));//create the Scanner to read the file.
    String names[] =Util.splitIntoStrings(sc.nextLine());// create the String array to contain the first line of file.
    Vote vote[] = new Vote[lines-1];// the vote array should has lines-1 length;
    for(int i =0;i<lines-1;i++){//put the numbers into the int array with lines-1 length;
      int ranks[] = Util.splitIntoInts(sc.nextLine());
      vote[i]=new Vote(names,ranks);// then create the votes.
    } 
    return vote;
  }
  public String getBest(Tally tally){
    for(int i=0;i<a.length;i ++){// check the tally's name contains sorted string array first item, if not check the second. vice versa.
      if(tally.contains(a[i])){
        return a[i];// if contain then retuen.
      }
    }
    return null;//else return null;
  }
  
}