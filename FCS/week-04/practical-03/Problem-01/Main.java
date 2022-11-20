class Main{
    public static void main(String[] args){
        //create animal object to set info
        System.out.println("Animal:");
        Animal animal1 = new Animal(3);
        animal1.setName("Pika");
        animal1.display();
        //create book object to set info
        System.out.println("\n" + "Book:");
        Book book1 = new Book(2014);
        book1.setTitle("java programming");
        book1.display();
        //create person object to set info
        System.out.println("\n" + "Person:");
        Person person1 = new Person(27);
        person1.setGivenName("qingyan");
        person1.setLastName("yang");
        person1.display();
        //create shape object to set info
        System.out.println("\n" + "Shape:");
        Shape shape1 = new Shape();
        shape1.setWidth(34.5d);
        shape1.setHeight(33.4d);
        shape1.setRadius(30.4d);
        shape1.setLength(55.4d);
        System.out.println("witdth(cm): " + shape1.getWidth());
        System.out.println("witdth(cm): " + shape1.getHeight());
        System.out.println("witdth(cm): " + shape1.getRadius());
        System.out.println("witdth(cm): " + shape1.getLength());

    }
}