import java.util.Random;

public class Main {

    
    public static void main(String[] args) {

        DynArray dynArray = new DynArray();
        LectorTeclado lt = new LectorTeclado();
        Random random = new Random();
        MinHeap minHeap = new MinHeap(dynArray);
        int opcion = lt.leerEntero("Ingrese un numero entero indicando la cantidad de elementos que desea en el arreglo de manera aleatoria",
                                "Por favor ingrese un numero entero");

        for (int i = 0; i <opcion ; i++) {
            minHeap.add(random.nextInt(1000));
        }



//        minHeap.add(5);
//        minHeap.add(3);
//        minHeap.add(17);
//        minHeap.add(10);
//        minHeap.add(84);
//        minHeap.add(19);
//        minHeap.add(6);
//        minHeap.add(22);
//        minHeap.add(9);
//        minHeap.add(-6);
//        minHeap.add(-22);
//        minHeap.add(-9);

        //Arreglo sin ordenar
        System.out.print("Arreglo sin ordenar: {");
        dynArray.narrow(dynArray.size);
        print(dynArray.arr);
        System.out.println("}");
        System.out.print("El Min Heap es: {");
        while (!minHeap.isEmpty()) {
            dynArray.addHeap(minHeap.remove());
        }

        minHeap.dynArray.narrowHeap(dynArray.size2);
        print(minHeap.dynArray.arr2);
        System.out.println("}");
    }
    //Metodo para imprimir los arreglos
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else
                System.out.print(arr[i]);
        }
    }
}
