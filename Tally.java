import java.util.Scanner;
import java.io.File;
public class Tally{//Fields of the class are private and each method has the correct static/non-static designator
  private String arr[];// create the string array 
  private int nums[];// create the int array;
  public Tally(String candidates[]){
    arr = new String[candidates.length];
    for(int i=0;i<candidates.length;i++){
      arr[i]=candidates[i];// copy the candidate array 
    }
    nums= new int[candidates.length];
    for(int n =0;n<nums.length;n++){// the int array all with 0s.
      nums[n]=0;
    }
  }
  public String toString(){
    String n ="";
    if(arr.length==0){// if the string array's length is 0; then just print out Tally{};
      n+="Tally{}";
    }else{
      n+="Tally{"+arr[0]+":"+nums[0];//else print out the names with initial are all 0;
      for(int i=1;i<arr.length;i++){
        n+=", "+arr[i]+":"+nums[i];
      }
      n+="}";
    }
    return n;
  }
  public int size(){
    return arr.length;// find the string array's length;
  }
  public boolean contains(String candidate){
    for(int i=0;i<arr.length;i++){//check the string array has candidate.
      if(arr[i].equals(candidate)){
        return true;
      }
    }
    return false;
  }
  public void countVote(String candidate){
    int check=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i].equals(candidate)){//if the string array find the same name in the array then Increment the vote count.
        nums[i]++;
        check =1;
      }
    }
    if(check==0){// if they can not find the name the throw the exception.
    throw new RuntimeException("'"+candidate+"'"+" not in "+toString());
    }
  }
  public int totalVotes(){
    int tall=0;
    for (int i =0;i<nums.length;i++){
      tall+=nums[i];// add the votes together.
    }
    return tall;
  }
  public String outputString(){
  String output = "CNT     % NAME\n";
    for (int i=0;i<arr.length;i++){
      float numb = (float)(nums[i]);// the format string.
      output+=String.format("%3d %5.1f %s\n",nums[i],(numb/totalVotes())*100,arr[i]);
    }
    return output;
  }
  public String getWinner(){
    String win ="";
    for(int i=0;i<nums.length;i++){//find the float type number for numbers array.
      float numb = (float)(nums[i]);
      numb/=totalVotes();// each number divide the totalVotes.
      if(numb>0.50){// if the number greater than 0.50.
        win+=arr[i];// then find the same index in string array.
      }
    }
    if(win.equals("")){// If no candidate has more than
  // 50% of the vote, return null.
    win =null;
    }
    return win;
  }
  public String [] getMinCandidates(){
    int idx=0;
    int all [] = new int[nums.length];//create the int array same length as number array.
    int  mins = totalVotes();// set the mins to totalVotes.
    for(int i=0;i<nums.length;i++){
      if(nums[i]<=mins){//if the number smaller than mins, mins is that number.
        mins=nums[i];
      }
    }
    for(int m =0;m<nums.length;m++){
      if(nums[m]==mins){//if the numbers equal the mins.
        all[idx]=m;// add the idex to the int array.
        idx++;// count how many added.
      }
    }
    String min[]= new String[idx];//create the string array with count length.
    for(int f=0;f<min.length;f++){//find the same idex string in string array. and put into min array.
      min[f]=arr[all[f]];
    }
    return min;
  }
  public boolean allWayTie(){//if the number is equal to totalVotes divide nums.then tie++;
    int tie=0;
    for(int i=0;i<nums.length;i++){
      if(nums[i]==(totalVotes()/nums.length)){
        tie++;
      }
    }
    if(tie==nums.length){// if tie equals to nums length then return true.
      return true;
    }
    return false;
  }
  public Tally eliminate(String candidate){
    if(contains(candidate)==false){//if can not find candidate throw Exception.
      throw new RuntimeException("'"+candidate+"' not in "+toString() );
    }
    int n =0,i=0;
    String NewArr[] = new String [arr.length-1];// create the new array with string length-1 length.
    while (n<NewArr.length){
      if(arr[i].equals(candidate)){// fine the same candidate then eliminate it.
        i++;
      }
      NewArr[n]=arr[i];
      i++;
      n++;
    }
    Tally ac = new Tally(NewArr);// create new Tally
    return ac;
  }
  public static Tally readTallyFromFile(String filename) throws Exception{
    Scanner sc = new Scanner(new File(filename));
    String names[] =Util.splitIntoStrings(sc.nextLine());// create the Tally with first line in file.
    Tally a = new Tally(names);
    return a;
  }
  public String countAll(Vote votes[]){
    if(votes ==null){
      throw new RuntimeException();
    }
    int lines = votes.length;
    String s="";
    for(int i=0;i<lines;i++){
       this.countVote(votes[i].getBest(this));//count the best in each line.then print out.
       s+= String.format("%2d : %-10s %s %s\n",i,votes[i].getBest(this),votes[i],toString());
    }
    return s;
  }
}