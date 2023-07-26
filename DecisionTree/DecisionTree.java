import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DecisionTree extends JPanel {
    
    TreeItem root;

    boolean[] usableDataIndexes; 

    public DecisionTree(ArrayList<Patient> comingList) {
        boolean[] usableDataIndexes = new boolean[10];
        for(int i = 0; i< 10; i++){
            usableDataIndexes[i] = true;
        }
        usableDataIndexes[0] = false;       //First information is ID number on the array list       
        
        root = new TreeItem(comingList, usableDataIndexes);
      
    }
    public int[] countList(ArrayList<Patient> comingList) {
        
        int malignantNumber = 0;
        int benignNumber = 0;

        for(Patient p: comingList){
            if(p.isItMalignant){
                malignantNumber++;
            }else{
                benignNumber++;
            }
        }
        int[] numbers = new int[2];
        numbers[0] = malignantNumber;
        numbers[1] = benignNumber;
        return numbers;
    }
    public void splitList(ArrayList<Patient> comingList, int dataIndex, int splitPoint,
                        ArrayList<Patient> minorsReturn, ArrayList<Patient> majorsReturn){
        if(dataIndex >= 10 || dataIndex < 0){
            System.out.println("Wrong data index! ");
            return;
        }
        for(Patient p: comingList){
            if(p.patientData[dataIndex] <= splitPoint){     //splitPoint will split ArrayList into minors and majors
                minorsReturn.add(p);
            }else{
                majorsReturn.add(p);
            }
        }
    }
    public int[] splitListAbstract(ArrayList<Patient> comingList, int dataIndex, int splitPoint){

        if(dataIndex >= 10 || dataIndex < 0){
            System.out.println("Wrong data index! ");
            return null;
        }
        int malignantNumberMinors = 0;
        int benignNumberMinors = 0;
        int malignantNumberMajors = 0;
        int benignNumberMajors = 0;

        for(Patient p: comingList){
            if(p.patientData[dataIndex] <= splitPoint){     //splitPoint will split ArrayList into minors and majors
                if(p.isItMalignant){
                    malignantNumberMinors++;
                }else{
                    benignNumberMinors++;
                }     
            }else{
                if(p.isItMalignant){
                    malignantNumberMajors++;
                }else{
                    benignNumberMajors++;
                } 
            }
        }
        int[] numbers = new int[4];

        numbers[0] = malignantNumberMinors;
        numbers[1] = benignNumberMinors;
        numbers[2] = malignantNumberMajors;
        numbers[3] = benignNumberMajors;

        return numbers;
    }
    public float[] findBestSplit(ArrayList<Patient> comingList, int dataIndex) {

        float[] splitPointAndEntropy = new float[2];

        int bestSplitPoint = 1;
        
        int[] abstractNumbers = splitListAbstract(comingList, dataIndex, bestSplitPoint);

        float bestEntrophy = calculateEntropy(abstractNumbers);

        float temporaryEntropy;

        for(int i = 2; i <= 1; i++){
            abstractNumbers = splitListAbstract(comingList, dataIndex, bestSplitPoint);
            temporaryEntropy = calculateEntropy(abstractNumbers);
            if(temporaryEntropy < bestEntrophy){
                bestEntrophy = temporaryEntropy;
                bestSplitPoint = i;
            }
        }
        splitPointAndEntropy[0] = bestSplitPoint;
        splitPointAndEntropy[1] = bestEntrophy;

        return splitPointAndEntropy;
    }
    public float calculateEntropy(int[]abstractNumbers){

        float malignantNumberMinors = abstractNumbers[0];         
        float benignNumberMinors = abstractNumbers[1];
        float malignantNumberMajors = abstractNumbers[2];
        float benignNumberMajors = abstractNumbers[3];

        float entropy;

        float totalMinors = malignantNumberMinors + benignNumberMinors;
        float totalMajors = malignantNumberMajors +  benignNumberMajors;

        float benignMinorsRate = benignNumberMinors / totalMinors;
        float malignantMinorsRate = 1f - benignMinorsRate;              //Total rate is always 1

        float benignMajorsRate = benignNumberMajors / totalMajors;
        float malignantMajorsRate = 1f - benignMajorsRate;
        
        //Entropy = -p(a)*log(p(a)) - p(b)*log(p(b))

        boolean benignMinors = benignMinorsRate >= malignantMajorsRate;
        
        if(benignMinors){
            float pa = benignMinorsRate;
            float pb = malignantMajorsRate;

            entropy = -pa * log2(pa) - pb * log2(pb);
        }else{
            float pa = malignantMinorsRate;
            float pb = benignMajorsRate;

            entropy = -pa * log2(pa) - pb * log2(pb);
        }
        return entropy;
    }
    private float log2(float x){      //log2(x) is not available on Java, needs a new method for the entropy formula
        if(x == 0 ){
            return 0f;
        }else{
           return (float)(Math.log((double)x)/Math.log((double)2));
        }
    }
    public void process(TreeItem recentItem){
        int bestDataIndex = -1;
        float bestEntrophy = 5;
        int bestSplitPoint = -1;

        for(int i = 0; i < 10; i++){
            if(recentItem.usableDataIndexes[i]){
                float[] splitPointAndEntropy = findBestSplit(recentItem.list, i);
                if(splitPointAndEntropy[1] <= bestEntrophy){
                    bestDataIndex = i;
                    bestEntrophy = splitPointAndEntropy[1];
                    bestSplitPoint = (int)splitPointAndEntropy[0];
                }
            }
        }
        if(bestSplitPoint != -1){
            System.out.println("Lists created. Best split point is: " + bestSplitPoint +
            ". Best data index is: " + bestDataIndex + ". Best entropy is: " + bestEntrophy);

            recentItem.usableDataIndexes[bestDataIndex] = false;
            recentItem.splitPoint = bestSplitPoint;
            recentItem.patientDataIndex = bestDataIndex;

            recentItem.minorsItem = new TreeItem(new ArrayList<Patient>(), 
            recentItem.usableDataIndexes);
            recentItem.majorsItem = new TreeItem(new ArrayList<Patient>(), 
            recentItem.usableDataIndexes);
            splitList(recentItem.list, bestDataIndex, bestSplitPoint,
            recentItem.minorsItem.list, recentItem.majorsItem.list); 

            process(recentItem.minorsItem); 
            process(recentItem.majorsItem); 
        }           
    }
    public void setItemResults(TreeItem item) {                                //Only for leaf items of decision tree
        if(item.minorsItem == null && item.majorsItem == null){     //Means it's aleaf item else it's not leaf
            int malignants = 0;
            int benigns = 0;
            for(Patient p : item.list){
                if(p.isItMalignant){
                    malignants++;
                }else{
                    benigns++;
                }
            }
            if(malignants >= benigns){
                item.malignant = true;
            }else{
                item.malignant = false;
            }
        }else{
            setItemResults(item.minorsItem);
            setItemResults(item.majorsItem);
        }
    }
    private boolean test(Patient p, TreeItem item){                        //Only for leaf items of decision tree
        if(item.minorsItem == null && item.majorsItem == null){ 
            return item.malignant;
        }else{
            if(p.patientData[item.patientDataIndex] <= item.splitPoint){
                return test(p, item.minorsItem);
            }else{
                return  test(p, item.majorsItem);
            }
        }
    }
    public boolean testPatient(Patient p){
        return test(p, root);
    } 
    public void mainProcess() {
        process(root);
        setItemResults(root);
    }
    public void paint (Graphics g){
        super.paint(g);
        TreeItem ri = root;
        drawItem(g, ri, 850, 10, 160);
    }
    public void drawItem(Graphics g, TreeItem ri, int x, int y, int width) {
        if(ri.minorsItem == null && ri.majorsItem == null){
            if(ri.malignant){
                g.setColor(Color.RED);
                g.fillRect(x, y, 10, 10);
            }else{
                g.setColor(Color.GREEN);
                g.fillRect(x, y, 10, 10);
            }
        }else{
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 10, 10);
        }
        g.setColor(Color.BLACK);
        if(ri.minorsItem != null){
            g.drawLine(x, y, x - width, y + 20);
            drawItem(g, ri.minorsItem, x - width, y + 20, width - 15);
        }
        if(ri.majorsItem != null){
            g.drawLine(x, y, x + width, y + 20);
            drawItem(g, ri.majorsItem, x + width, y + 20, width - 15);
        }
    }
}
