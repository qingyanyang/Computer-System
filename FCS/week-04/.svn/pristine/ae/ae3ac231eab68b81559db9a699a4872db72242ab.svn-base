class Main{
    public static void main(String[] args){
        //create new instance named book1 of Ebook class
        EBook ebook1 = new EBook("https://media.pearsoncmg.com", "EBook");
        System.out.println("type: " + ebook1.getType());
        //call super class Mutator
        ebook1.setTitle("java programming");
        ebook1.setPages(415);
        //call super class method
        ebook1.display();
        System.out.println("url: " + ebook1.url);

        System.out.println("\n" + "-----------" + "\n");

        //create new instance named book1 of PhycicalBook class
        PhysicalBook book1 = new PhysicalBook(1, 2, 3);
        //call subclass Mutator
        ebook1.setType("Physical Book");
        System.out.println("type: " + ebook1.getType());
        //call super class Mutator
        book1.setTitle("java practise");
        book1.setPages(102);
        //call super class method
        book1.display();
        //call method in subclass
        book1.displayBookLocation();
    }
}