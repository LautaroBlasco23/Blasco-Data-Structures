// For this implementation I followed three different version 
// to get a fully understand of the structure, bc Rust's safety
// rules make this ds a bit difficult.
// So I based on two Rust programmers: Tim Mcnamara and 
// Ryan Levick. and in the Too many linked list book.

pub mod first;
pub mod second;

use first::DoublyLinkedList;

fn main() {
    // Testing Tim's linked list:
    let mut tim_list = DoublyLinkedList::<char>::new();
   
    tim_list.append('a');
    tim_list.append('b');
    tim_list.append('T');

    println!("{:?}", tim_list);
}
