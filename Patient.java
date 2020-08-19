import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Patient extends JFrame  {
    static class Person {
        String name;
        int age;
        char tower;
        String report;
        String cured;

        Person(String name, int age, char tower, String report) {
            this.name = name;
            this.age = age;
            this.tower = tower;
            this.report = report;
            getdate(report);
        }

        void getdate(String report) {
            int rdate = Integer.parseInt(report.substring(0, 2));
            int rmonth = Integer.parseInt(report.substring(3, 5));
            int cdate = 0;
            int cmonth = 0;
            if (rmonth == 4 || rmonth == 6) {
                if ((rdate + 21) > 30) {
                    cdate = (rdate + 21) - 30;
                    cmonth = rmonth + 1;
                } else {
                    cdate = rdate + 21;
                    cmonth = rmonth;
                }
            } else if (rmonth == 5 || rmonth == 7 || rmonth == 8) {
                if ((rdate + 21) > 31) {
                    cdate = (rdate + 21) - 31;
                    cmonth = rmonth + 1;
                } else {
                    cdate = rdate + 21;
                    cmonth = rmonth;
                }
            }

            if (cdate < 10) {
                this.cured = "0" + cdate + "/0" + cmonth + "/2020";
            } else {
                this.cured = cdate + "/0" + cmonth + "/2020";
            }
        }

        void display(){
            System.out.print(this.name+"  ");
            System.out.print(this.age+"  ");
            System.out.print(this.tower+"  ");
            System.out.print(this.report+"  ");
            System.out.println(this.cured+"  ");
            System.out.println();
        }
    }

    public static void assign(Person[] P){

        P[0]=new Person("Flora",6,'A',"01/04/2020");
        P[1]=new Person("Denys",24,'B',"01/04/2020");
        P[2]=new Person("Jim",42,'C',"18/05/2020");
        P[3]=new Person("Hazel",87,'D',"23/06/2020");
        P[4]=new Person("Caery",72,'A',"01/06/2020");
        P[5]=new Person("David",7,'B',"14/06/2020");
        P[6]=new Person("Kevim",37,'D',"05/06/2020");
        P[7]=new Person("Tom",67,'D',"20/06/2020");
        P[8]=new Person("Bob",74,'A',"04/07/2020");
        P[9]=new Person("Rachel",48,'C',"24/07/2020");
        P[10]=new Person("Thomas",21,'C',"11/06/2020");
        P[11]=new Person("Mary",17,'D',"21/06/2020");
        P[12]=new Person("Smith",89,'A',"07/08/2020");
        P[13]=new Person("Pearson",47,'B',"04/06/2020");
        P[14]=new Person("Anderson",62,'B',"27/07/2020");
        P[15]=new Person("Johnson",10,'D',"01/08/2020");
        P[16]=new Person("Robertz",50,'A',"09/08/2020");
        P[17]=new Person("Julie",86,'B',"02/05/2020");
        P[18]=new Person("Edith",42,'D',"07/06/2020");
        P[19]=new Person("John",95,'D',"01/06/2020");

        /*for (int i=0;i<20;i++){
            P[i].display();
        }*/

    }

    static JFrame f;

    static class GUI extends JFrame implements ActionListener{

        JCheckBox c1=new JCheckBox(" Tower A");
        JCheckBox c2=new JCheckBox(" Tower B");
        JCheckBox c3=new JCheckBox(" Tower C");
        JCheckBox c4=new JCheckBox(" Tower D");
        boolean a,b,c,d;
        JTextField jTextField=new JTextField(40);
        GUI(){
            Person[] P=new Person[20];
            assign(P);
            f=new JFrame(" Covid-19 Statistics");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new FlowLayout());
            JPanel p=new JPanel();

            JLabel date=new JLabel();
            date.setText(" DATE ");
            p.setBorder(BorderFactory.createTitledBorder("Towers"));
            p.add(c1);
            p.add(c2);
            p.add(c3);
            p.add(c4);
            p.add(date);
            p.add(jTextField);
            f.add(p);
            f.setSize(500,500);

            f.pack();
            f.setVisible(true);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int D=Integer.parseInt(jTextField.getText().substring(0,2));
            int M=Integer.parseInt(jTextField.getText().substring(3,5));
            
            if(c1.isSelected()){
                a=true;
            }
            if(c2.isSelected()){
                b=true;
            }
            if(c3.isSelected()){
                c=true;
            }
            if(c4.isSelected()){
                d=true;
            }

        }


    }

    public static void main(String[] args) {

        GUI bj=new GUI();

    }
}


