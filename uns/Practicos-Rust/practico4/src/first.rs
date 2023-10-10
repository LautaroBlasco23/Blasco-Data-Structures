// In this file we have a linked list developed by tim mcnamara

use std::cell::RefCell;
use std::rc::Rc;
use std::rc::Weak;

type Link<T> = Option<Rc<RefCell<Node<T>>>>;
type WeakLink<T> = Option<Weak<RefCell<Node<T>>>>;

#[derive(Debug)]
struct Node<T> {
    value: T,
    next: Link<T>,
    prev: WeakLink<T>,
}

impl<T> Node<T> {
    // We always will initialize the node with None Links/pointers.
    fn new(value: T) -> Rc<RefCell<Self>> {
        Rc::new(RefCell::new(Node {
            value,
            next: None,
            prev: None,
        }))
    }
}

#[derive(Debug)]
pub struct DoublyLinkedList<T> {
    head: Link<T>,
    tail: WeakLink<T>,
}

impl<T> DoublyLinkedList<T> {
    pub fn new() -> Self {
        DoublyLinkedList { 
            head: None,
            tail: None, 
        }
    }

    pub fn append(&mut self, value: T) {
        let new_node = Node::new(value);

        match self.tail.take() {
            Some(old_tail) => {
                let strong = old_tail.upgrade().unwrap();
                strong.borrow_mut().next = Some(Rc::clone(&new_node));
                new_node.borrow_mut().prev = Some(Rc::downgrade(&strong));
            },
            None => {
                self.head = Some(Rc::clone(&new_node));
            }
        }

        self.tail = Some(Rc::downgrade(&new_node));
    }
}
