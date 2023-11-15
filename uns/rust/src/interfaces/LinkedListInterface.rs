use crate::implementations::{LinkedListNode::LinkedListNode, LinkedListIterator::LinkedListIterator};

pub trait LinkedListInterface<T> {
    // Constructor
    fn new() -> Self;
    // Getters
    fn get_size(&self) -> usize;
    fn get_head(&self) -> Option<*mut LinkedListNode<T>>;
    fn get_vec_of_elements(&self) -> Vec<T>;
    // Push methods
    fn push_front(&mut self, element: T);
    fn push_back(&mut self, element: T);
    fn push_after(&mut self, element: T, position: *mut LinkedListNode<T>);
    fn push_before(&mut self, element: T, position: *mut LinkedListNode<T>);
    // Pop methods
    fn pop_front(&mut self) -> Option<&T>;
    fn pop_back(&mut self) -> Option<&T>;
    fn pop_element(&mut self, element: T) -> Option<&T>;
    // Iterator
    fn iterator(&self) -> LinkedListIterator<T>;
}
