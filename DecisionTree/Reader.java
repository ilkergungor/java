import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import javax.swing.JFrame;

public class Reader {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Patient> list = new ArrayList<Patient>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("breast-cancer-wisconsin.data"));           
            
            StringTokenizer st;

            Patient recentPatient;
            int[] recentData;
            int dataSize = 11;
            int recentDataInstant = 0;
            
            recentData = new int[dataSize];

            String line;
            String token;

            boolean isTokenValid = true;        //Only numbers allowed for int array

            while((line = in.readLine()) != null){
                recentDataInstant = 0;
                isTokenValid = true;

                st = new StringTokenizer(line, ",");
                while(st.hasMoreTokens()){
                    token = st.nextToken();

                    if(!token.equals("?")){
                        recentData[recentDataInstant] = Integer.parseInt(token);
                        recentDataInstant++;
                    }else{
                        isTokenValid = false;
                    }  
                }
                if(isTokenValid){
                recentPatient = new Patient(recentData);
                list.add(recentPatient);
                }
           }
            in.close();              
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        int malignantNumber = 0;
        int benignNumber = 0;
        
        for(Patient p: list){
            //System.out.println(p);
            if(p.result()){
               malignantNumber++;
            }else{
                benignNumber++;
            }
        }
        System.out.println("Total benign is: " + benignNumber);
        System.out.println("Total malignant is :" + malignantNumber);
     
        int halfMalignantNumber = malignantNumber / 2;
        int halfBenignNumber = benignNumber / 2;

        ArrayList<Patient> training = new ArrayList<Patient>();
        ArrayList<Patient> test = new ArrayList<Patient>();

        Collections.sort(list, new Comparator<Patient>(){
            public int compare(Patient p1, Patient p2){
                if(p1.result() == true && p2.result() == false){
                    return 1;
                }if(p1.result() == false && p2.result() == true){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        int listIndex = 0;

        for(int i = 0; i < halfBenignNumber; i++){
            training.add(list.get(listIndex));
            listIndex++;
            test.add(list.get(listIndex));
            listIndex++;
        }
         for(int i = 0; i < halfMalignantNumber; i++){
            training.add(list.get(listIndex));
            listIndex++;
            test.add(list.get(listIndex));
            listIndex++;
        }
        //System.out.println("Training Set");
        for(Patient p: training){
            //System.out.println(p);  
        }
        
        //System.out.println("-------------------------------");  

        //System.out.println("Test Set");
        for(Patient p: test){
            //System.out.println(p); 
        }

        DecisionTree t = new DecisionTree(training);
        t.mainProcess();

        JFrame f = new JFrame("Decision Tree");
        f.add(t);
        f.setSize(1750, 400);
        f.setVisible(true);
        
         System.out.println("-------------------------------"); 
        System.out.println("Training Set Results:");
        float right = 0;
        float wrong = 0;
        for(Patient p : test){
            boolean patientsEstimatedResult = t.testPatient(p);
            if(patientsEstimatedResult){
                //System.out.println("Estimated result: Malignant " + p);
                if(p.isItMalignant == patientsEstimatedResult){
                    right++;
                }else{
                    wrong++;
                }
            }else{
                //System.out.println("Estimated result: Benign " + p);
                    if(p.isItMalignant == patientsEstimatedResult){
                    right++;
                    }else{
                    wrong++;
                }
            }   
        }
        System.out.println("Right estimastes: " + right);
        System.out.println("Wrong estimastes: " + wrong);
        System.out.println("Accuracy rate: " + right/(right + wrong));

        System.out.println("-------------------------------");  
        System.out.println("Test Set Results:");
        right = 0;
        wrong = 0;
        for(Patient p : training){
            boolean patientsEstimatedResult = t.testPatient(p);
            if(patientsEstimatedResult){
                //System.out.println("Estimated result: Malignant " + p);
                if(p.isItMalignant == patientsEstimatedResult){
                    right++;
                }else{
                    wrong++;
                }
            }else{
                //System.out.println("Estimated result: Benign " + p);
                    if(p.isItMalignant == patientsEstimatedResult){
                    right++;
                    }else{
                    wrong++;
                }
            }   
        }
        System.out.println("Right estimastes: " + right);
        System.out.println("Wrong estimastes: " + wrong);
        System.out.println("Accuracy rate: " + right/(right + wrong));
      /* System.out.println("-------------------------------");  
        ArrayList<Patient> minor = new ArrayList<Patient>();
        ArrayList<Patient> major = new ArrayList<Patient>();

        DecisionTree tree = new DecisionTree(list);
        tree.splitList(list, 1, 4, minor, major);

        System.out.println("Minors List"); 
        for(Patient p: minor){
            System.out.println(p);
        }
        System.out.println("*******************************"); 
        System.out.println("Majors List"); 

        for(Patient p: major){
        System.out.println(p);
        }
        System.out.println("*******************************"); 
        int[] mainList = tree.countList(list);
        System.out.println("Main List Malignant " +  mainList[0] + " Main List Benign " +  mainList[1]);

        int[] minorListNumber = tree.countList(minor);
        int[] majorListNumber = tree.countList(major);

        System.out.println("Minors Malignant " +  minorListNumber[0] + " Minors Benign " +  minorListNumber[1]);
        System.out.println("Majors Malignant " +  majorListNumber[0] + " Majors Benign " +  majorListNumber[1]);

        int[] abstractNumbers = tree.splitListAbstract(list, 1, 4) ;
        
        if(abstractNumbers != null){
            System.out.println("Minors Malignant " +  abstractNumbers[0] + " Minors Benign " +  abstractNumbers[1] + "\n" +
            "Majors Malignant " +  abstractNumbers[2] + " Majors Benign " +  abstractNumbers[3]);
        } */
    }
}
