#[allow(unused_imports)]
use crate::implementations::LinkedListNode::LinkedListNode;
#[allow(unused_imports)]
use crate::implementations::LinkedList::LinkedList;
#[allow(unused_imports)]
use crate::interfaces::LinkedListInterface::LinkedListInterface;
#[allow(unused_imports)]
use crate::interfaces::LinkedListNodeInterface::LinkedListNodeInterface;

#[test]
fn push_front() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();
    assert_eq!(new_linked_list.get_size(), 0);

    new_linked_list.push_front(1);
    new_linked_list.push_front(2);
    new_linked_list.push_front(3);
    new_linked_list.push_front(4);

    assert_eq!(new_linked_list.get_size(), 4);
}

#[test]
fn push_back() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();
    assert_eq!(new_linked_list.get_size(), 0);

    for i in 0..10 {
        new_linked_list.push_back(i);
    }
    
    for i in 0..10 {
        assert_eq!(new_linked_list.pop_front(), Some(&i));
    }

}

#[test]
fn pop_back() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();

    new_linked_list.push_front(1);
    assert_eq!(new_linked_list.pop_back().unwrap(), &1);
    
    for i in 1..=100 {
        new_linked_list.push_front(i);
    }
    for i in 1..=100 {
        assert_eq!(new_linked_list.pop_back().unwrap(), &i);
    }
}

#[test]
fn size() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();
    // size in a new list must be 0.
    assert_eq!(new_linked_list.get_size(), 0);

    // pushing 100 elements
    for i in 1..=100 {
        new_linked_list.push_front(i);
    }
    // size have to be 100
    assert_eq!(new_linked_list.get_size(), 100);

    // poping 50 elements
    for _ in 1..=50 {
        new_linked_list.pop_back();
    }
    // size have to be 50
    assert_eq!(new_linked_list.get_size(), 50);
}

#[test]
fn pop_front() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();
    // size in a new list must be 0.
    assert_eq!(new_linked_list.get_size(), 0);

    // pushing 100 elements
    for i in 1..=100 {
        new_linked_list.push_front(i);
    }

    // Popping all the elements in the inversed order they were inserted. 
    for i in (1..=100).rev() {
        assert_eq!(new_linked_list.pop_front(), Some(&i));
    }
}

#[test]
fn pop_element() {
    let mut new_linked_list: LinkedList<isize> = LinkedList::new();

    new_linked_list.push_front(1);
    new_linked_list.push_front(2);

    assert_eq!(new_linked_list.pop_element(1), Some(&1));
    assert_eq!(new_linked_list.pop_element(2), Some(&2));
    assert_eq!(new_linked_list.pop_element(2), None);
}

