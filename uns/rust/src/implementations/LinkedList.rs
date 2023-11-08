use super::LinkedListIterator::LinkedListIterator;
// Node struct and interface
use super::LinkedListNode::LinkedListNode;
use crate::interfaces::LinkedListIteratorInterface::LinkedListIteratorInterface;
use crate::interfaces::LinkedListNodeInterface::LinkedListNodeInterface; 
// Linked List interface
use crate::interfaces::LinkedListInterface::LinkedListInterface;

pub struct LinkedList<E> {
    head: Option<*mut LinkedListNode<E>>,
    size: usize,
}

impl<E: PartialEq> LinkedListInterface<E> for LinkedList<E> {
    // Constructor
    fn new() -> Self {
        LinkedList {
            head: None,
            size: 0,
        }
    }

    // Push methods 
    fn push_front(&mut self, element: E) {
        let new_head = Box::into_raw(Box::new(LinkedListNode::new(element)));
        
        unsafe {
            match self.head.take() {
                None => {
                    self.head = Some(new_head);
                }
                Some(old_head) => {
                    (*new_head).set_next(Some(old_head));
                    self.head = Some(new_head);
                }
            }
        }
        self.size += 1;
    }

    fn push_back(&mut self, element: E) {
        let new_tail = Box::into_raw(Box::new(LinkedListNode::new(element)));
        
        unsafe {
            match self.head {
                None => {
                    self.head = Some(new_tail);
                }
                Some(mut current_node) => {
                    while (*current_node).get_next().is_some() {
                        current_node = (*current_node).get_next().unwrap();
                    }
                    (*current_node).set_next(Some(new_tail));
                }
            }
        }

        self.size += 1;
    }

    fn push_after(&mut self, element: E, position: *mut LinkedListNode<E>) {
        let new_node = Box::into_raw(Box::new(LinkedListNode::new(element)));
        let mut current_node_ptr = self.head;

        unsafe {
            while let Some(node) = current_node_ptr {
                if (*node).get_value() != (*position).get_value() {
                    current_node_ptr = (*node).get_next();
                } else { 
                    // If our current_node value equals the position value, we found the node.
                    if (*node).get_next().is_some() {
                        (*new_node).set_next((*node).get_next());
                    }
                    (*node).set_next(Some(new_node));
                    self.size += 1; 
                }
            }
        }
    }

    fn push_before(&mut self, element: E, position: *mut LinkedListNode<E>) {
        let new_node = Box::into_raw(Box::new(LinkedListNode::new(element)));
        let mut current_node_ptr = self.head;

        unsafe {
            // If head is the position we're looking for, we've to change the head of the list.
            if current_node_ptr.is_some() {
                if (*current_node_ptr.unwrap()).get_value() == (*position).get_value() {
                    (*position).set_next(current_node_ptr);
                    self.head = Some(position);
                }
            } else {
                current_node_ptr = (*current_node_ptr.unwrap()).get_next();
                let mut previous_node_ptr = current_node_ptr;
                while let Some(node) = current_node_ptr {
                    if (*node).get_value() != (*position).get_value() {
                        // if the value differ, we go to the next node.
                        previous_node_ptr = current_node_ptr;
                        current_node_ptr = (*node).get_next();
                    } else { 
                        // If our current_node value equals the position value, we found the node.
                        // So we're going to replace the previous node ptr, to the new node we want
                        // to insert.
                        (*previous_node_ptr.unwrap()).set_next(Some(new_node));
                        (*new_node).set_next(current_node_ptr);
                        self.size += 1;
                    }
                }
            }
        }
    }

    // Getters
    fn get_size(&self) -> usize {
        self.size
    }

    fn get_head(&self) -> Option<*mut LinkedListNode<E>> {
        self.head
    }

    // Pop methods
    fn pop_back(&mut self) -> Option<&E> {
        let mut previous_node_ptr = None;
        let mut current_node_ptr = self.head;
        unsafe {
            if current_node_ptr.is_some() {
                while let Some(node) = current_node_ptr {
                    if (*node).get_next().is_some() {
                        previous_node_ptr = current_node_ptr;
                        current_node_ptr = (*node).get_next();
                    } else {
                        if previous_node_ptr.is_some() {
                            (*previous_node_ptr.unwrap()).set_next(None);
                            self.size -= 1;
                        } else {
                            self.head = None;
                            self.size -= 1;
                        }
                        return Some((*current_node_ptr.unwrap()).get_value());
                    }
                }
            }
        }
        None
    }

    fn pop_front(&mut self) -> Option<&E> {
        unsafe {
            match self.head.take() {
                Some(old_head) => {
                    self.head = (*old_head).get_next();
                    return Some((*old_head).get_value());
                }
                None => {
                    return None;
                }
            }
        }
    }

    fn pop_element(&mut self, element: E) -> Option<&E> {
        let mut previous_node_ptr: Option<*mut LinkedListNode<E>> = None;
        let mut current_node_ptr = self.head;
        unsafe {
            while let Some(node) = current_node_ptr {
                // if we found the element we were looking for
                if (*node).get_value() == &element {
                    // if the element isn't the head of our list.
                    if previous_node_ptr.is_some() {
                        (*previous_node_ptr.unwrap()).set_next((*node).get_next());
                        return Some(&(*node).get_value());
                    } else {
                        return Some((*self.head.take().unwrap()).get_value());
                    }
                } else {
                    previous_node_ptr = current_node_ptr;
                    current_node_ptr = (*node).get_next();
                }
            }
        }
        None
    }

    fn get_vec_of_elements(&self) -> Vec<Option<*mut LinkedListNode<E>>> {
        vec![]
    }

    // This makes all our lists Iterables<E> (java interface)
    fn iterator(&self) -> LinkedListIterator<E> {
        match self.head {
            Some(head_ptr) => LinkedListIterator::new(Some(head_ptr as *const LinkedListNode<E>)),
            None => LinkedListIterator::new(None)
        }
    }
}
