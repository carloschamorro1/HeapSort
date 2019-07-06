import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Creamos una referencia a nuestro arreglo dinamico
        DynArray dynArray = new DynArray();
        Random random = new Random();

        System.out.println("Bienvenido");
        System.out.println("Ingrese con cuantos elementos desea que se llene el arreglo de manera aleatoria");


        for (int i = 0; i <dynArray.arr.length; i++) {
            System.out.println(dynArray.arr[i]);
        }
//        MinHeap minHeap = new MinHeap();
//        minHeap.sort();
    }
}
