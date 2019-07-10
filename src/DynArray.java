public class DynArray {
    public int[] arr;
    public int size;

    public int [] arr2;
    public int size2;

    public void addHeap(int element){
        if(size2 < arr2.length){
            arr2[size2++] = element;
        }
        else{
            grow(element);
        }
    }
    public DynArray(){
        this.arr = new int[10];
        this.arr2 = new int[10];
        size = 0;
        size2 = 0;
    }

    public DynArray(int [] arr){
        this.arr = arr;
    }


    private void grow(int element){
        int [] temp = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        arr[size++] = element;
    }
    public void add(int element) {
        if(size < arr.length){
            arr[size++] = element;
        }
        else{
            grow(element);
        }
    }

    public void narrow(int size){
        if(size != arr.length){
            int temp[] = new int[size];
            for (int i = 0; i < temp.length ; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        else{
            System.out.println("No se puede acotar mas el arreglo");
        }
    }

    public void queues(int element){
        removeFirst();
        add(element);
    }

    public void stack(int element){
        removeLast();
        add(element);
    }

    public int removeFirst(){
        return arr[0];
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int removeLast(){
        int retval = arr[0];
        for (int i = 0; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size--;
        return retval;
    }


    public int getItem(int index){
        return arr[index];
    }

    public int getSize(){
        return size;
    }
}
