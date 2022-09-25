package Homework6;
//1. Описать класс для работы с бинарным деревом
//        1.1 Реализовать три варианта обхода - ru.wikipedia.org/wiki/Обход_дерева#Прямой_обход_(NLR)
//        1.2 Сделать скобочную запись бинарного дерева


public class Binary {
    public static void main(String[] args) {
// создаем и заполняем бинарное дерево как на семинаре
 Nodes root = new Nodes("5");

         Nodes l1 = new Nodes("3");
         Nodes l11 = new Nodes("1");
         Nodes r12 = new Nodes("2");

         Nodes r2 = new Nodes("7");
         Nodes l21 = new Nodes("6");
         Nodes r21 = new Nodes("11");

        Nodes l221 = new Nodes("10");

         r2.left = l21; l21.left = l221;
         r2.right = r21;

         l1.left = l11;
         l1.right = r12;

         root.right = r2;
         root.left = l1;

       // 1.1 Реализовать три варианта обхода - ru.wikipedia.org/wiki/Обход_дерева#Прямой_обход_(NLR)
        System.out.println("NLR");
         NLR.View(root, "-");

        System.out.println("LNR");
         NLR.View(root, "-");

        System.out.println("LRN");
         LRN.View(root,"-");
        //        1.2 Сделать скобочную запись бинарного дерева
        System.out.println("NLR SKOBKI" );
        NLRSKOB.View(root," ");
    }

    }
//класс узлов дерева
 class Nodes {
 public Nodes(String v) {
 value = v;
 }

 String value;
 Nodes left;
 Nodes right;
 }

 class NLR {
    static void View(Nodes n, String space) {

    if (n != null) {//        Проверяем, не является ли текущий узел пустым или null.
        //        Показываем поле данных корня (или текущего узла).
    System.out.printf("%s%s\n", space, n.value);

         if (n.left != null) {//        Обходим левое поддерево рекурсивно, вызвав функцию прямого обхода.
 View(n.left, space + "*");}
 if (n.right != null) {//        Обходим левое поддерево рекурсивно, вызвав функцию прямого обхода.
 View(n.right, space + "*"); }
        }
    }
}
 class LNR{
    static void View(Nodes n, String space) {
     if (n != null) {//Проверяем,не является ли текущий узел пустым или null.
         if (n.left != null) {//        Обходим левое поддерево рекурсивно, вызвав функцию центрированного обхода.
             View(n.left, space + "*");
         }
         System.out.printf("%s%s\n", space, n.value);//        Показываем поле данных корня (или текущего узла).
         if (n.right != null) {//        Обходим правое поддерево рекурсивно, вызвав функцию центрированного обхода.
             View(n.right, space + "*");
         }
     }
 }
 }
class LRN{
    static void View(Nodes n, String space) {

        if (n != null) {//Проверяем,не является ли текущий узел пустым или null.
            if (n.left != null) {//        Обходим левое поддерево рекурсивно, вызвав функцию центрированного обхода.
                View(n.left, space + " ");
            }

            if (n.right != null) {//        Обходим правое поддерево рекурсивно, вызвав функцию центрированного обхода.
                View(n.right, space + " ");
            }
            System.out.printf("%s%s\n", space, n.value);//        Показываем поле данных корня (или текущего узла).
        }
    }
}
class NLRSKOB {
    static void View(Nodes n, String space) {

        if (n != null) {//        Проверяем, не является ли текущий узел пустым или null.
            //        Показываем поле данных корня (или текущего узла).
            System.out.printf("%s%s", space, n.value);

            if (n.left != null) {//        Обходим левое поддерево рекурсивно, вызвав функцию прямого обхода.
                System.out.print("(");
                View(n.left, space);
            }
            if (n.right != null) {
                System.out.print(",");//        Обходим левое поддерево рекурсивно, вызвав функцию прямого обхода.
                View(n.right, space );
            }
             if (n.left!=null) System.out.print(")");
        }
    }
}