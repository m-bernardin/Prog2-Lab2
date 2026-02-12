//2-Using an array list of Integer type accept some values from the user (as long as he wants to input),
//and then insert them, one by one, into the arraylist. Each time the user inputs a number,
//your code must find out the appropriate location for that value and insert it accordingly. Like this,
//when the user stops inputting more values, code would show the list of all inputted numbers, sorted in
//ascending order.
import java.util.*;
public class q2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> nums=new ArrayList<>();
        boolean running=true;
        while(running){
            System.out.print("Would you like to enter a number? (Y/n)\n> ");
            if(input.next().equals("n")){
                running=false;
                break;
            }
            System.out.print("Please enter a number\n> ");
            int num=input.nextInt();
            boolean empty=false;
            if(nums.isEmpty()){
                nums.add(num);
                empty=true;
            }
            for(int i=0;i<nums.size()&&!empty;++i){
                System.out.println("**checking pos "+i);
                if(i+1==nums.size()){
                    nums.add(num);
                    System.out.println("**reached end of list");
                    System.out.println("**"+printArrayList(nums));
                    break;
                }
                if(nums.get(i+1)>num){
                    nums.add(0);
                    for(int replace=nums.size()-1;replace>i;--replace){
                        System.out.println("**replacing pos "+replace+" ("+nums.get(replace)+") with "+nums.get(replace-1));
                        nums.set(replace,nums.get(replace-1));
                    }
                    nums.set(i,num);
                    System.out.println("**"+printArrayList(nums));
                    break;
                }
            }
        }
        input.close();
        String answer="Numbers entered, sorted in ascending order: ";
        for(int i=0;i<nums.size();++i){
            answer+=nums.get(i)+" ";
        }
        System.out.println(answer);
    }
    public static String printArrayList(ArrayList<Integer> nums){
        String answer="array list ";
        for(int i=0;i<nums.size();++i){
            answer+=nums.get(i)+" ";
        }
        return answer;
    }
}