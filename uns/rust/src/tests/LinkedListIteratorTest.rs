#[allow(unused_imports)]
use crate::implementations::LinkedList::LinkedList;
#[allow(unused_imports)]
use crate::implementations::LinkedListIterator::LinkedListIterator;

#[allow(unused_imports)]
use crate::interfaces::LinkedListInterface::LinkedListInterface;
#[allow(unused_imports)]
use crate::interfaces::LinkedListIteratorInterface::LinkedListIteratorInterface;

#[test]
fn iterator_creation_and_empty_tests() {
    let new_linked_list: LinkedList<i32> = LinkedList::new();
    let mut iterator = new_linked_list.iterator();

    assert_eq!(iterator.has_next(), false);
    assert_eq!(iterator.next(), None);
}

#[test]
fn iterator_with_10_elements() {
    let mut new_linked_list: LinkedList<i32> = LinkedList::new();

    for i in 1..=10 {
        new_linked_list.push_back(i);
    }

    let mut iterator = new_linked_list.iterator();

    // The 10 elements in the iterator will be showed up
    for i in 1..=10 {
        assert_eq!(iterator.has_next(), true);
        assert_eq!(iterator.next(), Some(&i));
    }

    // There's no more elements in the iterator
    for _ in 1..=5 {
        assert_eq!(iterator.has_next(), false);
        assert_eq!(iterator.next(), None);
    }
}
