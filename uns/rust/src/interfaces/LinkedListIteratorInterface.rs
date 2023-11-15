use crate::implementations::LinkedListNode::LinkedListNode;

pub trait LinkedListIteratorInterface<E>: Iterator {
    fn new(head: Option<*mut LinkedListNode<E>>) -> Self;
    fn has_next(&self) -> bool;
}
