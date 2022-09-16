// Домашнее задание 2.	Написать программу, показывающую последовательность действий для игры “Ханойская башня”
public class Hanoiskaja_bashnja {
     
    public static void main(String[] args) {
        int n = 3;
        hanoi(n,'1','2','3');
    }
    static void hanoi(int n,char start,char mid,char end) {
        if(n==1) {
            System.out.println("Disk "+n+" From "+start+" To "+end);
            return;
        }
        hanoi(n-1,start,end,mid);
        System.out.println("Disk "+n+" From "+start+" To "+end);
        hanoi(n-1,mid,start,end);   
    }
}