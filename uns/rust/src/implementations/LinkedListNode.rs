use crate::interfaces::LinkedListNodeInterface::LinkedListNodeInterface;

// This node is developed for Linked Lists with only 1 Link.
pub struct LinkedListNode<E> {
    value: E,
    next: Option<*mut LinkedListNode<E>>,
}

impl<E> LinkedListNodeInterface<E> for LinkedListNode<E> {
    // constructor 
    fn new(element: E) -> Self {
        LinkedListNode { 
            value: element, 
            next: None, 
        }
    }

    // setters
    fn set_value(&mut self, value: E) {
        self.value = value;
    }

    fn set_next(&mut self, next: Option<*mut LinkedListNode<E>>) {
        self.next = next;
    }

    // getters
    fn get_value(&self) -> &E {
        &self.value
    }

    fn get_next(&self) -> Option<*mut LinkedListNode<E>> {
        self.next
    }
}
