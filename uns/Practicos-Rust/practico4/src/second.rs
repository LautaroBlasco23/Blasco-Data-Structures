pub struct Node<T> {
    element: T,
    next: Link<T>,
}

pub type Link<T> = Option<Box<Node<T>>>;

pub struct LinkedList<T> {
    head: Link<T>,
}

impl<T> LinkedList<T> {
    fn empty() -> LinkedList<T> {
        LinkedList {
            head: None
        }
    }

    fn push(&mut self, element: T) {
        match self.head.take() {
            None => {
                self.head = Some(Box::new((Node {
                    element,
                    next: None
                })))
            },
            Some(node) => {
                let new_head = Some(Box::new(Node {
                    element,
                    next: Some(node),
                }));
                self.head = new_head;
            }
        }
    }

    fn pop(&mut self) -> Option<T>{
        match self.head.take() {
            Some(old_head) => {
                self.head = old_head.next;
                Some(old_head.element)
            }
            None => None        
        }
    }

    fn peek(&mut self) -> Option<&T>{
        // Using map method for Option type.
        self.head.as_ref().map(|n| &n.element)
    }
}

