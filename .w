use super::NodoDE::{NodoPtr, NodoDE};
use std::{rc::Rc, cell::RefCell, thread::current};

#[derive(Debug)]
pub struct ListaDE<T: PartialEq + Copy> {
    head: NodoPtr<T>,
    tail: NodoPtr<T>,
    size: usize,
}

impl<T: PartialEq + Copy> ListaDE<T> {
    pub fn new() -> Self {
        Self {
            head: None,
            tail: None,
            size: 0,
        }
    }

    pub fn push_head(&mut self, value: T) {
        let new_node = Rc::new(RefCell::new(NodoDE::new(value)));
        match self.head.take() {
            Some(old_head) => {
                old_head.borrow_mut().set_prev(Some(Rc::clone(&new_node)));
                new_node.borrow_mut().set_next(Some(old_head));
                self.head = Some(new_node);
            }
            None => {
                self.head = Some(Rc::clone(&new_node));
                self.tail = Some(new_node);
            }
        }
    }

    pub fn push_tail(&mut self, value: T) {
        let new_node = Rc::new(RefCell::new(NodoDE::new(value)));
        match self.tail.take() {
            Some(old_tail) => {
                old_tail.borrow_mut().set_next(Some(Rc::clone(&new_node)));
                (*new_node).borrow_mut().set_prev(Some(old_tail));
                self.tail = Some(new_node);
            }
            None => {
                self.head = Some(Rc::clone(&new_node));
                self.tail = Some(new_node);
            }
        }
    }

    pub fn push_next(&mut self, nodo: NodoDE<T>) {
        match &self.head {
            Some(ptr) => {
                let mut current_node = ptr.borrow_mut(); 
                if current_node.equals(&nodo) {
                    current_node.set_next(Some(Rc::new(RefCell::new(nodo))));
                    mut nodo.set_prev(Some(Rc::new(RefCell::new(*current_node))));
                }
            }
            None => {}
        }
    }
}


