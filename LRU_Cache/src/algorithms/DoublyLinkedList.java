package algorithms;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList()
    {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void detachNode(DoublyLinkedListNode<E> node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addElementAtLast(E element)
    {
        if(element==null)
            throw new RuntimeException("Element is null");
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> newNode) {
        DoublyLinkedListNode tailPrev = dummyTail.prev;
        dummyTail.prev.next = newNode;
        dummyTail.prev = newNode;
        newNode.next = dummyTail;
        newNode.prev = tailPrev;
    }

    boolean isNodePresent()
    {
        if(dummyHead.next != dummyTail.prev)
        {
            return true;
        }
        return false;
    }
    public DoublyLinkedListNode getFirstNode()
    {
        if(!isNodePresent())
            return null;
        DoublyLinkedListNode node = dummyHead.next;
        return node;
    }
    public DoublyLinkedListNode getLastNode()
    {
        if(!isNodePresent())
            return null;
        DoublyLinkedListNode node = dummyTail.prev;
        return node;
    }

    public void traverseLL()
    {
        System.out.println("Showinf current cache");
        for(DoublyLinkedListNode node = dummyHead; node!=dummyTail; node = node.next)
        {
            System.out.println(node.element + "  --->  ");
        }
    }
}
