class Lion extends Animal {
    String species;
    //defualt constructor
    public Lion(){
        super();
        species = "Lion";
    }
    //constructer with parameters
    public Lion(String species){
        super(20);
        this.species = species;
        System.out.println("species: " + this.species);
    }

    @Override
	public void makeSound(){
		System.out.println("my sound: arrrrrrr");
	}
}