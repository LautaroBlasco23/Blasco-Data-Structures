pub trait EntryInterface<K,V> {
    fn new(key: K, value: V) -> Self;
    fn get_value(&self) -> &K;
    fn get_key(&self) -> &V;
    fn set_value(&mut self, new_value: V) -> &V;

}
