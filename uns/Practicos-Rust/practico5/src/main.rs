use std::fmt::Display;

trait Entry<K, V> {
    fn get_key(&self) -> &K;
    fn get_value(&self) -> &V;
}

pub struct Entrada<K, V> {
    clave: K,
    valor: V,
}

impl<K: Display, V: Display> Entrada<K, V> {
    fn new(clave: K, valor: V) -> Entrada<K, V> {
        Entrada { 
            clave, 
            valor,
        }
    }

    // setters
    fn set_key(&mut self, clave: K) {
        self.clave = clave;
    }

    fn set_value(&mut self, value: V) {
        self.valor = value;
    }

    fn to_string(&self) -> String {
        format!("{} : {}", self.clave, self.valor)
    }
}

impl<K, V> Entry<K, V> for Entrada<K, V> {
    // getters 
    fn get_key(&self) -> &K {
        &self.clave
    } 

    fn get_value(&self) -> &V {
        &self.valor
    }
}

// I'm going to implement the map using a vec to store the data we have.
pub struct MiMap<K, V> {
    size: i32,
    elements: Vec<Entrada<K,V>>
}

pub trait Map<K, V> {
    fn size(&self) -> i32;
    fn is_empty(&self) -> bool;
    fn get(&self, key: K) -> Option<V>;
    fn put(&self, key: K, value: V) -> Option<V>;
    fn remove(&self, key: K) -> Option<V>;
    /* Todas estas funciones dependen de la struct MapIterable, la cual permite iterar los valores.
    fn values() -> MapIterable <- 
    fn keys() -> MapIterable 
    fn entries() -> MapIterable
    */
}

impl<K: PartialEq + Display, V: PartialEq + Display> Map<K, V> for MiMap<K, V> {
    fn size(&self) -> i32 {
        self.size
    }

    fn is_empty(&self) -> bool {
        self.size == 0
    }

    fn get(&self, key: K) -> Option<V> {
        for entrada in &self.elements {
            if *entrada.get_key() == key {
                return Some(*entrada.get_value());
            }
        }
        None
    }

    fn put(&self, key: K, value: V) -> Option<V> {
        for mut entrada in &self.elements {
            if *entrada.get_key() == key {
                let mut previous_value = *entrada.get_value();
                *entrada.set_value(value);
                return Some(previous_value);
            }
        }
        None
    }
}

fn main() {
    
}
