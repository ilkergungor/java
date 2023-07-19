public class List {
    
    Item head;
    Item end;
  
    public List() {
        head = null;
        end = null;
    }
    public boolean isItFull(){
        if(head != null){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFirstBiggerThanSecond(Item first, Item second) {
        if(first.number > second.number){
            return true;
        }else{
            return false;
        }
    }
    public void bubbleSort() {
        if(!isItFull()){
            System.out.println("List is empty!");
        }else if(head == end){
            System.out.println("List has only 1 item!");
        }else{
            boolean isSwapFinished =true;

            Item previous;
            Item first;
            Item second;

            while(isSwapFinished){
                isSwapFinished = false;
                first = head;
                second = first.next;
                previous = null;
                if(isFirstBiggerThanSecond(first, second)){
                    swap(null, first, second);
                    isSwapFinished = true;
                }
                previous = first;
                first = second;
                second = second.next;                      
                while(second != null){
                    if(isFirstBiggerThanSecond(first, second)){
                        swap(previous, first, second);
                        isSwapFinished = true;
                    }
                    previous = first;
                    first = second;
                    second = second.next;  
                }
            }
        }
    }
    public void swap(Item previous, Item first, Item second) {
        if(first == head){
            if(second == end){
               second.next = first;
               first.next = null; 
               end = first;
               head = second;
            }else{
                first.next = second.next;
                second.next = first;
                head = second;
            }
        }else if(second == end){
            second.next = first;
            first.next = null;
            previous.next = second;
            end = first;
        }else{
            first.next = second.next;
            second.next = first;
            previous.next = second;
        }      
    }
    public void addFront(int number){
        Item newItem = new Item(number);
        if (isItFull()){
            newItem.next = head;
            head = newItem;
        }else{
            head = newItem;
            end = newItem;
        }
    }        
    public void addEnd(int number){
        Item newItem = new Item(number);    
        if (isItFull()){
            end.next = newItem;
            end = newItem;
        }else{
            head = newItem;
            end = newItem;
        }
    }
    public void addIndex(int number, int index){
        Item newItem = new Item(number);
        if (isItFull()){
            if(index == 0){
                newItem.next = head;
                head = newItem;                
            }else{
                Item pointer1 = null;
                Item pointer2 = head;        
                int recentIndex = 0;
        
                while(pointer2 != null && recentIndex < index){
                    pointer1 = pointer2;
                    pointer2 = pointer2.next;
                    recentIndex++;
                }
                    if(pointer2 == null){
                        end.next = newItem;
                        end = newItem;
                    }else{
                        newItem.next = pointer2;
                        pointer1.next = newItem;
                    }
            } 
        }else{
            head = newItem;
            end = newItem;
        }           
   }
    public void removeFront() {
        if(isItFull()){
            if(head == end){
                head = null;
                end = null;
            }else{
                Item newHead = head.next;
                head.next = null;
                head = newHead;
            }
        }
   }
    public void removeEnd() {
       if(isItFull()){
            if(head == end){
                head = null;
                end = null;
            }else{
                Item pointer = head;
                while(pointer.next != end){
                    pointer = pointer.next;
                }
                pointer.next = null;
                end = pointer;
            }
        }  
   }
    public void removeIndex(int index){
        if(isItFull() && index >= 0){
            if(head == end){
                head = null;
                end = null;
            }else{
                if(index == 0){
                    Item newHead = head.next;
                    head.next = null;
                    head = newHead;
                }else{
                    Item pointer1 = null;
                    Item pointer2 = head;
                    int recentIndex =0;
                    while(pointer2 != null && recentIndex < index){
                        pointer1 = pointer2;
                        pointer2 = pointer2.next;
                        recentIndex++;
                    }
                    if(pointer2 != null){
                        if(pointer2 == end){
                            end = pointer1;
                            pointer1.next = null;   
                        }else{
                            Item pointer3 = pointer2.next;
                            pointer2.next = null;
                            pointer1.next = pointer3;
                        }
                    }
                }
            }
        }
    }
    public void removeNumber(int number) {
        if(isItFull()){
            if(head == end){
                if(head.number == number){
                head = null;
                end = null;
                }   
            }else{
                if(head.number == number){
                    Item newHead = head.next;
                    head.next = null;
                    head = newHead;
                }else{
                    Item pointer1 = null;
                    Item pointer2 = head;
                    while(pointer2 != null && pointer2.number != number){
                        pointer1 = pointer2;
                        pointer2 = pointer2.next;
                    } 
                    if(pointer2 != null){
                        if(pointer2 == end){
                            end = pointer1;
                            pointer1.next = null;   
                        }else{
                            Item pointer3 = pointer2.next;
                            pointer2.next = null;
                            pointer1.next = pointer3;
                        }  
                    }       
                }
            }
        }
    }
    public void removeAllSameNumbers(int number) {
        if(isItFull()){
            if(head == end){
                if(head.number == number){
                    head = null;
                    end = null;                
                }
            }else{             
                Item pointer1 = null;
                Item pointer2 = head;
                while(pointer2 != null){
                    if(pointer2.number == number){
                        if(head == pointer2){
                            head = pointer2.next;
                            pointer2.next = null;
                            pointer2 = head;
                        }else{
                            if(pointer2 == end){
                                end = pointer1;
                                pointer1.next = null;
                                pointer2 = null;
                            }else{
                                Item pointer3 = pointer2.next;
                                pointer2.next = null;
                                pointer1.next = pointer3;
                                pointer2 = pointer3;
                            }         
                        }
                    }else{
                        pointer1 = pointer2;
                        pointer2 = pointer2.next;
                    } 
                }
            } 
        }  
    }  
    public void writeList() {
        Item pointer = head;
        int indexNumber = 0;
        while(pointer != null){
            System.out.print(pointer.number + " ");
            pointer = pointer.next;
            indexNumber++;
        }
        System.out.println();
        System.out.println("Index is: " + indexNumber);
    }
    public void removeList() {
        head = null;
        end = null;        
    }
    public void addSequent(int number) {
        if(!isItFull()){
            addFront(number);
        }else{
            if(number <= head.number){
                addFront(number);
                return;
            }
            boolean isItFound = false;
            Item first = head;
            Item second = first.next;
            if(second == null){
                addEnd(number);
                isItFound = true;
            }else{
                while(second != null){
                    if(first.number <= number && number <= second.number){
                        Item newItem = new Item(number);
                        first.next = newItem;
                        newItem.next = second;
                         isItFound = true;
                    }
                    first = second;
                    second = second.next;
                }
                if(!isItFound == true){
                    addEnd(number);
                }
            }
        }
    }
    public void queuePush(int number) {
        addEnd(number);
    }
    public int queuePop(){
        int number = head.number;
        removeFront();
        return number;
    }
    public void stackPush(int number){
        addFront(number);
    }
    public int stackPop(){
        int number = head.number;
        removeFront();
        return number;
    }
}
