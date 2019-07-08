public class MinHeap {
    DynArray dynArray;

    public MinHeap(DynArray dynArray){
        this.dynArray =dynArray;
    }

    private int padre(int indice) {
        return indice / 2;
    }

    private int hijoIzq(int indice) {
        return (2 * indice);
    }

    private int hijoDer(int indice) {
        return (2 * indice) + 1;
    }

    private boolean isLeaf(int indice) {
        if (indice >= (dynArray.size / 2) && indice <= dynArray.size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return dynArray.isEmpty();
    }

    private void flotar(int indice){
        while(indice > 1 && dynArray.arr[padre(indice)] < dynArray.arr[indice]) {
            swap(dynArray.arr, indice, padre(indice));
            flotar(padre(indice));
        }
    }

    private void hundir(int indice) {
        int padre;
        int izq;
        int der;
        do {
            padre = indice;
            izq = (2 * indice);
            der = (2 * indice) + 1;

            if (der <= this.dynArray.size && dynArray.arr[der] > dynArray.arr[indice]) {
                indice = der;
            }

            if (izq <= this.dynArray.size && dynArray.arr[izq] > dynArray.arr[indice]) {
                indice = izq;
            }
            swap(dynArray.arr, padre, indice);
            indice = indice/2;
        } while (padre == indice) ;
    }

    public void add(int elemento){
        dynArray.add(elemento);
        flotar(dynArray.size - 1);
    }

    public int remove(int[]arr, int elemento){
        swap(arr,0,elemento);
        int retval = dynArray.arr[dynArray.size-1];
        dynArray.size--;
        hundir(padre(elemento));
        return retval;
    }

    public void swap(int [] arr, int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
