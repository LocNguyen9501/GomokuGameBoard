public class Heap<T extends Comparable<T>>{
  
  private T[] items;
  private int maxItems;
  private int numItems;
  private int[] numOfItems;
  private int timesInserted = 0;
  
  public Heap(int maxSize){
    items =  (T[]) new Object[maxSize];
    numOfItems = new int[maxSize];
    numItems = 0;
    this.maxItems = maxSize;
  }
  
  public T deletMax(){
    T toRemove = items[0];
    numOfItems[0] = numOfItems[numItems-1]; 
    items[0] = items[numItems-1];
    numItems--;
    siftDown(0);
    return toRemove;
  }
  
  public void insert(T item){
    if(numItems == maxItems){
      T[] newList = (T[]) new Object[maxItems*2+1];
      
      for(int i =0; i<numItems;i++)
        newList[i]=items[i];
      newList = items;
    }
      items[numItems] = item;
      numOfItems[numItems] = timesInserted;
      timesInserted++;
      numItems++;
      siftUp(numItems-1);
     }

   
  public void siftUp(int index){
    while(index>0 && compare(index,(index-1)/2)==true){
      T save = items[(index-1)/2];
      items[(index-1)/2] = items[index];
      items[index] = save;
      index = (index-1)/2;
    }
  }
  
  public void siftDown(int index){
    int cursor = index;
    int child = 2*cursor +1;
    while(child<numItems){
      if(child+1<numItems && items[child].compareTo(items[child+1])<0)
         child++;
      if(compare(cursor,child)==true)
        break;
      else{
       T save = items[child];
       items[child] = items[index];
       items[index]= save;
      }
    }
  }
  
  public boolean compare(int index1, int index2){
    if(items[index1].compareTo(items[index2]) >= 0){
      if(items[index1].compareTo(items[index2])==0){
        if(numOfItems[index1] < numOfItems[index2])
          return true;
        else
          return false;
      }
      else
        return true;
    }
    return false;
    
  }
  
    }
    

  
