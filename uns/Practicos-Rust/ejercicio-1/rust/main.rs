// Creo la estructura Persona. Como lo pide el ejercicio.
#[derive(Debug, Clone)]
struct Persona {
    nombre: String,
}

impl Persona {
    pub fn new(nombre: &str) -> Persona {
        Persona {
            nombre: String::from(nombre),
        }
    }
}

// Creo la estructura Stack, con los métodos push, pop y is_empty para este ejercicio.
struct Stack {
    elementos: Vec<Persona>,
    top: i8,
}

impl Stack {
    pub fn new(capacity: usize) -> Stack {
        Stack {
            elementos: Vec::with_capacity(capacity),
            top: -1,
        }
    }

    pub fn push(&mut self, persona: Persona) {
        self.elementos.push(persona);
        self.top += 1;
    }

    pub fn pop(&mut self) -> Persona {
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
}

#[allow(non_snake_case)]
fn Invertir(mi_arreglo: &mut [Persona]) {
    let mut mi_stack = Stack::new(10 as usize);

    
    for i in 0..5 {
        mi_stack.push(mi_arreglo[i].clone());
    }

    let mut indice = 0;
    while !mi_stack.is_empty() {
        mi_arreglo[indice] = mi_stack.pop();
        indice += 1;
    }
}


fn main() {
    // Creo el arreglo con 5 Personas.
    let mut mi_arreglo = [
        Persona::new("Jorge"),
        Persona::new("Lautaro"),
        Persona::new("Tomas"),
        Persona::new("Sebastian"),
        Persona::new("Andres"),
    ];

    // Invierto el arreglo, escribiendo por consola el antes y después.
    println!("{:?}", mi_arreglo);
    Invertir(&mut mi_arreglo);
    println!("{:?}", mi_arreglo);
}