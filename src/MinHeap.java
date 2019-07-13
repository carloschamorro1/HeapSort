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


    public boolean isEmpty(){
        return dynArray.isEmpty();
    }

    public void swap(int [] arr, int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void flotar(int indice){
        int padre = padre(indice);
        int posicion = indice;
        while (posicion > 0 && dynArray.arr[padre] > dynArray.arr[posicion]) {
            swap(dynArray.arr,posicion,padre);
            posicion = padre;
            padre = padre/2;
        }

}

    private void hundir(int indice) {
        int padre = indice;
        int hijoIzq = 2 * indice;
        int hijoDer = 2 * indice+1;
        if (hijoIzq < dynArray.size && dynArray.arr[padre] > dynArray.arr[hijoIzq]) {
            padre = hijoIzq;
        }
        if (hijoDer < dynArray.size && dynArray.arr[padre] > dynArray.arr[hijoDer]) {
            padre = hijoDer;
        }
        if (padre != indice) {
            swap(dynArray.arr,indice, padre);
            hundir(padre);
        }
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

}
