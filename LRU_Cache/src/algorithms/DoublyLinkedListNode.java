package algorithms;

public class DoublyLinkedListNode<E> {

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public E getElement() {
        return element;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element)
    {
        this.next = null;
        this.prev = null;
        this.element = element;
    }
}
