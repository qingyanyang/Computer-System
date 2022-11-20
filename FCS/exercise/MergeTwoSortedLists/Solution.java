public class Solution {
    public static Node MergeTwoLists(NodeList list1, NodeList list2){
        Node tmp1 = list1.head;
        Node tmp2 = list2.head;
        NodeList newList = new NodeList();
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val < tmp2.val){
                newList.addNode(tmp1.val);
                tmp1 = tmp1.next;
            }else if(tmp1.val > tmp2.val){
                newList.addNode(tmp2.val);
                tmp2 = tmp2.next;
            }else{
                newList.addNode(tmp1.val);
                newList.addNode(tmp2.val);
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
        }
        while(tmp1 != null){
            newList.addNode(tmp1.val);
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            newList.addNode(tmp2.val);
            tmp2 = tmp2.next;
        }
        return newList.head;
    }

    public static void main(String[] args) {
        NodeList list1 = new NodeList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(4);
        NodeList list2 = new NodeList();
        list2.addNode(1);
        list2.addNode(3);
        list2.addNode(4);
        NodeList listNew = new NodeList();
        listNew.head = MergeTwoLists(list1, list2);
        listNew.printList();
    }
}
