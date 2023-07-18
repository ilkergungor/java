public class List {
    
    Item head;
    Item end;

    public List() {
        head = null;
        end = null;
    }
    public void addFront(int number){
        Item newItem = new Item(number);
        if (isItFull()){
            newItem.followingItem = head;
            head = newItem;
        }else{
            head = newItem;
            end = newItem;
        }
    }        
    public void addEnd(int number){
        Item newItem = new Item(number);
        if (isItFull()){
            end.followingItem = newItem;
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
                newItem.followingItem = head;
                head = newItem;                
            }else{
                Item pointer1 = null;
                Item pointer2 = head;        
                int recentIndex = 0;
        
                while(pointer2 != null && recentIndex < index){
                    pointer1 = pointer2;
                    pointer2 = pointer2.followingItem;
                    recentIndex++;
                }
                    if(pointer2 == null){
                        end.followingItem = newItem;
                        end = newItem;
                    }else{
                        newItem.followingItem = pointer2;
                        pointer1.followingItem = newItem;
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
                Item newHead = head.followingItem;
                head.followingItem = null;
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
                while(pointer.followingItem != end){
                    pointer = pointer.followingItem;
                }
                pointer.followingItem = null;
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
                    Item newHead = head.followingItem;
                    head.followingItem = null;
                    head = newHead;
                }else{
                    Item pointer1 = null;
                    Item pointer2 = head;
                    int recentIndex =0;
                    while(pointer2 != null && recentIndex < index){
                        pointer1 = pointer2;
                        pointer2 = pointer2.followingItem;
                        recentIndex++;
                    }
                    if(pointer2 != null){
                        if(pointer2 == end){
                            end = pointer1;
                            pointer1.followingItem = null;   
                        }else{
                            Item pointer3 = pointer2.followingItem;
                            pointer2.followingItem = null;
                            pointer1.followingItem = pointer3;
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
                    Item newHead = head.followingItem;
                    head.followingItem = null;
                    head = newHead;
                }else{
                    Item pointer1 = null;
                    Item pointer2 = head;
                    while(pointer2 != null && pointer2.number != number){
                        pointer1 = pointer2;
                        pointer2 = pointer2.followingItem;
                    } 
                    if(pointer2 != null){
                        if(pointer2 == end){
                            end = pointer1;
                            pointer1.followingItem = null;   
                        }else{
                            Item pointer3 = pointer2.followingItem;
                            pointer2.followingItem = null;
                            pointer1.followingItem = pointer3;
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
                            head = pointer2.followingItem;
                            pointer2.followingItem = null;
                            pointer2 = head;
                        }else{
                            if(pointer2 == end){
                                end = pointer1;
                                pointer1.followingItem = null;
                                pointer2 = null;
                            }else{
                                Item pointer3 = pointer2.followingItem;
                                pointer2.followingItem = null;
                                pointer1.followingItem = pointer3;
                                pointer2 = pointer3;
                            }         
                        }
                    }else{
                        pointer1 = pointer2;
                        pointer2 = pointer2.followingItem;
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
            pointer = pointer.followingItem;
            indexNumber++;
        }
        System.out.println();
        System.out.println("Index is: " + indexNumber);
    }
    public boolean isItFull(){
        if(head != null){
            return true;
        }else{
            return false;
        }
    }
}