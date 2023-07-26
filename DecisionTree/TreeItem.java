import java.util.ArrayList;

public class TreeItem {
   
    int patientDataIndex;

    int splitPoint;
    
    ArrayList<Patient> list;
    
    TreeItem minorsItem;
    TreeItem majorsItem;

    boolean[] usableDataIndexes; 

    boolean malignant;

    public TreeItem(ArrayList<Patient> comingList, boolean[] mainDataIndexes) {
        this.list = comingList;
        
        usableDataIndexes = new boolean[10];
        for(int i = 0; i< 10; i++){
            usableDataIndexes[i] = true;
        }
        splitPoint = -1;
        patientDataIndex = -1;

        malignant = false;
    }
}
