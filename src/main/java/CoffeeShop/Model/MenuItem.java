package CoffeeShop.Model;

import CoffeeShop.Exceptions.InvalidCategoryException;

public class MenuItem {

    private String category;
    private String item;
    private double cost;
    private String id;

    public MenuItem(String category, String item, double cost, String id  ) {
        if(category.equals("Starters")||category.equals("Main Course")||category.equals("Desserts")||category.equals("Drinks")||category.equals("Other"))
            this.category = category;
        else
            throw new InvalidCategoryException("Invalid Category");
        this.item = item;
        if(cost>0)
            this.cost = cost;
        if(id.length()>0 && id.length() <7)
            this.id = id;
    }

    public String getCategory(){
        return this.category;
    }

    public String getItem(){
        return this.item;
    }

    public double getCost(){
        return this.cost;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String toString(){
        return "Category: "+ this.category + "\tItem: " + this.item + "\t\tCost: " + this.cost + "\tId: " + this.id + "\n";
    }
}