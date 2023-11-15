use crate::interfaces::{LinkedListIteratorInterface::LinkedListIteratorInterface, LinkedListNodeInterface::LinkedListNodeInterface};

use super::LinkedListNode::LinkedListNode;

pub struct LinkedListIterator<T> {
    current_node: Option<*mut LinkedListNode<T>>,
}

impl<T: Copy> Iterator for LinkedListIterator<T> {
    type Item = T;

    fn next(&mut self) -> Option<Self::Item> {
        unsafe {
            if self.current_node.is_some() {
                let result = Some(*(*self.current_node.unwrap()).get_value());
                self.current_node = (*self.current_node.unwrap()).get_next();
                return result;
            } else {
                return None
            }
        }
    }

}

impl<T: Copy> LinkedListIteratorInterface<T> for LinkedListIterator<T> {
    fn new(head: Option<*mut LinkedListNode<T>>) -> Self {
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
}
