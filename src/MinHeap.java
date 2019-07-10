public class MinHeap {
    DynArray dynArray;

    public MinHeap(DynArray dynArray){
        this.dynArray =dynArray;
    }

    private int padre(int indice) {
        return (indice / 2);
    }

    private int hijoIzq(int indice) {
        return (2 * indice);
    }

    private int hijoDer(int indice) {
        return (2 * indice) + 1;
    }


    private boolean isLeaf(int pos) {
        if (pos >= (dynArray.size / 2) && pos <= dynArray.size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return dynArray.isEmpty();
    }

    public void swap(int [] arr, int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void flotar(int indice){
        System.out.println(indice%2);
        if(indice % 2 == 1) {
            while (indice >= 1 && dynArray.arr[indice] < dynArray.arr[(indice / 2)]) {
                swap(dynArray.arr, indice, indice / 2);
                indice = indice / 2;
            }
        }
        else if(indice % 2 == 0)
            while (indice >= 1 && dynArray.arr[indice] < dynArray.arr[(indice / 2) - 1]) {
                swap(dynArray.arr, indice, (indice / 2) - 1);
                indice = indice / 2;
            }
    }

    private void hundir(int indice) {

        if(isLeaf(indice)){
            return;
        }

        int izq = indice * 2;
        int der = (indice * 2) + 1;
        int padre;


        if (der > dynArray.arr[0]) {
            padre = izq;
        } else {
            padre = this.dynArray.arr[izq] < this.dynArray.arr[der] ? izq : der;

        }
        if (this.dynArray.arr[indice] < this.dynArray.arr[padre]) {
            return;
        }
        swap(dynArray.arr, padre, indice);
        hundir(padre);
    }

    public void add(int elemento){
        dynArray.add(elemento);
        flotar(dynArray.size-1);
    }

    public int remove(){
        int retval = dynArray.removeFirst();
        if(dynArray.size != 0){
            this.dynArray.arr[0] = dynArray.arr[dynArray.size - 1];
            dynArray.size--;
            this.dynArray.arr[dynArray.size] = 0;
            this.hundir(0);
        }
        return retval;
    }


    public void sort(int[] arr){
        final int size = dynArray.size;
        int acumulador = 0;
        for (int i = 0; i <= size; i++) {
            flotar(size);
            dynArray.arr[acumulador++] = dynArray.arr[0];
        }

    }



//    public void heapify(int[] arr, int n, int i){
//        int menor = i-1;
//        int izquierda = (2 * i)-1;
//        int derecha = (2*i);
//
//        if(izquierda < n && arr[izquierda] < arr[menor]){
//            menor = izquierda;
//        }
//
//        if(derecha< n && arr[derecha] < arr[menor]){
//            menor = derecha;
//        }
//
//        if(menor != i-1){
//            swap(arr);
//            heapify(arr,menor,i);
//        }
//
//
//    }
//
//    public void sort(int[] arr){
//        final int size = dynArray.size;
//
//        for (int i = (size/2)-1; i >=0 ; i--) {
//            heapify(arr,size,i);
//        }
//        for (int i = size-1; i >= 0 ; i--) {
//            swap(arr);
//            heapify(arr,0,i-1);
//        }
//    }
}
