#[allow(unused_imports)]
use crate::implementations::LinkedListNode::LinkedListNode;
#[allow(unused_imports)]
use crate::interfaces::LinkedListNodeInterface::LinkedListNodeInterface;

#[test]
fn new_function() {
    let new_node = LinkedListNode::new(1);
    assert_eq!(new_node.get_value(), &1);
}

#[test]
fn next_node_prt() {
    let mut new_node = LinkedListNode::new(1);
    unsafe {
        let other_node_ptr = Box::into_raw(Box::new(LinkedListNode::new(2)));
        new_node.set_next(Some(other_node_ptr));
        assert_eq!(&other_node_ptr, &new_node.get_next().unwrap());
        assert_eq!((*other_node_ptr).get_value(), (*new_node.get_next().unwrap()).get_value());
    }
}

#[test]
fn node_value() {
    let mut new_node = LinkedListNode::new(1);
    assert_eq!(new_node.get_value(), &1);
    new_node.set_value(2);
    assert_eq!(new_node.get_value(), &2);
}
