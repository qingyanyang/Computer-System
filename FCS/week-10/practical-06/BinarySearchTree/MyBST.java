#include <iostream>
#include <vector>
#include <sstream>
#include<algorithm>
using namespace std;
class Node{
public:
    int value;
    Node* left;
    Node* right;

    //constructor
    Node() : value(NULL), left(NULL),right(NULL){};
    Node(int value) : value(value), left(NULL),right(NULL){};
    //print node method
    void printNode(){
        cout << value;
    }
};
class AVLTree{
public:
    Node* root;
    int height;
    vector<Node*> vec;
    AVLTree() : root(NULL), height(0){};

    Node** find(Node* current, Node* pre, int value){
        if(current != NULL){
            if(value == current->value){
                static Node* array[2];
                array[0]=pre;
                array[1]=current;
                //array[1]->printNode();
                return array;
            }else if(value > current->value){
                pre = current;
                return find(current->right, pre, value);
            }else{
                pre = current;
                return find(current->left, pre, value);
            }
        }else{
            return NULL;
        }
    }

    Node* insertNodeRec(Node* current, int value) {
        if(current==NULL){
            //create a pointer point the new object
            return new Node(value);
        }else{
            if(value > current->value){//the object.value which the current pointer point
                current->right = insertNodeRec(current->right, value);
            }else if(value < current->value){
                current->left = insertNodeRec(current->left, value);
            }
            return current;
        }
    }
    void deleteNode(int value){
        //Node* tempRoot = root;
        Node** array = find(root, NULL, value);
        if(array!=NULL){
            Node* pre = *array;
            Node* current = *(array + 1);
            if(current->right == NULL && current->left == NULL){
                if(pre != NULL){
                    if(pre->right == current){
                        pre->right = NULL;
                    }else{
                        pre->left = NULL;
                    }
                }else{
                    root = NULL;
                }
            }else if(current->right == NULL && current->left != NULL) {
                if(pre != NULL){
                    if(pre->right == current){
                        pre->right = current->left;
                    }else{
                        pre->left = current->left;
                    }
                }else{
                    root = current->left;
                }
            }else if(current->left == NULL && current->right != NULL) {
                if(pre != NULL){
                    if(pre->right == current){
                        pre->right = current->right;
                    }else{
                        pre->left = current->right;
                    }
                }else{
                    root = current->right;
                }
                //current = current->right;
            }else if(current->left != NULL && current->right != NULL){
                Node* leftNodeTmp = current->left;
                Node* rightMostNode = leftNodeTmp;
                Node* rightMostPre = current;
                int count = 0;
                while(leftNodeTmp->right != NULL){
                    rightMostPre = leftNodeTmp;
                    rightMostNode = leftNodeTmp->right;
                    leftNodeTmp = leftNodeTmp->right;
                    count++;
                }
                current->value = rightMostNode->value;
                if(count == 0){
                    current->left = rightMostNode->left;
                }else{
                    rightMostPre->right = rightMostNode->left;
                }
            }
        }
    }

