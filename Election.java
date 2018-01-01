import java.util.Scanner;
import java.io.File;
public class Election{
  public static void main(String args[]) throws Exception{
    if(args.length==0){// if can not find the file name 
      System.out.println("usage: java Election <votes.txt>");
      return;
    }
    String files ="";
    for(int i =0;i<args.length;i++){// then find the file name 
     files = args[i];
    }
    Tally tally =Tally.readTallyFromFile(files);// create the Tally.
    Vote votes[] = Vote.readVoteFile(files);// create votes[].
    int len = votes.length;// find votes[] length.
    System.out.println(files+" : "+ len +" votes read");
    int round =1;
    while(tally.getWinner()==null || tally.allWayTie()==true){
      System.out.println("Round "+round+" : "+ tally.size()+ " candidates "+ tally );
      String Trans = tally.countAll(votes);
      System.out.println("Transcript:");// print all votes.
      System.out.print(Trans);
      System.out.println();
      System.out.println(tally.outputString());
      if(tally.getWinner()!=null){// check if there has a winner.
        System.out.println("WINNER: "+tally.getWinner());
        break;
      }
      if(tally.allWayTie()){//check if there have all tie
        System.out.println("ALL WAY TIE BETWEEN:");
        String mins[] =tally.getMinCandidates();//create the string array.
        for(int m=0;m<mins.length;m++){
          System.out.println(mins[m]);//print out all ties.
        }
        break;
      }
      String mins[]=tally.getMinCandidates();// fine the mins candidate. create the string array to contain it.
      System.out.println(mins.length+" minimum vote candidates");
      for(int n=0;n<mins.length;n++){// print out mins candidates.
        System.out.println("Eliminating: "+ mins[n]);
        tally = tally.eliminate(mins[n]);// update tally.
      }
      System.out.println();
      round++;//round plus one.
    }
  }
}