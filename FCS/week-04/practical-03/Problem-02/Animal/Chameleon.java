class Chameleon extends Animal {
    String species;
    //defualt constructor
    public Chameleon(){
        super();
        species = "Chameleon";
    }
    //constructor with parameters
    public Chameleon(String species){
        super(18);
        this.species = species;
        System.out.println("species: " + this.species);
    }

    @Override
	public void makeSound(){
		System.out.println("my sound: gugugugugu");
	}
}