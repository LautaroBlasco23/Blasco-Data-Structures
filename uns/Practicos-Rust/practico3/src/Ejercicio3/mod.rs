// Para este ejercicio, use la colección "VecDeque", que está en el std de Rust. Para simplificar la tarea.
use std::collections::VecDeque;

// Función pedida en el ejercicio.
fn devolver_producto<T>(cola1: &mut VecDeque<T>, cola2: &mut VecDeque<T>) -> VecDeque<T> {
    // Creo una cola de retorno, y me aseguro de que existan elementos en alguna de las dos colas que entran por parametro
    let mut cola_retorno: VecDeque<T> = VecDeque::with_capacity(cola1.len() + cola2.len());
    let mut hay_elementos: bool = !cola1.is_empty() || !cola2.is_empty();

    while hay_elementos {
        if !cola1.is_empty() {
            cola_retorno.push_back(cola1.pop_front().unwrap());
        }

        if !cola2.is_empty() {
            cola_retorno.push_back(cola2.pop_front().unwrap());
        }

        hay_elementos = !cola1.is_empty() || !cola2.is_empty();
    }   

    cola_retorno
}

fn test() {
    let mut cola1: VecDeque<i32> = VecDeque::with_capacity(10 as usize);

    // Agrego 10 numeros a la cola.
    for i in 1..=10 {
        cola1.push_back(i);
    }

    let mut cola2: VecDeque<i32> = VecDeque::with_capacity(5 as usize);

    for i in 3000..=3004 {
        cola2.push_back(i);
    }


    // Testeo
    println!("Cola 1:");
    println!("{:?}", cola1);
    println!("");

    println!("Cola 2:");
    println!("{:?}", cola2);
    println!("");

    let cola_resultado = devolver_producto(&mut cola1, &mut cola2);
    println!("cola resultado");
    println!("{:?}", cola_resultado);
}
