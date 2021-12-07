package com.company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCard implements Serializable{
    private static final long serialVersionUID = 1L;

    private int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private double cartTotal;
    private Date date;

    public ShoppingCard(int id, ArrayList<Item> item){
        cartID = id;
        items = item;
        itemCount = item.size();
        cartTotal = 0;
        for(var it : item){
            cartTotal += it.getCost();
        }
    }

    public String toString() {
        return "SavedCard{" +
                "cardId=" + cartID +
                ",\n Items:" + items +
                ",\n itemCount=" + itemCount +
                ",\n totalSum=" + cartTotal +
                '}';
    }

    public ShoppingCard writeObject(){
        date = new Date();
        return this;
    }

    public void readObject(){
        double sum = 0.;
        for(var it : items){
            sum += it.getCost();
        }
        System.out.println(date+"  ::  "+sum);
    }
    /*
    • Создать приложение, сереализующее объект класса ShoppingCart, который представлен в виде ArrayList из Item
    • Используйте ключевое слово transient для предотвращения сериализации общей суммы ShoppingCart. Это позволит правильно считать сумму.
    • Используйте метод writeObject для сохранения сегодняшней даты
    • Используйте метод readObject, чтобы пересчитать общую стоимость корзины после десериализации и напечатайте дату, когда объект был сериализован
     */

}
