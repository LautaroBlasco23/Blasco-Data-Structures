use crate::interfaces::{LinkedListIteratorInterface::LinkedListIteratorInterface, LinkedListNodeInterface::LinkedListNodeInterface};

use super::LinkedListNode::LinkedListNode;

pub struct LinkedListIterator<E> {
    current_node: Option<*const LinkedListNode<E>>,
}

impl<E> LinkedListIteratorInterface<E> for LinkedListIterator<E> {
    fn new(head: Option<*const LinkedListNode<E>>) -> Self {
        LinkedListIterator { 
            current_node: head,
        }
    }

    fn has_next(&self) -> bool {
        match self.current_node {
            Some(_) => true,
            None => false,
        }
    }

    fn next(&mut self) -> Option<&E> {
        let mut current_element = None;
        unsafe {
            if self.current_node.is_some() {
                current_element = Some((*self.current_node.unwrap()).get_value());

                self.current_node = match (*self.current_node.unwrap()).get_next() {
                    Some(next_ptr) => Some(next_ptr as *const LinkedListNode<E>),
                    None => None
                }
            }
        }
        return current_element;
    }

}
