#[derive(Debug)]
struct Queue<T> {
    elementos: Vec<T>,
    top: i32,
    max: usize,
}

impl<T> Queue<T> {
    pub fn new(max: usize) -> Queue<T> {
        Queue {
            elementos: Vec::with_capacity(max),
            top: -1,
            max: max,
        }
    }

    pub fn add(&mut self, element: T) {
        if self.top < self.max as i32 {
            self.elementos.push(element);
            self.top += 1;
        }
    }

    pub fn remove(&mut self) -> T {
        self.top -= 1;
        self.elementos.pop().unwrap()
    }

    pub fn is_empty(&self) -> bool {
        if self.top == -1 {
            true
        } else {
            false
        }
    }

    pub fn length(&self) -> usize {
        self.max
    }
}

fn solo_impares(cola: &mut Queue<i32>) {
    let mut nueva_cola: Queue<i32> = Queue::new(cola.length());
    
    while !cola.is_empty() {
        let elemento = cola.remove();
        if elemento % 2 == 1 {
            nueva_cola.add(elemento);
        }
    }

    while !nueva_cola.is_empty() {
        cola.add(nueva_cola.remove())
    }
}

fn main() {
    let mut cola: Queue<i32> = Queue::new(10 as usize);

    for i in 1..=11 {
        cola.add(i);
    }

    println!("{:?}", cola);
    solo_impares(&mut cola);
    println!("{:?}", cola);
}