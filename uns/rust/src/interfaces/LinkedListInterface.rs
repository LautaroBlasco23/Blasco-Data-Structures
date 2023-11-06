use crate::implementations::LinkedListNode::LinkedListNode;

pub trait LinkedListInterface<E> {
    // Constructor
    fn new() -> Self;
    // Getters
    fn get_size(&self) -> usize;
    fn get_head(&self) -> Option<*mut LinkedListNode<E>>;
    fn get_vec_of_elements(&self) -> Vec<Option<*mut LinkedListNode<E>>>;
    // Push methods
    fn push_front(&mut self, element: E);
    fn push_back(&mut self, element: E);
    fn push_after(&mut self, element: E, position: *mut LinkedListNode<E>);
    fn push_before(&mut self, element: E, position: *mut LinkedListNode<E>);
    // Pop methods
    fn pop_front(&mut self) -> Option<&E>;
    fn pop_back(&mut self) -> Option<&E>;
    fn pop_element(&mut self, element: E) -> Option<&E>;
}
