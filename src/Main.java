
public class Main {


    public static void main(String[] args) {

        System.out.println("The Min Heap is ");
        DynArray dynArray = new DynArray();
        MinHeap minHeap = new MinHeap(dynArray);

        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);
        while (!minHeap.isEmpty()) {
            dynArray.addHeap(minHeap.remove());
        }

        minHeap.dynArray.narrowHeap(dynArray.size2);
        print(minHeap.dynArray.arr2);
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

//

//    public static void main(String[] args) {
//        //Creamos una referencia a nuestro arreglo dinamico
//        DynArray dynArray = new DynArray();
//        LectorTeclado lt = new LectorTeclado();
//        Random random = new Random();
//
//        System.out.println("Bienvenido");
//        int opcion = lt.leerEntero("Ingrese un numero entero indicando la cantidad de elementos que desea en el arreglo de manera aleatoria",
//                                "Por favor ingrese un numero entero");
//
////        for (int i = 0; i <opcion ; i++) {
////            dynArray.add(random.nextInt(100));
////        }
////        dynArray.narrow();
////
////        //Arreglo sin ordenar
////        System.out.print("Arreglo sin ordenar {");
////        print(dynArray.arr);
////        System.out.print("}");
//
//
//        dynArray.add(15);
//        dynArray.add(25);
//        dynArray.add(17);
//        dynArray.add(45);
//        dynArray.add(35);
//        dynArray.narrow();
//        MinHeap minHeap = new MinHeap(dynArray);
//        minHeap.sort(dynArray.arr);
//
//        System.out.print("Arreglo ordenado {");
//        print(dynArray.arr);
//        System.out.print("}");
//    }
//

//    }
//}
