class EBook extends Book{
    String url, type;
    //defualt constructor
    public EBook(){
        super(2020);
        url = "www.google.com";
        type = "EBook";

    }
    //create constractor with parameter and call super class constractor
    public EBook(String url, String type){
        super(2020);
        this.url = url;
        this.type = type;
    }
    //accessor
    public String getType(){
        return this.type;
    }
    //mutator
    public void setType(String type){
        this.type = type;
    }
}