import java.util.LinkedList;

class ParseTree {

    private String type;
    private String value;
    private LinkedList<ParseTree> children;

    /**
     * A node in a Parse Tree data structure
     * @param type The type of node (see element types).
     * @param value The node's value. This should only be present on terminal nodes/leaves, and empty otherwise.
     */
    public ParseTree(String type, String value){
        this.type = type;
        this.value = value;
        this.children = new LinkedList<ParseTree>();
    }

    /**
     * Adds a ParseTree as a child of this ParseTree
     * @param child The ParseTree to add
     */
    public void addChild(ParseTree child){
        this.children.add(child);
    }

    /**
     * Get a list of child nodes in the order they were added.
     * @return A LinkedList of ParseTrees
     */
    public LinkedList<ParseTree> getChildren(){
        return this.children;
    }

    /**
     * Get the type of this Node
     * @return The type of node (see element types).
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get the value of this Node
     * @return The node's value. This should only be used on terminal nodes/leaves, and empty otherwise.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Generate a string from this ParseTree
     * @return A printable representation of this ParseTree
     */
    public String toString() {
        return this.toString(0);
    }

    /**
     * Generate a string from this ParseTree
     * @return A printable representation of this ParseTree with indentation
     */
    public String toString(int depth) {
        
        // Set indentation
        String indent = "";
        for(int i=0; i<depth; i++){
            indent += "  \u2502 ";
        }

        // Generate output
        String output = "";
        if(this.children.size()>0){
            // Output if the node has children
            output += this.type + "\n";
            for (ParseTree child : children){
                output += indent + "  \u2514 " + child.toString(depth+1);
            }
            output += indent + "\n";
        } else {
            // Output if the node is a leaf/terminal
            output += this.type + " " + this.value + "\n";
        }
        return output;

    }

} 
