use crate::implementations::LinkedListNode::LinkedListNode;

pub trait LinkedListIteratorInterface<E> {
    fn new(head: Option<*const LinkedListNode<E>>) -> Self;
    fn has_next(&self) -> bool;
    fn next(&mut self) -> Option<&E>;
}
