public class MinHeap {
    DynArray dynArray = new DynArray();

    public void swap(int [] arr, int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapify(int[] arr, int n, int i){
        int mayor = i;
        int izquierda = (2 * i) + 1;
        int derecha = (2*i) + 2;

        if(izquierda < n && arr[izquierda] > arr[mayor]){
            mayor = izquierda;
        }

        if(derecha< n && arr[derecha] > arr[mayor]){
            mayor = derecha;
        }

        if(mayor != i){
            swap(arr,n,mayor);
            heapify(arr,mayor,i);
        }


    }

}
