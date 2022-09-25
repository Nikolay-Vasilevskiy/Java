package JavaBinary;
//*2. Реализовать структуру данных "Очередь" на основе массива
//        2.1 Нужно сделать операцию "Добавить в очередь"
//        2.2 Нужно сделать операцию "Извлечь из очереди"

public class Queue {
    static Integer array[] = {2,4,5,6,7,8,9,12};//из этого массива формируем очередь

    public static void main(String[] args) {
        Node n = new Node(array[0],null,null); //сохраняем ссылку на первый элемент очереди в переменной n;
        Node temp = n;
        //добавляем в очередь элементы массива
        for  (int i = 1; i<array.length;i++){
            temp.offer(array[i]);
            temp = temp.next;
        }
        printNodes(n);//проверяем записались ли в очередь все элементы массива

        temp = n.poll();//вытаскиваем значение первого элемента очереди
        System.out.println("Первый элемент очереди =  " + temp.value);//выводим это значение
        System.out.println("После метода poll");
       printNodes(n);//убеждаемся, что первый элемент покинул очередь
        }

    static void printNodes(Node n){
      Node temp = n;
        System.out.println("Элементы очереди по порядку:");
        for  (int i = 0; i<n.getSize();i++){
            System.out.print(temp.value+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
   private static int size;
    Integer value;
    Node prev; //эта переменная в односвязном списке FIFO не используется, может пригодиться в дальнейшем если доделать его как полноценный двухсвязный с соответствующими методами
    Node next;
    public Node(){//технический конструктор
    }

    public Node(Integer value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
        size++;
    }
    //добавляем элемент в очередь
    public void offer (int i){
        this.next = new Node(i, this, null);
    }
    //вытаскиваем первый элемент из очереди
    public Node poll(){
        Node result  = new Node();
        result.value = this.value;
        // this = this.next не работает, поэтому приходится так: (копируем в нулевой элемент поля первого)
        this.value = this.next.value;
        this.next = this.next.next;
       this.next.next.prev = this;
        size--;
        return result;
    }
    public int getSize(){
        return this.size;
    }
}