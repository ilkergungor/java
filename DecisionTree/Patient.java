public class Patient {
    int[] patientData;
    int dataSize = 10;
    boolean isItMalignant;

    public Patient(int[ ] collectedData) {   
        patientData = new int[dataSize];
        for(int i = 0; i < dataSize; i++){
            patientData[i] = collectedData[i];
        }
        if(collectedData[dataSize] == 2){
            isItMalignant = false;
        }else{
            isItMalignant = true;
        }
    }
    public String toString(){
        String result = " ";
        
        for(int i = 0; i < dataSize; i++){
            result += " " + patientData[i] + " ";
        }
        if(isItMalignant){
            result += "Malignant.";
        }else{
            result += "Benign.";
        }
        return result;
    }
    public boolean result(){
        return isItMalignant;
    } 
}