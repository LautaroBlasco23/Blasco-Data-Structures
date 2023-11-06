pub trait LinkedListNodeInterface<E> {
    // constructor 
    fn new(element: E) -> Self;
    // setters
    fn set_value(&mut self, value: E);
    fn set_next(&mut self, next: Option<*mut Self>);

    // getters
    fn get_value(&self) -> &E;
    fn get_next(&self) -> Option<*mut Self>;
}
