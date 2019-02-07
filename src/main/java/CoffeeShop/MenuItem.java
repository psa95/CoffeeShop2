package CoffeeShop;

class MenuItem {

    private String category;
    private String item;
    private Float cost;
    private Integer id;

    MenuItem(String category, String item, Float cost, Integer id  ) {
        this.category = category;
        this.item = item;
        this.cost = cost;
        this.id = id;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getItem(){
        return this.item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public Float getCost(){
        return this.cost;
    }

    public void setCost(Float cost){
        this.cost = cost;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void Dessert(String category, String item, Float cost, Integer id) {
        //TODO: Implement Dessert Method
    }

}