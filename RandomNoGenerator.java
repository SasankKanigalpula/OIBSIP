import java.util.Random;
import javax.swing.*;
import java.awt.event.*; 
class GenerateRandom{
    int r1;
    int generate(int r){
          Random random=new Random();
          r1=random.nextInt(r);
          return r1;

    }
}
class RandomNoGenerator implements ActionListener{
    static int q=1;
    static int round=1;
    JFrame f;
    JTextField t1;
    JTextArea t2;
    int r;
    JButton b1;
    JLabel l,l1,l2,l3,l4,l5;
    int c=0;
    int k=(int)Math.pow(10,round);
    int a=(int)(Math.log(k)/Math.log(2))+1;

    RandomNoGenerator(){
        GenerateRandom g=new GenerateRandom();
        r=g.generate(k);
        f=new JFrame("Guess the number");
        l5=new JLabel("Round "+round);
        l5.setBounds(50,250,100,30);
        t1=new JTextField();
        t2=new JTextArea("Welcome to the Number guessing game!\nThis game consists of 3 Rounds\nRound 1:(0-9)\nRound 2:(0-99)\nRound 3:(0-999)\nIn each Round you need to guess 3 times in the range of the round!\nIf failed to guess within the allowed attempts,you loose the game!\nIf you Clear all the 3 rounds You are the winner!");
        t2.setEditable(false);
        t2.setBounds(50,20,450,200);
        l1=new JLabel(q+". Enter your guessed number here"+" ("+0+","+(k-1)+")");
        l1.setBounds(50,300,300,50);
        l2=new JLabel("your result will be displayed here");
        b1=new JButton("Check");
        b1.addActionListener(this);
        l=new JLabel();
        l3=new JLabel("You have "+a+" chances remaining");
        l3.setBounds(50,700,300,75);
        l4=new JLabel();
        l4.setBounds(50,550,300,20);
        f.add(l4);
        l.setBounds(50,600,300,50);
        f.add(b1);
        f.add(l5);
        f.add(t1);
        f.add(t2);
        f.add(l2);
        f.add(l);
        f.add(l3);
        f.add(l1);
        b1.setBounds(50,800,300,50);
        t1.setBounds(50,400,300,50);  
        l2.setBounds(50,500,300,50);
        f.setSize(600,900);  
        f.setLayout(null);  
        f.setVisible(true);


    }
    
    public static void main(String args[]){
        new RandomNoGenerator();    
    }
    public void actionPerformed(ActionEvent e) {  
        String s1=t1.getText();
        int s=Integer.parseInt(s1);
        if(round==4){
            f.getContentPane().removeAll();
            f.repaint();
            JLabel jl=new JLabel("Congratulations you won the game!");
            jl.setBounds(50,50,300,100);
            f.add(jl);

        }
        else{
        if(s==r){
            l2.setText("Correct Guess!!!! \nIt is "+r+".\n Guess this one");
           
                c+=a;
                l.setText("SCORE :"+Integer.toString(c));
            
            k=(int)Math.pow(10,round);
            a=(int)(Math.log(k)/Math.log(2))+1;
            l3.setText("You have "+a+" chances remaining");
            l4.setText("");
           
            
            GenerateRandom g=new GenerateRandom();
            q=q+1;
            t1.setText("");
            if(q==4){
                q=1;
                round=round+1;
              
                if(round==4){
                    f.getContentPane().removeAll();
                    f.repaint();
                    JLabel jl=new JLabel("Congratulations you won the game!,Your Total Score is "+c);
                    jl.setBounds(50,50,400,100);
                    f.add(jl);
                }
                l5.setText("Round "+round);
                k=(int)Math.pow(10,round);
                a=(int)(Math.log(k)/Math.log(2))+1;
                r=g.generate(k);
                l3.setText("You have "+a+" chances remaining");


            }
            
            l1.setText(q+". Enter your guessed number here"+" ("+0+","+(k-1)+")");
           
            r=g.generate(k);
           
           
        }
        else{
            l2.setText("sorry wrong answer");
            if(r>Integer.parseInt(t1.getText())){
                l4.setText(Integer.parseInt(t1.getText())+"It is less than the random number generated");
            }
            else if(r<Integer.parseInt(t1.getText())){
                l4.setText(Integer.parseInt(t1.getText())+"It is more than the random number generated");
            }
            
            a--;
            if(a==0){
                f.getContentPane().removeAll();
                f.repaint();
                JLabel jl=new JLabel("Attemps exceeded You are unable to clear the round! Your score is "+c);
                jl.setBounds(50,50,400,100);
                f.add(jl);
            }
            else{
            l3.setText("You have "+a+" chances remaining");
            }
            
            


        }
    }

    }
}