    //calculate level of node
    int computeLevel(Node* node){
        if(node != NULL){
            return max(computeLevel(node->left), computeLevel(node->right))+1;
        }else{
            return 0;
        }
    }
    //compute balance of node
    int computeBalance(Node* node){
        int balance = computeLevel(node->left)-computeLevel(node->right);
        return balance;
    }
    //balanceCheck
    void checkBalance(Node* node){
        if(node != NULL){
            checkBalance(node->left);
            checkBalance(node->right);
            //cout<<computeBalance(node)<<node->value<<endl;
            if( abs(computeBalance(node)) >= 2){
                vec.push_back(node);
            }
        }
    }
    //left rotate
    void leftRotate(Node* node){
        Node* right = node->right;
        Node* pre = *find(root,NULL,node->value);
        //cout<<pre->value<<endl;
        if(pre!=NULL){
            if(pre->left == node ){
                pre->left = right;
                node->right = right->left;
                right->left = node;
            }else if(pre->right == node){
                pre->right = right;
                node->right = right->left;
                right->left = node;
            }
        }else{
            root = right;
            node->right = right->left;
            root->left = node;
        }
    }
    //right rotate
    void rightRotate(Node* node){
        Node* left = node->left;
        Node* pre = *find(root,NULL,node->value);
//        cout<<pre->right->value<<endl;
//        cout<<node->value<<endl;
        if(pre!=NULL){
//            cout<<pre->right->value<<endl;
//            cout<<node->value<<endl;
//            cout<<((pre->left->value) == (node->value))<<endl;
            if(pre->left == node){
                pre->left = left;
                node->left = left->right;
                left->right = node;
            }
            if(pre->right == node){
                pre->right = left;
                node->left = left->right;
                left->right = node;
            }
        }else{
            root = left;
            node->left = left->right;
            root->right = node;
        }
    }
    //balance
    void balance(Node* node){
        if(computeBalance(node)==-2){
            if(computeBalance(node->right)<=0){
                leftRotate(node);
            }else{
                rightRotate(node->right);
                leftRotate(node);
            }
        }else{
            if(computeBalance(node->left)>=0){
                rightRotate(node);
            }else{
                leftRotate(node->left);
                rightRotate(node);
            }
        }
    }
    //insert AVL tree
    void insertAVL(int value){
        root = insertNodeRec(root, value);
        //cout<<root->value<<endl;
        checkBalance(root);
        if(!vec.empty()){
            cout<<vec[0]->value<<endl;
            balance(vec[0]);
            vec.clear();
        }
    }
    //delete AVL tree
    void deleteAVL(int value){
        deleteNode(value);
        checkBalance(root);
        if(!vec.empty()){
            balance(vec[0]);
            vec.clear();
        }
    }
    //traverse
    //inorder
    void inOrderDisplay(){
        if(root!=NULL){
            inOrderDisplayRec(root);
        }else{
            cout<<"EMPTY"<<endl;
        }
    }
    void inOrderDisplayRec(Node* node){
        if(node != NULL){
            inOrderDisplayRec(node->left);
            cout << node->value;
            cout<<" ";
            inOrderDisplayRec(node->right);
        }
    }
    //preorder
    void preOrderDisplay(){
        if(root!=NULL){
            preOrderDisplayRec(root);
        }else{
            cout<<"EMPTY"<<endl;
        }
    }
    void preOrderDisplayRec(Node* node){
        if(node != NULL){
            cout << node->value;
            cout<<" ";
            preOrderDisplayRec(node->left);
            preOrderDisplayRec(node->right);
        }
    }
    //postorder
    void postOrderDisplay(){
        if(root!=NULL){
            postOrderDisplayRec(root);
        }else{
            cout<<"EMPTY"<<endl;
        }
    }
    void postOrderDisplayRec(Node* node){
        if(node != NULL){
            postOrderDisplayRec(node->left);
            postOrderDisplayRec(node->right);
            cout << node->value;
            cout<<" ";
        }
    }
};


int main()
{
    vector<string> operationsSet;
    string line;
    string traverseCommand;
    getline(cin, line);
    istringstream iss(line);
    for (string d; iss >> d; operationsSet.push_back(d)) {};
    traverseCommand = operationsSet.back();
    operationsSet.pop_back();

    AVLTree myAVLTree;
    for(string operation : operationsSet){
        if(operation[0]=='A'){
            int value = stoi(operation.substr(1, operation.find(" ")));
            //myAVLTree.root = myAVLTree.insertNodeRec(myAVLTree.root, value);
            myAVLTree.insertAVL(value);
            //cout<<myAVLTree.root->value<<endl;
        }else{
            int value = stoi(operation.substr(1, operation.find(" ")));;
            //myAVLTree.deleteNode(value);
            myAVLTree.deleteAVL(value);
        }
    }

//    myAVLTree.checkBalance(myAVLTree.root);
//    cout<< myAVLTree.vec[0]->value << endl;

    if(traverseCommand=="IN"){
        myAVLTree.inOrderDisplay();
    }else if(traverseCommand=="PRE"){
        myAVLTree.preOrderDisplay();
    }else{
        myAVLTree.postOrderDisplay();
    }
}